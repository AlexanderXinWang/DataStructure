package com.vibex.structure.linkedlist.db;

public class DoubleLinkedListDemo {

    public static void main(String[] args) {
        HeroNode2 hero1 = new HeroNode2(1, "宋江", "及时雨");
        HeroNode2 hero2 = new HeroNode2(2, "卢俊义", "玉麒麟");
        HeroNode2 hero3 = new HeroNode2(3, "吴用", "智多星");
        HeroNode2 hero4 = new HeroNode2(4, "林冲", "豹子头");

        DoubleLinkedList doubleLinkedList = new DoubleLinkedList();

//        doubleLinkedList.add(hero1);
//        doubleLinkedList.add(hero2);
//        doubleLinkedList.add(hero3);
//        doubleLinkedList.add(hero4);

        doubleLinkedList.addByOrder(hero3);
        doubleLinkedList.addByOrder(hero2);
        doubleLinkedList.addByOrder(hero4);
        doubleLinkedList.addByOrder(hero1);

        doubleLinkedList.list();

//        HeroNode2 hero5 = new HeroNode2(4, "公孙胜", "入云龙");
//        doubleLinkedList.update(hero5);
//        System.out.println("Updated LinkedList:");
//        doubleLinkedList.list();
//
//        doubleLinkedList.delete(3);
//        System.out.println("Deleted LinkedList");
//        doubleLinkedList.list();
    }
}
