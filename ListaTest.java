import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class ListaTest {

    private ListaDuplamenteEncadeada lista;
    private Filme_IF filme1;
    private Filme_IF filme2;
    private Filme_IF filme3;

    @Before
    public void setUp() {
        lista = new ListaDuplamenteEncadeada();
        filme1 = new Filme(1, "Filme 1", 8, 2020);
        filme2 = new Filme(2, "Filme 2", 7, 2021);
        filme3 = new Filme(3, "Filme 3", 9, 2022);
    }

    @Test
    public void testAddLast() {
        lista.insert(filme1);
        lista.insert(filme2);

        try {
            assertEquals(filme2, lista.getLast());
            assertEquals(2, lista.size());
        } catch (Exception e) {
            fail("Erro ao obter o último elemento: " + e.getMessage());
        }
    }

    @Test
    public void testRemoveLast() throws Exception {
        ListaDuplamenteEncadeada lista = new ListaDuplamenteEncadeada();

        Filme_IF filme1 = new Filme(1, "Filme 1", 5, 2021);
        Filme_IF filme2 = new Filme(2, "Filme 2", 8, 2022);

        lista.insert(filme1);
        lista.insert(filme2);

        lista.remove(0);

        assertEquals(1, lista.size());
    }

    @Test
    public void testRemoveLastFromEmptyList() {
        assertTrue(lista.isEmpty());

        try {
            lista.remove(0);
            fail("Era esperado uma exceção ao remover de uma lista vazia.");
        } catch (Exception e) {
            assertEquals("A lista está vazia.", e.getMessage());
        }
    }

    @Test
    public void testIsEmpty() {
        assertTrue(lista.isEmpty());

        lista.insert(filme1);
        assertFalse(lista.isEmpty());
    }

    @Test
    public void testSize() {
        assertEquals(0, lista.size());

        lista.insert(filme1);
        lista.insert(filme2);

        assertEquals(2, lista.size());
    }

    @Test
    public void testGetLast() {
        lista.insert(filme1);
        lista.insert(filme2);

        try {
            assertEquals(filme2, lista.getLast());
        } catch (Exception e) {
            fail("Erro ao obter o último elemento: " + e.getMessage());
        }
    }

    @Test
    public void testGetLastFromEmptyList() {
        try {
            lista.getLast();
            fail("Era esperado uma exceção ao tentar obter de uma lista vazia.");
        } catch (Exception e) {
            assertEquals("A lista está vazia.", e.getMessage());
        }
    }
}
