package com.company;

public class MyLinkedList {
    MyNode head;
    /* Constructors */
    MyLinkedList(MyNode headNode){
        this.head = headNode;
    }
    MyLinkedList(){ this.head = null; };

    /* Adds a node to the end of the LinkedList */
    public void appendNode(MyNode newElement) {
        /* Base Case */
        if(isEmpty()) {
            this.head.next = newElement;
            return;
        }
        MyNode currentNode = this.head;
        /* General Case */
        while(currentNode != null) {
            if(currentNode.next == null){
                currentNode.next = newElement;
                break;
            }
            currentNode = currentNode.next;
        }
    }

    /* Inserts at the head of a list */
    public void insertFront(MyNode newElement) {
        if(isEmpty()) {
            this.head = newElement;
            return;
        }
        MyNode firstElement = this.head; /* Can it be without .next? */
        this.head = newElement;
        newElement.next = firstElement;
    }
    /* Inserts a node at some predefined index */
    public void insertAtIndex(MyNode newElement, int index) {
        if(index<0 || index>getSize()) {
            System.exit(0);
        }
    }

    /* Returns the number of nodes in LinkedList */
    public int getSize() {
        int listLength = 0;
        if(isEmpty()) {
            return listLength;
        }
        MyNode currentNode = this.head; /* Difference between head vs. this.head? */
        while(currentNode != null) {
            listLength++;
            currentNode = currentNode.next;
        }
        return listLength;
    }

    /* Checks whether a list is empty */
    public boolean isEmpty() {
        return this.head == null ? true : false;
    }

    /* Provides string representation of a list */
    @Override
    public String toString() {
        /* Base Case: a single node */
        if(isEmpty()) {
            return "No items";
        }
        MyNode currentNode = this.head;
        String result = "[List Content]:";
        while(currentNode != null) {
            result += " "+currentNode.data;
            currentNode = currentNode.next;
        }
        return result;
    }
}
