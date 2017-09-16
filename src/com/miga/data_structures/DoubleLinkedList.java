package com.miga.data_structures;

public class DoubleLinkedList {
    private Node head;
    private Node tail;
    private int size;
    
    DoubleLinkedList() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }
    
    public int getSize() {
        return size;
    }
    
    public boolean isEmpty() {
        return head == null || tail == null;
    }

    public void addBegin(Object data) {
        if(isEmpty()) {
            head = tail = new Node(data);
        } else {
            Node newNode = new Node(data, null, head);
            head.setPrev(newNode);
            head = newNode;
        }
        size++;
    }

    public void addEnd(Object data) {
        if(isEmpty()) {
            head = tail = new Node(data);
        } else {
            Node newNode = new Node(data, tail, null);
            tail.setNext(newNode);
            tail = newNode;
        }
        size++;
    }
    
    public void addAfter(int index, Object data) {
        if(index <= 0) {
            addBegin(data);
        } else if(index == size) {
            addEnd(data);
        } else {
            Node current = head;
            for(int i = 1; i < index && current.getNext() != null; i++) {
                current = current.getNext();
            }
            Node newNode = new Node(data, current, current.getNext());
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
            Node current = head;
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

    public Object getFromHead(int index) {
        if (index <= 0 || isEmpty()) {
            return null;
        }
        
        Node current = head;
        for (int i = 1; i < index; i++) {
            if (current.getNext() == null) {
                return null;
            }
            current = current.getNext();
        }
        
        return current.getData();
    }

    public Object getFromTail(int index) {
        if (index > size || isEmpty()) {
            return null;
        }
        Node current = tail;
        for (int i = 1; i < index; i++) {
            if (current.getPrev() == null) {
                return null;
            }
            current = current.getPrev();
        }
        return current.getData();
    }

    public static void main(String[] args) {
        DoubleLinkedList dLinkedlist = new DoubleLinkedList();
        
        dLinkedlist.addBegin(2);
        dLinkedlist.addBegin(1);
        dLinkedlist.addEnd(3);
        dLinkedlist.addAfter(3, 4);
        dLinkedlist.addEnd(5);
        dLinkedlist.remove(3);

        for(int i = 1; i <= dLinkedlist.getSize(); i++) {
            System.out.print(dLinkedlist.getFromHead(i) + "  ");
        }
        System.out.println();

        for(int i = 1; i <= dLinkedlist.getSize(); i++) {
            System.out.print(dLinkedlist.getFromTail(i) + "  ");
        }
        System.out.println();
    }
}