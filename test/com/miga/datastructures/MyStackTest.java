package com.miga.datastructures;

import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.miga.datastructures.MyStack;

public class MyStackTest {

    @Test
    public void testStack() {
        MyStack<Integer> stack = new MyStack<Integer>();
        stack.push(new Integer(1));
        assertTrue((int)stack.pop() == 1);
        assertNull(stack.pop());
    }
}
