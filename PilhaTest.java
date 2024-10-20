import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class PilhaTest {

    private Pilha pilha;
    private Filme_IF filme1;
    private Filme_IF filme2;

    @Before
    public void setUp() {
        pilha = new Pilha();
        filme1 = new Filme(1, "Filme 1", 8, 2020);
        filme2 = new Filme(2, "Filme 2", 7, 2021);
    }

    @Test
    public void testPush() throws Exception {
        pilha.push(filme1);
        assertFalse(pilha.isEmpty());
        assertEquals(filme1, pilha.top());
    }

    @Test
    public void testPop() throws Exception {
        pilha.push(filme1);
        pilha.push(filme2);

        assertEquals(filme2, pilha.pop());
        assertEquals(filme1, pilha.top());
    }

    @Test(expected = Exception.class)
    public void testPopEmptyStack() throws Exception {
        pilha.pop();
    }

    @Test(expected = Exception.class)
    public void testTop() throws Exception {
        pilha.push(filme1);
        pilha.push(filme2);

        assertEquals(filme2, pilha.top());
    }

    @Test(expected = Exception.class)
    public void testTopEmptyStack() throws Exception {
        pilha.top();
    }

    @Test
    public void testIsEmpty() throws Exception {
        pilha.push(filme1);
        assertFalse(pilha.isEmpty());

        pilha.pop();
        assertTrue(pilha.isEmpty());
    }
}
