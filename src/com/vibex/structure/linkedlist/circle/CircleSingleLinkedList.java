package com.vibex.structure.linkedlist.circle;

public class CircleSingleLinkedList {

    // 创建first节点，无编号
    private Boy first = null;

    public void add(int nums) {

        // nums做数据校验
        if (nums < 1) {
            System.out.println("Wrong number");
            return;
        }

        // 辅助指针
        Boy cur = null;

        // 使用for循环创建环形链表
        for (int i = 1; i <= nums ; i++) {
            // 根据编号创建小孩节点
            Boy boy = new Boy(i);
            // 第一个节点
            if (i == 1) {
                first = boy;
                first.setNext(boy); // 构成环状
                cur = first; // 让curBoy指向第一个小孩
            } else {
                cur.setNext(boy);
                boy.setNext(first);
                cur = boy;
            }
        }

    }

    public void show() {

        if (first == null) {
            System.out.println("Empty List");
            return;
        }

        // 不改动first，使用辅助指针进行遍历
        Boy cur = first;

        while (true) {
            System.out.printf("The number of the boy is %d \n", cur.getNo());
            if (cur.getNext() == first) {   // 遍历完毕
                break;
            }
            cur = cur.getNext();
        }

    }

    /**
     * 根据用户输入，计算出出队的顺序
     * @param startNo 表示从第几个小孩开始数数
     * @param countNum 表示数几下
     * @param nums 表示最初有多少个小孩在圈中
     */
    public void countRemoval(int startNo, int countNum, int nums) {

        if (first == null || startNo <1 || startNo > nums) {
            System.out.println("Wrong parameters, please re-enter all parameters.");
        }

        // 创建辅助指针，指向环形链表的最后一个节点
        Boy helper = first;

        while (true) {
            if (helper.getNext() == first) { // 此时helper指向最后一个节点
                break;
            }
            helper = helper.getNext();
        }

        // 报数前，根据所规定的起始位置k（startNo），让first和helper都移动k-1次
        for (int i = 0; i < startNo - 1; i++) {
            first = first.getNext();
            helper = helper.getNext();
        }

        // 报数时，根据每次所需数的数m（countNum），让first和helper同时移动m-1次
        // 循环到圈中只有一个节点
        while (true) {
            if (helper == first) { // 此时圈中只有一个节点
                break;
            }

            for (int i = 0; i < countNum - 1; i++) {
                first = first.getNext();
                helper = helper.getNext();
            }

            System.out.printf("The removed boy num is %d\n", first.getNo());
            first = first.getNext();
            helper.setNext(first);
        }
        System.out.printf("The no of the last boy is %d\n ", first.getNo());
    }

}
