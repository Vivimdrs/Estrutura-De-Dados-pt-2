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
    
    
}
