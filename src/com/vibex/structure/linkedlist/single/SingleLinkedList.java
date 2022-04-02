package com.vibex.structure.linkedlist.single;

/**
 * 定义SingleLinkedList管理英雄
 */
public class SingleLinkedList {

    // 初始化头节点，不要动，不存放具体数据
    private HeroNode head = new HeroNode(0, "", "");

    public HeroNode getHead() {
        return head;
    }

    /**
     * 添加节点到单向链表
     * 当不考虑编号顺序时
     * 1. 找到当前链表的最后节点
     * 2. 将最后这个节点的next指向新的节点
     * @param heroNode
     */
    public void add(HeroNode heroNode) {
        // 辅助变量
        HeroNode temp = head;
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
        temp.next = heroNode;
    }

    // 显示链表[遍历]
    public void list() {
        // 判断是否为空
        if (head.next == null) {
            System.out.println("The LinkedList is empty!");
            return;
        }
        HeroNode temp = head.next;
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
     * 根据排名进行插入添加
     */
    public void addByOrder(HeroNode heroNode) {
        //temp所处位置应是位于添加位置的前一个节点，否则插入不了
        HeroNode temp = head;
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
            temp.next = heroNode;
        }
    }

    /**
     * 根据编号修改节点的信息
     * 1. 先通过遍历找到该节点
     * 2. `temp.name = heroNode.name`
     * 3. `temp.nickName = heroNode.nickName`
     */
    public void update(HeroNode heroNode) {
        if (head.next == null) {
            System.out.println("The LinkedList is empty");
        }
        HeroNode temp = head.next;
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
     * 删除节点
     * 1. 不改动head，需要辅助变量找到待删除节点的前一个节点
     * 2. temp.next.no 和需要删除的节点的NO比较
     */
    public void delete(int no) {
        HeroNode temp = head;
        boolean flag = false;

        while (true) {
            if (temp.next == null) {
                break;
            }
            if (temp.next.no == no) {
                flag = true;
                break;
            }
            temp = temp.next;
        }

        if (flag) {
            temp.next = temp.next.next;
        } else {
            System.out.printf("Cannot find the node %d", no);
        }
    }



}
