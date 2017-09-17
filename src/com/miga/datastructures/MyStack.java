package com.miga.datastructures;

public class MyStack<V> {
    Node top;

    public MyStack() {
        top = null;
    }

    public void push(int data) {
        Node node = new Node(data);
        node.next = top;
        top = node;
    }
    
    public void pop() {
        if (top != null) {
            top = top.next;
        }
    }

    public Object peek() {
        if (top != null)
            return top.getData();
        else
            return null;
    }
}
