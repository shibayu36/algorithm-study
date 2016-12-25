import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by shibayu36 on 2016/12/25.
 */
public class IntQueue1Test {
    @Test
    public void queue() throws Exception {
        IntQueue1 queue = new IntQueue1(3);

        queue.enqueue(10);
        queue.enqueue(5);
        queue.enqueue(3);

        assertEquals(10, queue.dequeue());
        assertEquals(2, queue.getSize());

        assertEquals(5, queue.dequeue());
        assertEquals(1, queue.getSize());

        queue.enqueue(4);
        assertEquals(2, queue.getSize());

        assertEquals(3, queue.dequeue());
        assertEquals(1, queue.getSize());

        assertEquals(4, queue.dequeue());
        assertEquals(0, queue.getSize());
    }

}