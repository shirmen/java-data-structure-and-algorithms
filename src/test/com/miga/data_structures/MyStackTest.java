package test.com.miga.data_structures;

import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.miga.data_structures.MyStack;

public class MyStackTest {

    @Test
    public void testStack() {
        MyStack<Integer> stack = new MyStack<Integer>();
        stack.push(1);
        assertTrue((int)stack.peek() == 1);
        stack.pop();
        assertNull(stack.peek());
    }
}
