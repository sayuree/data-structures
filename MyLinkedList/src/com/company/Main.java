package com.company;

public class Main {

    public static void main(String[] args) {
	// write your code here
        MyNode n1 = new MyNode(4);
        MyNode n2 = new MyNode(11);
        MyNode n3 = new MyNode(-23);
        MyNode n4 = new MyNode(33);
        MyNode n5 = new MyNode(43);

        MyLinkedList m1 = new MyLinkedList();
        m1.insertFront(n2);
        m1.insertFront(n1);
        m1.insertFront(n3);
        m1.appendNode(n4);
        System.out.println(m1);
        System.out.println(m1.getSize());
        m1.insertAtIndex(n5, 4);
        System.out.println(m1.getSize());
        System.out.println(m1);
        System.out.println(m1);
    }
}
