package com.vibex.structure.linkedlist.single;

// 定义HeroNode，每一个HeroNode对象就是一个节点
public class HeroNode {
    int no;
    String name;
    String nickName;
    HeroNode next; // 指向下一个节点

    // 构造器
    public HeroNode(int no, String name, String nickName) {
        this.no = no;
        this.name = name;
        this.nickName = nickName;
    }

    @Override
    public String toString() {
        return "HeroNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", nickName='" + nickName + '\'' +
                '}';
    }
}
