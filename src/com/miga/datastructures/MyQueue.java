package com.miga.datastructures;

public class MyQueue<T> {
    Node front;
    Node rear;
    
    public boolean isEmpty() {
        return front == null;
    }

    void enqueue(T data) {
        if (isEmpty()) {
            rear = new Node(data);
            front = rear;
        } else {
            rear.next = new Node(data);
            rear = rear.next;
        }
    }
        
    T dequeue() {
        if (front != null) {
            T data = (T)front.getData();
            front = front.next;
            return data;
        }
        return null; 
    }
    
    public void display() {
        if (front == null)
            return;
        
        Node current = front;
        while (current != null) {
            System.out.print("[" + current.getData() + "]");
            current = current.getNext();
        }
        System.out.println();
    }
    
    public static void main(String args[]) {
        MyQueue<Integer> myQueue = new MyQueue<Integer>();
        myQueue.enqueue(1);
        myQueue.enqueue(2);
        myQueue.enqueue(3);
        myQueue.enqueue(4);
        myQueue.enqueue(5);
        myQueue.dequeue();
        myQueue.dequeue();
        myQueue.display();
    }
}
