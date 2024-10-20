public class Main {
    public static void main(String[] args) {
        FilaTest fila = new FilaTest();
        PilhaTest pilha = new PilhaTest();
        BSTTest bts = new BSTTest();
        ListaTest lista = new ListaTest();

        try {
            fila.setUp();
            fila.testEnqueueDequeue();
            fila.testHead();
            fila.testDequeueEmptyFila();
            fila.testHeadEmptyFila();
            System.out.println("Todos os testes para fila executados com sucesso.");
        } catch (Exception e) {
            System.err.println("Erro ao executar os testes para fila: " + e.getMessage());
        }

        try {
            pilha.setUp();
            pilha.testPush();
            pilha.testPop();
            pilha.testPopEmptyStack();
            pilha.testTop();
            pilha.testTopEmptyStack();
            pilha.testIsEmpty();

            System.out.println("Todos os testes para pilha executados com sucesso.");
        } catch (Exception e) {
            System.err.println("Erro ao executar os testes para pilha: " + e.getMessage());
        }

        try {
            bts.setUp();
            bts.testInsertAndSearch();
            bts.testRemove();
            bts.testHeight();
            bts.testIsEmpty();
            bts.testSize();
            bts.testIsComplete();
            bts.testTraversal();
            System.out.println("Todos os testes para bts executados com sucesso.");
        } catch (Exception e) {
            System.err.println("Erro ao executar os testes para bts: " + e.getMessage());
        }

        try {
            lista.setUp();
            lista.testAddLast();
            lista.testRemoveLast();
            lista.testRemoveLastFromEmptyList();
            lista.testIsEmpty();
            lista.testSize();
            lista.testGetLast();
            lista.testGetLastFromEmptyList();
            System.out.println("Todos os testes para lista executados com sucesso.");
        } catch (Exception e) {
            System.err.println("Erro ao executar os testes para lista: " +
                    e.getMessage());
        }
    }
}
