public class MyQueue {
    private class ListNode {
        int val;
        ListNode next;

        public ListNode(int val) { this.val = val; }
    }
    ListNode head;
    ListNode tail;

    public MyQueue() { this.head = null; this.tail = null; }

    public void enqueue(int data) {
        ListNode previousNode = this.tail;
        this.tail = new ListNode(data);
        if(this.isEmpty()) { this.head = this.tail; }
        else { previousNode.next = this.tail; }
    }

    public int dequeue() {
        if (this.isEmpty()) { return -1; }
        int data = this.head.val;
        this.head = this.head.next;
        if (this.isEmpty()) { this.tail = this.head; }
        return data;
    }

    public boolean isEmpty() { return this.head == null; }

    @Override
    public String toString() {
        String result = "";
        ListNode currentNode = this.head;
        while(currentNode != null) {
            result += currentNode.val + ",";
            currentNode = currentNode.next;
        }
        return result;
    }
}
