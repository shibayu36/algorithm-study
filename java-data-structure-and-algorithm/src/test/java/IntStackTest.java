import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by shibayu36 on 2016/12/23.
 */
public class IntStackTest {
    @Test
    public void stack() throws Exception {
        IntStack stack = new IntStack(3);
        assertTrue(stack.isEmpty());

        stack.push(10);
        stack.push(5);
        stack.push(3);

        assertTrue(stack.isFull());

        try {
            stack.push(1);
        } catch (RuntimeException e) {
            assertEquals("Stack is full", e.getMessage());
        }

        assertEquals(3, stack.pop());
        assertEquals(2, stack.size());

        assertEquals(5, stack.pop());
        assertEquals(1, stack.size());

        stack.push(4);
        assertEquals(2, stack.size());

        assertEquals(4, stack.pop());
        assertEquals(1, stack.size());

        assertEquals(10, stack.pop());
        assertEquals(0, stack.size());

        assertTrue(stack.isEmpty());

        try {
            stack.pop();
        } catch (RuntimeException e) {
            assertEquals("Stack is empty", e.getMessage());
        }
    }

}