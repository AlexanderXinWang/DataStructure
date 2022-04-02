package com.vibex.structure.linkedlist.circle;

public class Josephus {

    public static void main(String[] args) {

        CircleSingleLinkedList circleSingleLinkedList = new CircleSingleLinkedList();

        circleSingleLinkedList.add(5);

        circleSingleLinkedList.show();

        circleSingleLinkedList.countRemoval(1, 2, 5);

    }

}
