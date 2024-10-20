public class Main {
    public static void main(String[] args) {
        BSTTest bts = new BSTTest();
        FilaTest fila = new FilaTest();

        try {
            bts.setUp(); 
            bts.testInsertAndSearch();
            bts.testRemove();
            bts.testHeight();
            bts.testIsEmpty();
            bts.testSize();
            bts.testIsComplete();
            bts.testTraversal();

            fila.setUp();
            fila.testEnqueueDequeue();
            fila.testHead();
            fila.testDequeueEmptyFila();
            fila.testHeadEmptyFila();

            System.out.println("Todos os testes executados com sucesso.");
        } catch (Exception e) {
            System.err.println("Erro ao executar os testes: " + e.getMessage());
        }
    }
}
