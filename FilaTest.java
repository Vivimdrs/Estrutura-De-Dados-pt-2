import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class FilaTest {

    private Fila fila;

    @Before
    public void setUp() {
        fila = new Fila(new Pilha(), new Pilha());
    }

    @Test
    public void testEnqueueDequeue() throws Exception {
        Fila fila = new Fila(new Pilha(), new Pilha());

        Filme filme1 = new Filme(1, "Filme A", 8, 2020);
        Filme filme2 = new Filme(2, "Filme B", 9, 2021);

        assertTrue(fila.isEmpty());

        fila.enqueue(filme1);
        fila.enqueue(filme2);

        assertFalse(fila.isEmpty());

        Filme_IF removido = fila.dequeue();
        assertEquals(filme1, removido);

        removido = fila.dequeue();
        assertEquals(filme2, removido);

        assertTrue(fila.isEmpty());
    }

    @Test
    public void testHead() throws Exception {
        Fila fila = new Fila(new Pilha(), new Pilha());

        Filme filme1 = new Filme(1, "Filme A", 8, 2020);
        Filme filme2 = new Filme(2, "Filme B", 9, 2021);

        fila.enqueue(filme1);
        fila.enqueue(filme2);

        Filme_IF primeiro = fila.head();
        assertEquals(filme1, primeiro);

        primeiro = fila.dequeue();
        assertEquals(filme1, primeiro);
    }

    @Test
    public void testDequeueEmptyFila() {
        Fila fila = new Fila(new Pilha(), new Pilha());

        Exception exception = assertThrows(Exception.class, () -> {
            fila.dequeue();
        });

        assertEquals("Vazio", exception.getMessage());
    }

    @Test
    public void testHeadEmptyFila() {
        Fila fila = new Fila(new Pilha(), new Pilha());

        Exception exception = assertThrows(Exception.class, () -> {
            fila.head();
        });

        assertEquals("Fila vazia", exception.getMessage());
    }
}
