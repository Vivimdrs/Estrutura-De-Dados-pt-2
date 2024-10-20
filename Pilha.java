public class Pilha implements Pilha_IF{
    private ListaDuplamenteEncadeada list;

    Pilha(){
        this.list = new ListaDuplamenteEncadeada();
    }

    public boolean isEmpty(){
       return list.isEmpty();
    }

    @Override
    public void push(Filme_IF elemento){
        list.insert(elemento);
    }
    @Override
    public Filme_IF pop() throws Exception{
        if(list.isEmpty()){
            throw new Exception("Vazio");
        }
        return list.remove(0);
    }
    @Override
    public Filme_IF top() throws Exception{
        return list.getLast();
    }
    

}
    
    
