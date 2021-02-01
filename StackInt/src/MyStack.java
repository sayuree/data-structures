import java.util.EmptyStackException;

public class MyStack {
    MyStack.Node head = null;

    public MyStack() {
    }

    public void push(int val) {
        MyStack.Node newNode = new MyStack.Node(val);
        if (this.isEmpty()) {
            this.head = newNode;
        } else {
            MyStack.Node previousNode = this.head;
            newNode.next = previousNode;
            this.head = newNode;
        }
    }

    public int pop() {
        if (this.isEmpty()) {
            throw new EmptyStackException();
        } else {
            int currentNodeVal = this.head.val;
            this.head = this.head.next;
            return currentNodeVal;
        }
    }

    public boolean isEmpty() {
        boolean result = false;
        if (this.head == null) {
            result = true;
        }

        return result;
    }

    public int peek() {
        if (this.isEmpty()) {
            throw new EmptyStackException();
        } else {
            int topNodeVal = this.head.val;
            return topNodeVal;
        }
    }

    public String toString() {
        if (this.isEmpty()) {
            return "Empty Stack!";
        } else {
            MyStack.Node currentNode = this.head;

            String result;
            for(result = ""; currentNode != null; currentNode = currentNode.next) {
                result = result + currentNode.val + ",";
            }

            return result;
        }
    }

    private class Node {
        int val;
        MyStack.Node next;

        public Node(int val) {
            this.val = val;
        }
    }
}