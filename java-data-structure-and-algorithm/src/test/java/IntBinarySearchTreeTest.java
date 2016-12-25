import org.junit.Test;

import static org.junit.Assert.*;

public class IntBinarySearchTreeTest {
    @Test
    public void insert() throws Exception {
        IntBinarySearchTree tree = new IntBinarySearchTree();
        tree.insert(3);
        tree.insert(5);
        tree.insert(2);
        tree.insert(8);

        assertTrue(tree.search(3));
        assertTrue(tree.search(5));
        assertTrue(tree.search(2));
        assertTrue(tree.search(8));
        assertFalse(tree.search(0));
        assertFalse(tree.search(1));
        assertFalse(tree.search(20));

        System.out.println(tree.toString());
    }
}