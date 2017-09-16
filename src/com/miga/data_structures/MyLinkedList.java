package com.miga.data_structures;

public class MyLinkedList {
    private Node head;

    MyLinkedList() {
        this.head = null;
    }

    public Node getHead() {
        return head;
    }
    
    public boolean isEmpty() {
        return head == null;
    }

    public void add(Object data) {
        if (head == null) {
            head = new Node(data);
        } else {
            Node current = head;
            while (current.getNext() != null) {
                current = current.getNext();
            }
            Node newNode = new Node(data);
            current.setNext(newNode);
        }
    }

    public void add(int index, Object data) {
        Node current = head;
        for (int i = 1; i < index && current.getNext() != null; i++) {
            current = current.getNext();
        }
        Node newNode = new Node(data, current.getNext());
        current.setNext(newNode);
    }

    public boolean remove(int index) {
        if (index <= 0 || head == null)
            return false;
            
        if (index == 1) {
            head = head.getNext();
        }
        
        Node current = head;
        for (int i = 2; i < index; i++) {
            if (current.getNext() == null)
                return false;
                
            current = current.getNext();
        }
        Node target = current.getNext();
        current.setNext(target.getNext());
        
        return true;
    }

    public Object get(int index) {
        if (head == null || index <= 0)
            return null;
 
        Node current = head;
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

        Node current = head;
        for (int i = 1; i < left; i++) {
            current = current.getNext();
        }
        Node node1 = current;

        current = head;
        for (int i = 1; i < right; i++) {
            current = current.getNext();
        }
        
        Object tmp = current.getData();
        current.setData(node1.getData());
        node1.setData(tmp);
    }
    
    public void display() {
        if (head != null) {
            Node current = head;
            while (current != null) {
                System.out.print("[" + current.getData().toString() + "]");
                current = current.getNext();
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        MyLinkedList myLinkedList = new MyLinkedList();
        myLinkedList.add(1);
        myLinkedList.add(2);
        myLinkedList.display();
        myLinkedList.add(0, 3);
        myLinkedList.display();

        // myLinkedList.remove(5);
        // myLinkedList.display();

        // myLinkedList.swap(2, 6);        
        // myLinkedList.display();
    }
}