package com.vibex.structure.linkedlist.db;

import com.vibex.structure.linkedlist.single.HeroNode;

public class DoubleLinkedList {

    private HeroNode2 head = new HeroNode2(0, "", "");

    public HeroNode2 getHead() {
        return head;
    }

    /**
     * 遍历
     */
    public void list() {
        // 判断是否为空
        if (head.next == null) {
            System.out.println("The LinkedList is empty!");
            return;
        }
        HeroNode2 temp = head.next;
        while (true) {
            if (temp == null) {
                break;
            }
            // 输出节点信息
            System.out.println(temp);
            // temp后移
            temp = temp.next;
        }
    }

    /**
     * 添加（到最后）
     */
    public void add(HeroNode2 heroNode) {
        // 辅助变量
        HeroNode2 temp = head;
        // 遍历链表，找到尾部
        while (true) {
            // 找到链表的最后
            if (temp.next == null) {
                break;
            }
            // 如果没有找到，就将temp后移
            temp = temp.next;
        }
        // 当退出while循环时，temp就指向了链表的最后
        // 形成双向链表
        temp.next = heroNode;
        heroNode.pre = temp;
    }

    /**
     * 排序添加
     * @param heroNode
     */
    public void addByOrder(HeroNode2 heroNode) {

        HeroNode2 temp = head;
        boolean flag = false;   // 标志添加的编号是否存在，默认为false

        while (true) {
            if (temp.next == null) { // temp已在链表最后
                break;
            }
            if (temp.next.no > heroNode.no) { // 位置找到，在temp之后插入
                break;
            } else if (temp.next.no == heroNode.no) { // 添加的heroNode编号已存在
                flag = true;
                break;
            }
            temp = temp.next;
        }
        if (flag) {
            System.out.printf("HeroNumber%d already exists!", heroNode.no);
        } else {
            heroNode.next = temp.next;
            heroNode.pre = temp;
            temp.next = heroNode;
            temp.next.pre = heroNode;
        }
    }

    /**
     * 修改
     * @param heroNode
     */
    public void update(HeroNode2 heroNode) {
        if (head.next == null) {
            System.out.println("The LinkedList is empty");
        }
        HeroNode2 temp = head.next;
        boolean flag = false;
        while (true) {
            if (temp == null) {
                break;
            }
            if (temp.no == heroNode.no) {
                flag = true;
                break;
            }
            temp = temp.next;
        }

        if (flag) {
            temp.name = heroNode.name;
            temp.nickName = heroNode.nickName;
        } else {
            System.out.printf("Do not find the node with the number of %d, update operation cannot be execute at this time.", heroNode.no);
        }
    }

    /**
     * 删除
     * @param no
     */
    public void delete(int no) {

        if (head.next == null) {
            System.out.println("The LinkedList is empty, cannot be deleted!");
        }

        HeroNode2 temp = head.next;
        boolean flag = false;

        while (true) {
            if (temp == null) {
                break;
            }
            if (temp.no == no) {
                flag = true;
                break;
            }
            temp = temp.next;
        }

        if (flag) {
            temp.pre.next = temp.next;
            // 判断是否是最后一个节点（预防空指针异常）
            if (temp.next != null) {
                temp.next.pre = temp.pre;
            }
        } else {
            System.out.printf("Cannot find the node %d", no);
        }
    }
}
