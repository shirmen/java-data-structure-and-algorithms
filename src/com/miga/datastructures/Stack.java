package com.miga.datastructures;

public class Stack<T> {
    private Node<T> top;

    public void push(T data) {
        Node<T> node = new Node<T>(data);
        node.setNext(top);
        top = node;
    }

    public T pop() {
        if (top == null) {
            return null;
        } else {
            T data = top.getData();
            top = top.getNext();
            return data;
        }
    }

    public T peek() {
        if (top != null)
            return top.getData();
        else
            return null;
    }
}
