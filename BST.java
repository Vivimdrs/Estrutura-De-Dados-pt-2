public class BST {
    private Node root;

    // Classe interna para representar um nó
    private static class Node {
        Filme_IF filme;
        Node left, right;

        Node(Filme_IF filme) {
            this.filme = filme;
            left = right = null;
        }
    }

    // Método para inserir um filme na árvore
    public void insert(Filme_IF filme) throws Exception {
        root = insertNode(root, filme);
    }

    // Método auxiliar para inserir um nó
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

    // Método para buscar um filme na árvore
    public Filme_IF search(int id) throws Exception {
        return searchNode(root, id);
    }

    // Método auxiliar para buscar um nó
    private Filme_IF searchNode(Node node, int id) throws Exception {
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

    // Método para remover um filme da árvore
    public Filme_IF remove(int id) throws Exception {
        RootNodeResult result = removeNode(root, id);
        root = result.node; // Atualiza a raiz da árvore
        return result.filme; // Retorna o filme removido
    }

    // Método auxiliar para remover um nó
    private RootNodeResult removeNode(Node node, int id) throws Exception {
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
            filme = node.filme; // Filme encontrado
            if (node.left == null) {
                return new RootNodeResult(node.right, filme);
            } else if (node.right == null) {
                return new RootNodeResult(node.left, filme);
            }
            // Nó com dois filhos: obtenha o menor no lado direito
            node.filme = findMin(node.right);
            node.right = removeNode(node.right, node.filme.getID()).node;
        }
        return new RootNodeResult(node, filme);
    }

    // Método auxiliar para encontrar o menor filme
    private Filme_IF findMin(Node node) {
        while (node.left != null) {
            node = node.left;
        }
        return node.filme;
    }

    // Método para calcular a altura da árvore
    public int height() {
        return height(root);
    }

    // Método auxiliar para calcular a altura de um nó
    private int height(Node node) {
        if (node == null) {
            return -1; // Se o nó for nulo, a altura é -1
        }
        int leftHeight = height(node.left);
        int rightHeight = height(node.right);
        return Math.max(leftHeight, rightHeight) + 1; // Retorna a maior altura + 1
    }

    // Método para verificar se a árvore está vazia
    public boolean isEmpty() {
        return root == null;
    }

    // Método para obter o tamanho da árvore
    public int size() {
        return size(root);
    }

    // Método auxiliar para calcular o tamanho da árvore
    private int size(Node node) {
        if (node == null) {
            return 0;
        }
        return 1 + size(node.left) + size(node.right);
    }

    // Método para verificar se a árvore é completa
    public boolean isComplete() {
        return isComplete(root, 0, size());
    }

    // Método auxiliar para verificar se a árvore é completa
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

    // Método para percorrer a árvore em pré-ordem
    public Filme_IF[] preOrder() {
        List<Filme_IF> result = new ArrayList<>();
        preOrder(root, result);
        return result.toArray(new Filme_IF[0]);
    }

    // Método auxiliar para percorrer a árvore em pré-ordem
    private void preOrder(Node node, List<Filme_IF> result) {
        if (node != null) {
            result.add(node.filme);
            preOrder(node.left, result);
            preOrder(node.right, result);
        }
    }

    // Método para percorrer a árvore em ordem
    public Filme_IF[] order() {
        List<Filme_IF> result = new ArrayList<>();
        order(root, result);
        return result.toArray(new Filme_IF[0]);
    }

    // Método auxiliar para percorrer a árvore em ordem
    private void order(Node node, List<Filme_IF> result) {
        if (node != null) {
            order(node.left, result);
            result.add(node.filme);
            order(node.right, result);
        }
    }

    // Método para percorrer a árvore em pós-ordem
    public Filme_IF[] postOrder() {
        List<Filme_IF> result = new ArrayList<>();
        postOrder(root, result);
        return result.toArray(new Filme_IF[0]);
    }

    // Método auxiliar para percorrer a árvore em pós-ordem
    private void postOrder(Node node, List<Filme_IF> result) {
        if (node != null) {
            postOrder(node.left, result);
            postOrder(node.right, result);
            result.add(node.filme);
        }
    }

    // Classe auxiliar para retornar o nó e o filme removido
    private static class RootNodeResult {
        Node node;
        Filme_IF filme;

        RootNodeResult(Node node, Filme_IF filme) {
            this.node = node;
            this.filme = filme;
        }
    }
}
