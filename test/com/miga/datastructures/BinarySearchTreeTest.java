package com.miga.datastructures;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.miga.datastructures.BinarySearchTree;;

public class BinarySearchTreeTest {

    @Test
    public void testBinarySearchTree() {

        BinarySearchTree<Integer> bstree = new BinarySearchTree<Integer>();
        assertNull(bstree.getRoot());
        bstree.insert(1);
        assertNotNull(bstree.getRoot());
        assertTrue(bstree.search(bstree.getRoot(), 1));
        assertFalse(bstree.search(bstree.getRoot(), 2));
        assertFalse(bstree.delete(bstree.getRoot(), 2));
        assertTrue(bstree.delete(bstree.getRoot(), 1));
        assertNull(bstree.getRoot());
    }
}
