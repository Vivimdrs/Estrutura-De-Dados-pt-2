public class Pilha implements Pilha_IF{
    private class Node{
       protected Filme_IF filme;
       protected Node prox;
       protected Node anterior;

       Node(Filme_IF filme){
        this.filme = filme;
        this.prox = null;
        this.anterior = null;
       }
    }
    private Node top;
    private int tam;

    Pilha(){

    }
    Pilha(Node top, int size){
        this.top = null;
        this.tam = 0;
    }

    public boolean isEmpty(){
        if(top == null){
            return true;
        }
        return false;
    }
    @Override
    public void push(Filme_IF elemento){
        Node novoNo = new Node(elemento);
        if(!isEmpty()){
            novoNo.prox = top;
        }
        top = novoNo;
        tam++;
    }
    @Override
    public Filme_IF pop() throws Exception{
        if(top == null){
            throw new Exception("Não possui filme.");
        }
        Filme_IF itemRemovido = top();
        top = top.prox;
        tam--;
        return itemRemovido;
    }
    @Override
    public Filme_IF top() throws Exception{
        if (top == null) {
            throw new Exception("Não possui filme.");
        }
        return top.filme;
    }

}
    
    
