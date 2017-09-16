package data_structures;

public class MyStack {
    Node top;

    public MyStack() {
        top = null;
    }
    
    public void push(int data) {
        Node node = new Node(data);
        node.next = top;
        top = node;
    }
    
    public void pop() {
        if (top != null) {
            top = top.next;
        }
    }

    public Object peek() {
        if (top != null)
            return top.getData();
        else
            return null;
    }

    public static void main(String args[]) {
        MyStack stack = new MyStack();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        System.out.println(stack.peek());
        stack.pop();
        System.out.println(stack.peek());
        stack.pop();
        System.out.println(stack.peek());
    }
}
