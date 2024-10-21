import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class BSTTest {
    private BST tree;

    @Before
    public void setUp() {
        tree = new BST();
    }

    @Test
    public void testInsertAndSearch() throws Exception {
        Filme_IF filme1 = new Filme(1, "Filme A", 5, 2020);
        Filme_IF filme2 = new Filme(2, "Filme B", 7, 2021);
        Filme_IF filme3 = new Filme(3, "Filme C", 6, 2019);

        tree.insert(filme1);
        tree.insert(filme2);
        tree.insert(filme3);

        assertEquals(filme1, tree.search(1));
        assertEquals(filme2, tree.search(2));
        assertEquals(filme3, tree.search(3));

        assertEquals(filme1, tree.remove(1));
        assertThrows(Exception.class, () -> tree.search(1));
    }

    @Test
    public void testRemove() throws Exception {
        Filme_IF filme1 = new Filme(1, "Filme A", 5, 2020);
        Filme_IF filme2 = new Filme(2, "Filme B", 7, 2021);
        Filme_IF filme3 = new Filme(3, "Filme C", 6, 2019);

        tree.insert(filme1);
        tree.insert(filme2);
        tree.insert(filme3);

        assertEquals(filme1, tree.remove(1));
        assertThrows(Exception.class, () -> tree.search(1));
    }

    @Test
    public void testHeight() throws Exception {
        assertEquals(-1, tree.height());

        Filme_IF filme1 = new Filme(1, "Filme A", 5, 2020);
        tree.insert(filme1);
        assertEquals(0, tree.height());

        Filme_IF filme2 = new Filme(2, "Filme B", 7, 2021);
        tree.insert(filme2);
        Filme_IF filme3 = new Filme(3, "Filme C", 6, 2019);
        tree.insert(filme3);
        assertEquals(2, tree.height());
    }

    @Test
    public void testIsEmpty() throws Exception {
        assertTrue(tree.isEmpty());
        tree.insert(new Filme(1, "Filme A", 5, 2020));
        assertFalse(tree.isEmpty());
    }

    @Test
    public void testSize() throws Exception {
        assertEquals(0, tree.size());
        tree.insert(new Filme(1, "Filme A", 5, 2020));
        tree.insert(new Filme(2, "Filme B", 7, 2021));
        assertEquals(2, tree.size());
    }

    @Test
    public void testIsComplete() throws Exception {
        assertTrue(tree.isComplete());
        tree.insert(new Filme(1, "Filme A", 5, 2020));
        assertTrue(tree.isComplete());
        tree.insert(new Filme(2, "Filme B", 7, 2021));
        assertFalse(tree.isComplete());
    }

    @Test
    public void testTraversal() throws Exception {
        Filme_IF filme1 = new Filme(1, "Filme A", 5, 2020);
        Filme_IF filme2 = new Filme(2, "Filme B", 7, 2021);
        Filme_IF filme3 = new Filme(3, "Filme C", 6, 2019);

        tree.insert(filme1);
        tree.insert(filme2);
        tree.insert(filme3);

        assertArrayEquals(new Filme_IF[] { filme1, filme2, filme3 }, tree.order());
    }
}
