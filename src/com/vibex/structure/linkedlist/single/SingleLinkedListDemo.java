package com.vibex.structure.linkedlist.single;

import com.vibex.structure.linkedlist.single.HeroNode;
import com.vibex.structure.linkedlist.single.SingleLinkedList;

import java.util.Stack;

public class SingleLinkedListDemo {
    public static void main(String[] args) {
        HeroNode heroNode1 = new HeroNode(1, "宋江", "及时雨");
        HeroNode heroNode2 = new HeroNode(2, "卢俊义", "玉麒麟");
        HeroNode heroNode3 = new HeroNode(3, "吴用", "智多星");
        HeroNode heroNode4 = new HeroNode(4, "林冲", "豹子头");

        SingleLinkedList singleLinkedList = new SingleLinkedList();


//        singleLinkedList.add(heroNode1);
//        singleLinkedList.add(heroNode2);
//        singleLinkedList.add(heroNode3);
//        singleLinkedList.add(heroNode4);

//        singleLinkedList.addByOrder(heroNode1);
//        singleLinkedList.addByOrder(heroNode4);
//        singleLinkedList.addByOrder(heroNode2);
//        singleLinkedList.addByOrder(heroNode3);
//
//        singleLinkedList.list();
//
//        System.out.println("=================================================================");
//        System.out.println("Update Node =====================================================");
//
//        // 修改节点
//        singleLinkedList.update(new HeroNode(2, "小卢", "玉麒麟`~"));
//        singleLinkedList.list();
//
//        System.out.println("=================================================================");
//        System.out.println("Delete Node =====================================================");
//
//        singleLinkedList.delete(1);
////        singleLinkedList.delete(4);
//        singleLinkedList.list();
//
//        System.out.println("==================================================================");
//        System.out.println("Get number of valid nodes of the LinkedList ======================");
//
//        // 求单链表中有效节点个数
//        System.out.println("Valid nodes number =" + getNodeNumber(singleLinkedList.getHead()));
//
//        System.out.println("==================================================================");
//        System.out.println("Find last no.K node ==============================================");
//
//        // 查找单链表中的倒数第k个节点
//        HeroNode res = findLastIndexNode(singleLinkedList.getHead(), 1);
//        System.out.println("res=" + res);
//
//        System.out.println("==================================================================");
//        System.out.println("The original list ================================================");
//        singleLinkedList.list();
//        System.out.println("Reverse the linkedList ===========================================");
//        // 反转
//        reverseList(singleLinkedList.getHead());
//        singleLinkedList.list();
//
//        System.out.println("==================================================================");
//        System.out.println("Print the list in reversed manner ================================");
//        reversePrint(singleLinkedList.getHead());

        System.out.println("==================================================================");
        System.out.println("Merge two lists in manner ========================================");
        SingleLinkedList list1 = new SingleLinkedList();
        SingleLinkedList list2 = new SingleLinkedList();
        list1.addByOrder(heroNode2);
        list1.addByOrder(heroNode4);
        list2.addByOrder(heroNode1);
        list2.addByOrder(heroNode3);
        System.out.println("LinkedList 1 ================================");
        list1.list();
        System.out.println("LinkedList 2 ================================");
        list2.list();
        System.out.println("Merged LinkedList ===========================");
        print(merge(list1.getHead(), list2.getHead()));


    }

    /**
     * 获取有效节点个数
     * @param head 链表头节点
     * @return
     */
    public static int getNodeNumber(HeroNode head) {
        if (head.next == null) {
            return 0;
        }
        int length = 0;
        HeroNode cur = head.next;
        while (cur != null) {
            length++;
            cur = cur.next;
        }
        return length;
    }

    /**
     * 查找单链表中的倒数第k个节点
     * @param head
     * @param index
     * @return
     */
    public static HeroNode findLastIndexNode(HeroNode head, int index) {
        if (head.next == null) {
            return null;
        }
        // 第一个遍历得到链表的长度
        int size = getNodeNumber(head);
        // 第二次遍历 size-index 位置，即是倒数第k个节点
        // index校验
        if (index <= 0 || index > size) {
            return null;
        }
        // 定义辅助变量
        HeroNode cur = head.next;
        for (int i = 0; i < size - index; i++) {
            cur = cur.next;
        }
        return cur;
    }
    
    /**
     * 单链表的反转
     * @param head
     */
    public static void reverseList(HeroNode head) {
        if (head.next == null || head.next.next == null) {
            return;
        }
        HeroNode cur = head.next;
        HeroNode next = null;   // 指向当前节点的下一个节点
        HeroNode reverseHead = new HeroNode(0, null, null);

        // 遍历原来的链表，每遍历一个节点就将其取出，并放在新的链表的最前端
        while (cur != null) {
            next = cur.next;    // 先暂时保存当前节点的下一个节点，后面需要使用

            // 清除cur的next域，使得最后一个节点时能保证next域为null
            // 同时将cur的下一个节点指向新的链表的最前端
            cur.next = reverseHead.next;
            reverseHead.next = cur;
            cur = next;
        }
        head.next = reverseHead.next;
    }

    /**
     * 从尾到头打印单链表（反向遍历 / stack栈）
     * 利用栈这个数据结构，将各个节点压入到**栈**中，然后利用栈的先进后出的特点，实现逆序打印
     */
    public static void reversePrint(HeroNode head) {
        if (head.next == null) {
            return;
        }
        Stack<HeroNode> stack = new Stack<>();
        HeroNode cur = head.next;
        // 将链表的所有节点压入栈中
        while (cur != null) {
            stack.push(cur);
            cur = cur.next;
        }
        // 遍历打印栈中节点
        while (stack.size() > 0) {
            System.out.println(stack.pop());
        }
    }

    /**
     * 合并两个有序的单链表，合并之后的链表依然有序
     */
    public static HeroNode merge(HeroNode head1, HeroNode head2) {
        HeroNode cur1 = head1.next;
        HeroNode cur2 = head2.next;
        HeroNode node = new HeroNode(0, null, null);
        HeroNode temp = node;

        if (cur1 == null) {
            if (cur2 != null) {
                node.next = cur2;
            }
        }

        if (cur2 == null) {
            if (cur1 != null) {
                node.next = cur1;
            }
        }

        if (cur1 ==null || cur2 == null) {
            System.out.println("Two Lists are empty!");
        }

        while (true) {

            if (cur1 == null) {
                temp.next = cur2;
                break;
            }

            if (cur2 == null) {
                temp.next = cur1;
                break;
            }

            if (cur1.no < cur2.no) {
                temp.next = cur1;
                temp = cur1;
                cur1 = cur1.next;
            } else {
                temp.next = cur2;
                temp = cur2;
                cur2 = cur2.next;
            }
        }
        return node.next;
    }

    /**
     * 打印链表
     * @param head
     */
    public static void print(HeroNode head){
        HeroNode temp = head;
        while (temp != null){
            System.out.println(temp);
            temp = temp.next;
        }
    }


}




