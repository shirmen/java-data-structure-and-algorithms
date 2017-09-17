package com.miga.datastructures;

import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.miga.datastructures.MyQueue;

public class MyQueueTest {

    @Test
    public void testQueue() {
        MyQueue<Integer> queue = new MyQueue<Integer>();
        queue.enqueue(new Integer(1));
        assertTrue(queue.dequeue() == 1);
        assertNull(queue.dequeue());
    }
}
