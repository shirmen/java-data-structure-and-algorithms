package com.miga.datastructures;

class Node {

    private Object data;
    private Node next;
    private Node prev;

    public Node(Object data) {
        this.data = data;
    }

    public Node(Object data, Node next) {
        this.data = data;
        this.next = next;
    }

    public Node(Object data, Node prev, Node next) {
        this.data = data;
        this.prev = prev;
        this.next = next;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public Object getData() {
        return data;
    }

    public void setPrev(Node prev) {
        this.prev = prev;
    }

    public Node getPrev() {
        return prev;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public Node getNext() {
        return next;
    }

}
