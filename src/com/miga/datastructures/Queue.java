package com.miga.datastructures;

public class Queue {
    Object array[];
    int length;
    int front;
    int rear;

    public Queue(int length) {
        this.length = length;
        array = new Object[length];
        front = -1;
        rear = -1;
    }
    
    public boolean isEmpty() {
        return (rear == front);
    }
    
    public boolean isFull() {
        return (rear == length - 1);
    }
    
    public void enqueue(Object data) {
        if(!isFull()) {
            array[++rear] = data;
            System.out.println("Enqueue: [" + data + "]");
        } else {
            System.out.println("Queue full!");
        }
    }
    
    public void dequeue() {
        if(!isEmpty()) {
            System.out.println("Dequeue: [" + array[front + 1] + "]");
            array[++front] = null;
        } else {
            System.out.println("Queue empty!");
        }
    }
    
    public void display() {
        if(!isEmpty()) {
            System.out.print("Queue: ");
            for(int i = front + 1; i <= rear; i++) {
                System.out.print("[" + array[i] + "]");
            }
            System.out.println();
        } else {
            System.out.println("Stack empty!");
        }
    }
    
    public static void main(String args[]) {
        Queue queue = new Queue(10);
        queue.enqueue(3);
        queue.enqueue(4);
        queue.enqueue(5);
        queue.dequeue();
        queue.display();
    }
}
