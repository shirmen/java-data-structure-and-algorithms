package com.miga.datastructures;

public class DoublyLinkedList<T> {
    private Node<T> head;
    private Node<T> tail;
    private int size;

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return head == null || tail == null;
    }

    public void addBegin(T data) {
        if(isEmpty()) {
            head = tail = new Node<T>(data);
        } else {
            Node<T> newNode = new Node<T>(data, null, head);
            head.setPrev(newNode);
            head = newNode;
        }
        size++;
    }

    public void addEnd(T data) {
        if(isEmpty()) {
            head = tail = new Node<T>(data);
        } else {
            Node<T> newNode = new Node<T>(data, tail, null);
            tail.setNext(newNode);
            tail = newNode;
        }
        size++;
    }

    public void addAfter(int index, T data) {
        if(index <= 0) {
            addBegin(data);
        } else if(index == size) {
            addEnd(data);
        } else {
            Node<T> current = head;
            for(int i = 1; i < index && current.getNext() != null; i++) {
                current = current.getNext();
            }
            Node<T> newNode = new Node<T>(data, current, current.getNext());
            current.getNext().setPrev(newNode);
            current.setNext(newNode);
            size++;
        }
    }

    public boolean remove(int index) {
        if(index <= 0 || isEmpty()) {
            return false;
        }
        if(index == 1) {
            head = head.getNext();
            head.setPrev(null);
        } else if(index == size) {
            tail = tail.getPrev();
            tail.setNext(null);
        } else {
            Node<T> current = head;
            for(int i = 1; i < index; i++) {
                if(current.getNext() == null) {
                    return false;
                }
                current = current.getNext();
            }
            current.getPrev().setNext(current.getNext());
            current.getNext().setPrev(current.getPrev());
            current.setNext(null);
            current.setPrev(null);
        }
        size--;
        return true;
    }

    public T getFromHead(int index) {
        if (index <= 0 || isEmpty()) {
            return null;
        }

        Node<T> current = head;
        for (int i = 1; i < index; i++) {
            if (current.getNext() == null) {
                return null;
            }
            current = current.getNext();
        }
        return current.getData();
    }

    public T getFromTail(int index) {
        if (index > size || isEmpty()) {
            return null;
        }
        Node<T> current = tail;
        for (int i = 1; i < index; i++) {
            if (current.getPrev() == null) {
                return null;
            }
            current = current.getPrev();
        }
        return current.getData();
    }
}