package com.miga.datastructures;

import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.miga.datastructures.Stack;

public class StackTest {

    @Test
    public void testStack() {
        Stack<Integer> stack = new Stack<Integer>();
        stack.push(1);
        assertTrue((int)stack.pop() == 1);
        assertNull(stack.pop());
    }
}
