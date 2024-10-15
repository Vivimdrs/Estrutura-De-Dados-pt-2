public class Fila implements Fila_IF{
    protected Pilha p1;
    protected Pilha p2;

    Fila(Pilha p1, Pilha p2){
        this.p1 = new Pilha();
        this.p2 = new Pilha();
    }
    @Override
    public boolean isEmpty(){
        return p1.isEmpty() && p2.isEmpty();
    }
    public void enqueue(Filme_IF elemento){
        p1.push(elemento);
    }
    public Filme_IF dequeue() throws Exception{
        if(!isEmpty()){
            throw new Exception("Vazio");
        }
        if(p2.isEmpty()){
            while(!p1.isEmpty()){
                p2.push(p1.pop());
            }
        }
        return p2.pop();
    }
    @Override
    public Filme_IF head() throws Exception{
        if(isEmpty()){
            throw new Exception("Fila vazia");
        }
        if(p2.isEmpty()){
            while(!p1.isEmpty()){
                p2.push(p1.pop());
            }
        }
        return p2.top();
    }
    
}
