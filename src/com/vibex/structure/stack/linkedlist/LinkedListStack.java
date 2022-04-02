package com.vibex.structure.stack.linkedlist;

public class LinkedListStack {

    private Node top = new Node(-1);

    public boolean isEmpty() {
        return top.getValue() == -1;
    }

    public void push(Node node) {

        if (top.getNext() == null) {
            top.setNext(node);
            return;
        }

        Node cur = top.getNext();
        top.setNext(node);
        node.setNext(cur);

    }

    public void pop() {
        if (top.getNext() == null) {
            System.out.println("The stack is empty");
        }

        System.out.printf("The number got is %d\n", top.getNext().getValue());
        top = top.getNext();
    }

    public void show() {
        if (top.getNext() == null) {
            System.out.println("The stack is empty");
            return;
        }

        Node temp = top;

        while (temp.getNext() != null) {
            System.out.printf("The node is %d\n", temp.getNext().getValue());
            temp = temp.getNext();
        }
    }

}
