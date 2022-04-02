package com.vibex.structure.linkedlist;

import java.util.Stack;

public class TestStack {
    public static void main(String[] args) {
        /**
         * 栈演示
         */
        Stack<String> stack = new Stack<>();
        // 入栈
        stack.add("Jacky");
        stack.add("Tom");
        stack.add("Smith");
        // 出栈
        while (stack.size() > 0) {
            System.out.println(stack.pop());
        }

    }
}
