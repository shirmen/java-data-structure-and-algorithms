package com.miga.datastructures;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class LinkedListTest {

    @Test
    public void testLinkedList() {
        LinkedList<Integer> linkedList = new LinkedList<Integer>();
        assertNull(linkedList.getHead());
        assertFalse(linkedList.remove(1));
        linkedList.add(1);
        assertNotNull(linkedList.getHead());
        assertTrue(linkedList.get(1) == 1);
        assertNotNull(linkedList.get(1));
    }
}
