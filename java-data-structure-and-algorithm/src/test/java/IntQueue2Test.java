import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by shibayu36 on 2016/12/25.
 */
public class IntQueue2Test {
    @Test
    public void queue() throws Exception {
        IntQueue2 queue = new IntQueue2(3);

        queue.enqueue(10);
        queue.enqueue(5);
        queue.enqueue(3);

        assertEquals(10, queue.dequeue());
        assertEquals(2, queue.size);

        assertEquals(5, queue.dequeue());
        assertEquals(1, queue.size);

        queue.enqueue(4);
        assertEquals(2, queue.size);

        assertEquals(3, queue.dequeue());
        assertEquals(1, queue.size);

        assertEquals(4, queue.dequeue());
        assertEquals(0, queue.size);

    }

}