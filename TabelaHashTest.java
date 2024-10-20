import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class TabelaHashTest {
    private TabelaHash tabela;
    private Filme_IF filme1;
    private Filme_IF filme2;
    private Filme_IF filme3;

    @Before
    public void setUp() {
        tabela = new TabelaHash();
        filme1 = new Filme(1, "Filme A", 5, 2020);
        filme2 = new Filme(2, "Filme B", 7, 2021);
        filme3 = new Filme(3, "Filme C", 6, 2019);
    }

    @Test
    public void testInsertAndSearch() throws Exception {
        tabela.insert(filme1);
        tabela.insert(filme2);

        assertEquals(filme1, tabela.search(1));
        assertEquals(filme2, tabela.search(2));
    }

    @Test
    public void testRemove() throws Exception {
        tabela.insert(filme1);
        tabela.insert(filme2);

        assertEquals(filme1, tabela.remove(1));
        assertThrows(Exception.class, () -> tabela.search(1)); // Filme removido não deve ser encontrado
    }

    @Test
    public void testRemoveNonExistentFilm() {
        assertThrows(Exception.class, () -> tabela.remove(999)); // Tentativa de remover um filme inexistente
    }

    @Test
    public void testSearchNonExistentFilm() {
        assertThrows(Exception.class, () -> tabela.search(999)); // Tentativa de buscar um filme inexistente
    }

    @Test
    public void testIsEmpty() {
        assertTrue(tabela.isEmpty());
        tabela.insert(filme1);
        assertFalse(tabela.isEmpty());
    }

    @Test
    public void testInsertDuplicateFilm() {
        tabela.insert(filme1);
        assertThrows(IllegalArgumentException.class, () -> tabela.insert(filme1)); // Tentativa de inserir filme
                                                                                   // duplicado
    }

    @Test
    public void testPrint() throws Exception {
        tabela.insert(filme1);
        tabela.insert(filme2);
        tabela.insert(filme3);

        String expectedOutput = filme1.toString() + "\n" + filme2.toString() + "\n" + filme3.toString() + "\n";
        assertEquals(expectedOutput, tabela.print());
    }
}
