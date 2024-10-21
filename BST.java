import java.util.ArrayList;
import java.util.List;

public class BST {
    private Node root;

    private static class Node {
        Filme_IF filme;
        Node left, right;

        Node(Filme_IF filme) {
            this.filme = filme;
            left = right = null;
        }
    }


    public void insert(Filme_IF filme) throws Exception {
        root = insertNode(root, filme);
    }

    private Node insertNode(Node node, Filme_IF filme) throws Exception {
        if (node == null) {
            return new Node(filme);
        }
        if (filme.compareTo(node.filme) < 0) {
            node.left = insertNode(node.left, filme);
        } else if (filme.compareTo(node.filme) > 0) {
            node.right = insertNode(node.right, filme);
        } else {
            throw new Exception("Filme já existe na árvore");
        }
        return node;
    }

    public Filme_IF search(long id) throws Exception {
        return searchNode(root, id);
    }

    private Filme_IF searchNode(Node node, long id) throws Exception {
        if (node == null) {
            throw new Exception("Filme não encontrado");
        }
        if (node.filme.getID() == id) {
            return node.filme;
        } else if (id < node.filme.getID()) {
            return searchNode(node.left, id);
        } else {
            return searchNode(node.right, id);
        }
    }

    public Filme_IF remove(long id) throws Exception {
        RootNodeResult result = removeNode(root, id);
        root = result.node;
        return result.filme;
    }

    private RootNodeResult removeNode(Node node, long id) throws Exception {
        if (node == null) {
            throw new Exception("Filme não encontrado");
        }

        Filme_IF filme;
        if (id < node.filme.getID()) {
            RootNodeResult result = removeNode(node.left, id);
            node.left = result.node;
            filme = result.filme;
        } else if (id > node.filme.getID()) {
            RootNodeResult result = removeNode(node.right, id);
            node.right = result.node;
            filme = result.filme;
        } else {
            filme = node.filme;
            if (node.left == null) {
                return new RootNodeResult(node.right, filme);
            } else if (node.right == null) {
                return new RootNodeResult(node.left, filme);
            }

            node.filme = findMin(node.right);
            node.right = removeNode(node.right, node.filme.getID()).node;
        }
        return new RootNodeResult(node, filme);
    }

    private Filme_IF findMin(Node node) {
        while (node.left != null) {
            node = node.left;
        }
        return node.filme;
    }

    public int height() {
        return height(root);
    }

    private int height(Node node) {
        if (node == null) {
            return -1;
        }
        int leftHeight = height(node.left);
        int rightHeight = height(node.right);
        return Math.max(leftHeight, rightHeight) + 1;
    }

    public boolean isEmpty() {
        return root == null;
    }

    public int size() {
        return size(root);
    }

    private int size(Node node) {
        if (node == null) {
            return 0;
        }
        return 1 + size(node.left) + size(node.right);
    }

    public boolean isComplete() {
        return isComplete(root, 0, size());
    }

    private boolean isComplete(Node node, int index, int numberNodes) {
        if (node == null) {
            return true;
        }
        if (index >= numberNodes) {
            return false;
        }
        return isComplete(node.left, 2 * index + 1, numberNodes) &&
               isComplete(node.right, 2 * index + 2, numberNodes);
    }

    public Filme_IF[] preOrder() {
        List<Filme_IF> result = new ArrayList<>();
        preOrder(root, result);
        return result.toArray(new Filme_IF[0]);
    }

    private void preOrder(Node node, List<Filme_IF> result) {
        if (node != null) {
            result.add(node.filme);
            preOrder(node.left, result);
            preOrder(node.right, result);
        }
    }

    public Filme_IF[] order() {
        List<Filme_IF> result = new ArrayList<>();
        order(root, result);
        return result.toArray(new Filme_IF[0]);
    }

    private void order(Node node, List<Filme_IF> result) {
        if (node != null) {
            order(node.left, result);
            result.add(node.filme);
            order(node.right, result);
        }
    }

    public Filme_IF[] postOrder() {
        List<Filme_IF> result = new ArrayList<>();
        postOrder(root, result);
        return result.toArray(new Filme_IF[0]);
    }

    private void postOrder(Node node, List<Filme_IF> result) {
        if (node != null) {
            postOrder(node.left, result);
            postOrder(node.right, result);
            result.add(node.filme);
        }
    }

    private static class RootNodeResult {
        Node node;
        Filme_IF filme;

        RootNodeResult(Node node, Filme_IF filme) {
            this.node = node;
            this.filme = filme;
        }
    }
}
