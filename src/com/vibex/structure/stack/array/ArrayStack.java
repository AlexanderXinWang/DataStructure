package com.vibex.structure.stack.array;


public class ArrayStack {

    private int maxSize;    // 栈容量
    private int[] stack;    // 数组模拟栈，数据存入该数组
    private int top = -1;   // 栈顶

    public ArrayStack(int maxSize) {
        this.maxSize = maxSize;
        stack = new int[this.maxSize];
    }

    // 栈满
    public boolean isFull() {
        return top == maxSize - 1;
    }

    // 栈空
    public boolean isEmpty() {
        return top == -1;
    }

    //入栈
    public void push(int value) {
        if (isFull()) {
            System.out.println("The stack is full");
            return;
        }
        top++;
        stack[top] = value;
    }

    // 出栈
    public int pop() {
        if (isEmpty()) {
            throw new RuntimeException("The stack is empty");
        }
        int value = stack[top];
        top--;
        return value;
    }

    // 遍历栈（从栈顶开始）
    public void show() {
        if (isEmpty()) {
            System.out.println("The stack is empty");
            return;
        }
        for (int i = top; i >= 0 ; i--) {
            System.out.printf("stack[%d] = %d\n", i, stack[i]);
        }
    }




}
