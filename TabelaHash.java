<<<<<<< HEAD
import org.junit.internal.runners.statements.ExpectException;
import org.junit.runner.OrderWith;

public class TabelaHash implements TabelaHash_IF {
    protected ListaDuplamenteEncadeada lista;

    TabelaHash(){
        this.lista = new ListaDuplamenteEncadeada();
    }

    @Override
    public Filme_IF remove(long id) throws Exception{
        if(isEmpty()){
            throw new Exception("Vazio");
        }
        return lista.remove(id);
    }
    public void insert(Filme_IF elemento){
        lista.insert(elemento);
    }
    public boolean isEmpty(){
        return lista.isEmpty();
    }
    public Filme_IF search(long id) throws Exception{
        if () {
            
        }
    }
    
    
=======
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class TabelaHash implements TabelaHash_IF {
    private static class HashNode {
        Filme_IF filme;

        HashNode(Filme_IF filme) {
            this.filme = filme;
        }
    }

    private List<LinkedList<HashNode>> table;
    private int size;
    private static final int INITIAL_CAPACITY = 16;

    public TabelaHash() {
        table = new ArrayList<>(INITIAL_CAPACITY);
        for (int i = 0; i < INITIAL_CAPACITY; i++) {
            table.add(new LinkedList<>());
        }
        size = 0;
    }

    @Override
    public void insert(Filme_IF elemento) {
        int index = hash(elemento.getID());
        LinkedList<HashNode> bucket = table.get(index);

        for (HashNode node : bucket) {
            if (node.filme.getID() == elemento.getID()) {
                throw new IllegalArgumentException("Filme já existe na tabela hash.");
            }
        }

        bucket.add(new HashNode(elemento));
        size++;
    }

    @Override
    public Filme_IF remove(long id) throws Exception {
        int index = hash(id);
        LinkedList<HashNode> bucket = table.get(index);

        for (HashNode node : bucket) {
            if (node.filme.getID() == id) {
                bucket.remove(node);
                size--;
                return node.filme;
            }
        }

        throw new Exception("Filme não encontrado.");
    }

    @Override
    public Filme_IF search(long id) throws Exception {
        int index = hash(id);
        LinkedList<HashNode> bucket = table.get(index);

        for (HashNode node : bucket) {
            if (node.filme.getID() == id) {
                return node.filme;
            }
        }

        throw new Exception("Filme não encontrado.");
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public String print() {
        StringBuilder result = new StringBuilder();
        for (LinkedList<HashNode> bucket : table) {
            for (HashNode node : bucket) {
                result.append(node.filme).append("\n");
            }
        }
        return result.toString();
    }

    private int hash(long id) {
        return (int) (id % table.size());
    }
>>>>>>> cbd30e2ea182b0bd5d184ca6d4f9df5a0cd474b0
}
