package com.company;

public class MyLinkedList {
    MyNode head;

    MyLinkedList(MyNode headNode){
        this.head = headNode;
    }
    MyLinkedList(){ this.head = null; };
    /* Adds a node to the end of the LinkedList */
    public void appendNode(MyNode newElement) {
        MyNode iterator = head;
        /* Base Case */
        if(head.next == null) {
            head.next = newElement;
            return;
        }
        System.out.println("AFTER ADDING 1 ELEMENT");
        /* General Case */
        while(iterator.next == null) {
            if(iterator.next.next == null){
                iterator.next.next = newElement;
                break;
            }
            iterator = iterator.next;
        }
    }

    public void insertFront(MyNode newElement) {
        if(head.next == null) {
            head.next = newElement;
            return;
        }
        MyNode firstElement = head.next;
        head.next = newElement;
        newElement.next = firstElement;
    }

    public int getSize() {

        return 0;
    }

    public boolean isEmpty() {
        return head.next == null ? true : false;
    }

    @Override
    public String toString() {
        MyNode iterator = head;
        /* Base Case: a single node */
        if(head.next == null) {
            return "No items";
        }

        String result = "Start:";
        while(iterator.next != null) {
            result += " "+iterator.next.data;
            iterator = iterator.next;
        }
        return result;
    }

    public void printList()
    {
        MyNode currNode = head.next;

        System.out.print("LinkedList: ");

        // Traverse through the LinkedList
        while (currNode != null) {
            // Print the data at current node
            System.out.print(currNode.data + " ");

            // Go to next node
            currNode = currNode.next;
        }
    }
}
