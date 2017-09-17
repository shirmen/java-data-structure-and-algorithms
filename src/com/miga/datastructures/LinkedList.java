package com.miga.datastructures;

public class LinkedList<T> {
    private Node<T> head;

    public Node<T> getHead() {
        return head;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public void add(T data) {
        if (head == null) {
            head = new Node<T>(data);
        } else {
            Node<T> current = head;
            while (current.getNext() != null) {
                current = current.getNext();
            }
            Node<T> newNode = new Node<T>(data);
            current.setNext(newNode);
        }
    }

    public void add(int index, T data) {
        Node<T> current = head;
        for (int i = 1; i < index && current.getNext() != null; i++) {
            current = current.getNext();
        }
        Node<T> newNode = new Node<T>(data, current.getNext());
        current.setNext(newNode);
    }

    public boolean remove(int index) {
        if (index <= 0 || head == null)
            return false;

        if (index == 1) {
            head = head.getNext();
        }

        Node<T> current = head;
        for (int i = 2; i < index; i++) {
            if (current.getNext() == null)
                return false;

            current = current.getNext();
        }

        Node<T> target = current.getNext();
        current.setNext(target.getNext());

        return true;
    }

    public T get(int index) {
        if (head == null || index <= 0)
            return null;
 
        Node<T> current = head;
        for (int i = 2; i <= index; i++) {
            if (current.getNext() == null)
                return null;

            current = current.getNext();
        }
        return current.getData();
    }

    public void swap(int left, int right) {
        if (isEmpty() || left <= 0 || right <= 0)
            return;

        Node<T> current = head;
        for (int i = 1; i < left; i++) {
            current = current.getNext();
        }

        Node<T> tempNode = current;
        current = head;
        for (int i = 1; i < right; i++) {
            current = current.getNext();
        }

        T tempData = current.getData();
        current.setData(tempNode.getData());
        tempNode.setData(tempData);
    }
}