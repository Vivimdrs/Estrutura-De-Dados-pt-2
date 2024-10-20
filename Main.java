public class Main {
    public static void main(String[] args) {
        // BSTTest bts = new BSTTest();
        FilaTest fila = new FilaTest();
        // ListaTest lista = new ListaTest();
        PilhaTest pilha = new PilhaTest();

        try {
            // bts.setUp();
            // bts.testInsertAndSearch();
            // bts.testRemove();
            // bts.testHeight();
            // bts.testIsEmpty();
            // bts.testSize();
            // bts.testIsComplete();
            // bts.testTraversal();
            System.out.println("Todos os testes executados com sucesso.");
        } catch (Exception e) {
            System.err.println("Erro ao executar os testes: " + e.getMessage());
        }

        try {
            fila.setUp();
            fila.testEnqueueDequeue();
            fila.testHead();
            fila.testDequeueEmptyFila();
            fila.testHeadEmptyFila();
            System.out.println("Todos os testes executados com sucesso.");
        } catch (Exception e) {
            System.err.println("Erro ao executar os testes: " + e.getMessage());
        }

        try {
            // lista.setUp();
            // lista.testAddLast();
            // lista.testRemoveLast();
            // lista.testRemoveLastFromEmptyList();
            // lista.testIsEmpty();
            // lista.testSize();
            // lista.testGetLast();
            // lista.testGetLastFromEmptyList();
            System.out.println("Todos os testes executados com sucesso.");
        } catch (Exception e) {
            System.err.println("Erro ao executar os testes: " + e.getMessage());
        }

        try {
            pilha.setUp();
            pilha.testPush();
            pilha.testPop();
            pilha.testPopEmptyStack();
            pilha.testTop();
            pilha.testTopEmptyStack();
            pilha.testIsEmpty();

            System.out.println("Todos os testes executados com sucesso.");
        } catch (Exception e) {
            System.err.println("Erro ao executar os testes: " + e.getMessage());
        }
    }
}
