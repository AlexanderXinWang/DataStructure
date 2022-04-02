package com.vibex.structure.stack.linkedlist;

public class LinkedListStackDemo {

    public static void main(String[] args) {
        Node node1 = new Node(1);
        Node node2 = new Node(6);
        Node node3 = new Node(4);
        Node node4 = new Node(9);
        Node node5 = new Node(7);

        LinkedListStack stack = new LinkedListStack();

        stack.push(node1);
        stack.push(node2);
        stack.push(node3);
        stack.push(node4);
        stack.push(node5);

        stack.show();

        stack.pop();
        stack.pop();
        stack.pop();

        stack.show();
    }


}
