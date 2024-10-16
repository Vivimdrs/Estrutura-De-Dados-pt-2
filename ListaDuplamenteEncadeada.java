

public class ListaDuplamenteEncadeada {
    // Classe interna Node para representar cada nó
    private class Node {
        Filme_IF filme;
        Node next;
        Node prev;

        Node(Filme_IF filme) {
            this.filme = filme;
            this.next = null;
            this.prev = null;
        }
    }

    private Node head;
    private Node tail;
    private int size;

    public ListaDuplamenteEncadeada() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    public void addLast(Filme_IF filme) {
        Node newNode = new Node(filme);
        if (isEmpty()) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
        size++;
    }

    public Filme_IF removeLast() throws Exception {
        if (isEmpty()) {
            throw new Exception("A lista está vazia.");
        }
        Filme_IF filmeRemovido = tail.filme;
        if (head == tail) {
            head = null;
            tail = null;
        } else {
            tail = tail.prev;
            tail.next = null;
        }
        size--;
        return filmeRemovido;
    }
    public Filme_IF getLast() throws Exception {
        if (isEmpty()) {
            throw new Exception("A lista está vazia.");
        }
        return tail.filme;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public int size() {
        return size;
    }
}

