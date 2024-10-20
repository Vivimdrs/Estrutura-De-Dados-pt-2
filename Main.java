public class Main {
    public static void main(String[] args) {
<<<<<<< HEAD
        BSTTest bts = new BSTTest();
=======
>>>>>>> cbd30e2ea182b0bd5d184ca6d4f9df5a0cd474b0
        FilaTest fila = new FilaTest();
        PilhaTest pilha = new PilhaTest();
        BSTTest bts = new BSTTest();
        ListaTest lista = new ListaTest();
        TabelaHashTest hash = new TabelaHashTest();

        try {
<<<<<<< HEAD
            bts.setUp(); 
            bts.testInsertAndSearch();
            bts.testRemove();
            bts.testHeight();
            bts.testIsEmpty();
            bts.testSize();
            bts.testIsComplete();
            bts.testTraversal();

=======
>>>>>>> cbd30e2ea182b0bd5d184ca6d4f9df5a0cd474b0
            fila.setUp();
            fila.testEnqueueDequeue();
            fila.setUp();
            fila.testHead();
            fila.setUp();
            fila.testDequeueEmptyFila();
            fila.setUp();
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
            pilha.setUp();
            pilha.testIsEmpty();

            System.out.println("Todos os testes para pilha executados com sucesso.");
        } catch (Exception e) {
            System.err.println("Erro ao executar os testes para pilha: " + e.getMessage());
        }

        try {
            bts.setUp();
            bts.testInsertAndSearch();
            bts.setUp();
            bts.testRemove();
            bts.setUp();
            bts.testHeight();
            bts.setUp();
            bts.testIsEmpty();
            bts.setUp();
            bts.testSize();
            bts.setUp();
            bts.testIsComplete();
            bts.setUp();
            bts.testTraversal();
            System.out.println("Todos os testes para bts executados com sucesso.");
        } catch (Exception e) {
            System.err.println("Erro ao executar os testes para bts: " + e.getMessage());
        }

        try {
            lista.setUp();
            lista.testAddLast();
            lista.setUp();
            lista.testRemoveLast();
            lista.setUp();
            lista.testRemoveLastFromEmptyList();
            lista.setUp();
            lista.testIsEmpty();
            lista.setUp();
            lista.testSize();
            lista.setUp();
            lista.testGetLast();
            lista.setUp();
            lista.testGetLastFromEmptyList();
            System.out.println("Todos os testes para lista executados com sucesso.");
        } catch (Exception e) {
            System.err.println("Erro ao executar os testes para lista: " +
                    e.getMessage());
        }

        try {
            hash.setUp();
            hash.testInsertAndSearch();
            hash.setUp();
            hash.testRemove();
            hash.setUp();
            hash.testRemoveNonExistentFilm();
            hash.setUp();
            hash.testSearchNonExistentFilm();
            hash.setUp();
            hash.testIsEmpty();
            hash.setUp();
            hash.testInsertDuplicateFilm();
            hash.setUp();
            hash.testPrint();

            System.out.println("Todos os testes para tabela hash executados com sucesso.");
        } catch (Exception e) {
            System.err.println("Erro ao executar os testes para tabela hash: " + e.getMessage());
        }
    }
}
