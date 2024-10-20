public class Main {
    public static void main(String[] args) {
        BSTTest bts = new BSTTest();

        try {
            bts.setUp();
            bts.testInsertAndSearch();
            bts.testRemove();
            bts.testHeight();
            bts.testIsEmpty();
            bts.testSize();
            bts.testIsComplete();
            bts.testTraversal();

            System.out.println("Todos os testes executados com sucesso.");
        } catch (Exception e) {
            System.err.println("Erro ao executar os testes: " + e.getMessage());
        }
    }
}
