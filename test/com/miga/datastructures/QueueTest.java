package com.miga.datastructures;

import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class QueueTest {

    @Test
    public void testQueue() {
        Queue<Integer> queue = new Queue<Integer>();
        queue.enqueue(1);
        assertTrue(queue.dequeue() == 1);
        assertNull(queue.dequeue());
    }
}
