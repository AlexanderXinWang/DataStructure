package com.vibex.structure.linkedlist.db;

// 定义HeroNode，每一个HeroNode对象就是一个节点
public class HeroNode2 {
    int no;
    String name;
    String nickName;
    HeroNode2 next; // 指向下一个节点，默认为null
    HeroNode2 pre; // 指向前一个节点，默认为null

    // 构造器
    public HeroNode2(int no, String name, String nickName) {
        this.no = no;
        this.name = name;
        this.nickName = nickName;
    }

    @Override
    public String toString() {
        return "HeroNode2{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", nickName='" + nickName + '\'' +
                '}';
    }
}
