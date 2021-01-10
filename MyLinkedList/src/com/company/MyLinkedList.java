package com.company;

public class MyLinkedList {
    MyNode head;
    /* Constructors */
    public MyLinkedList(MyNode headNode){
        this.head = headNode;
    }
    public MyLinkedList(){ this.head = null; };

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

    /* Inserts a node at some predefined index
    * Index should be from 0 to N*/
    public void insertAtIndex(MyNode newElement, int index) {
        if(index<0 || index > getSize()  || newElement == null) {
            return;
        }
        /* Inserting at index 0 */
        if(index == 0) {
            insertFront(newElement);
            return;
        }
        /* Inserting at the end of the list */
        if(this.getSize() == index) {
            appendNode(newElement);
            return;
        }
        /* Inserting in the middle of the list */
        int count = 0;
        MyNode currentNode = this.head;
        while(currentNode != null) {
            if(count+1 == index) {
                if(currentNode.next != null) {
                    MyNode nextElement = currentNode.next;
                    currentNode.next = newElement;
                    newElement.next = nextElement;
                    break;
                }
            }
            count++;
            currentNode = currentNode.next;
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

    /* Finding a node value at some predefined index */
    public int get(int index) {
        /* Invalid cases */
        int result = -1;
        if(!isValidIndex(index)) {
            return result;
        }
        int counter = 0;
        MyNode currentNode = this.head;
        while (currentNode != null) {
            if(counter == index) {
                result = currentNode.data;
                break;
            }
            counter++;
            currentNode = currentNode.next;
        }
        return result;
    }

    /* Deleting a node at predefined index */
    public void deleteAtIndex(int index) {
        /* Invalid cases */
        if(!isValidIndex(index)) {
            return;
        }
        /* Edge Case: empty list */
        if(isEmpty()) {
            return;
        }
        /* Deleting the head node of size 1 */
        if(this.getSize() == 1 && index == 0) {
            this.head = null;
            return;
        }
        int counter = 0;
        MyNode currentNode = this.head;
        /* Deleting the head node */
        if(index == 0) {
            this.head = currentNode.next;
            currentNode.next = null;
            return;
        }
        while(currentNode != null) {
            if(counter+1 == index) {
                /*Why it does not raise NullPointerException?*/
                /* (1) -> (10) -> (12) */
                if(currentNode.next.next!=null) {
                    MyNode nextElement = currentNode.next.next;
                    currentNode.next.next = null;
                    currentNode.next = nextElement;
                    break;
                }
                /* (4) -> (11) */
                currentNode.next = null;
                break;
            }
            counter++;
            currentNode = currentNode.next;
        }
    }

    public boolean isValidIndex(int index) {
        boolean isValid = true;
        if(index < 0 || index > this.getSize()-1) {
            isValid = false;
        }
        return isValid;
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
            result += " " + currentNode.data;
            currentNode = currentNode.next;
        }
        return result;
    }
}
