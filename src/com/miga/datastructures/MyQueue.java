package com.miga.datastructures;

@SuppressWarnings("unchecked")
public class MyQueue<T> {

    Node front;
    Node rear;

    public void enqueue(T data) {
        if (front == null) {
            rear = new Node(data);
            front = rear;
        } else {
            rear.setNext(new Node(data));
            rear = rear.getNext();
        }
    }

    public T dequeue() {
        if (front != null) {
            T data = (T) front.getData();
            front = front.getNext();
            return data;
        }
        return null; 
    }

    public void display() {
        Node current = front;
        while (current != null) {
            System.out.println(current.getData());
            current = current.getNext();
        }
    }
}
