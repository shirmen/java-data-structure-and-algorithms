package com.miga.datastructures;

@SuppressWarnings("unchecked")
public class MyStack<T> {
    Node top;

    public void push(T data) {
        Node node = new Node(data);
        node.setNext(top);
        top = node;
    }

    public T pop() {
        if (top == null) {
            return null;
        } else {
            T data = (T) top.getData();
            top = top.getNext();
            return data;
        }
    }

    public T peek() {
        if (top != null)
            return (T) top.getData();
        else
            return null;
    }
}
