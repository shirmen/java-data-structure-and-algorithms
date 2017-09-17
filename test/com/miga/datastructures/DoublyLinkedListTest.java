package com.miga.datastructures;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class DoublyLinkedListTest {

    @Test
    public void testDoublyLinkedList() {
        DoublyLinkedList<Integer> dLinkedList = new DoublyLinkedList<Integer>();
        assertNull(dLinkedList.getFromHead(1));
        assertFalse(dLinkedList.remove(1));
        dLinkedList.addBegin(1);
        assertNotNull(dLinkedList.getFromHead(1));
        assertTrue(dLinkedList.getFromHead(1) == 1);
        assertNotNull(dLinkedList.getFromHead(1));
    }
}
