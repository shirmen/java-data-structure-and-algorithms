package com.miga.datastructures;

public class Queue<T> {

    private Node<T> front;
    private Node<T> rear;

    public void enqueue(T data) {
        if (front == null) {
            rear = new Node<T>(data);
            front = rear;
        } else {
            rear.setNext(new Node<T>(data));
            rear = rear.getNext();
        }
    }

    public T dequeue() {
        if (front != null) {
            T data = front.getData();
            front = front.getNext();
            return data;
        }
        return null; 
    }

    public void display() {
        Node<T> current = front;
        while (current != null) {
            System.out.println(current.getData());
            current = current.getNext();
        }
    }
}
