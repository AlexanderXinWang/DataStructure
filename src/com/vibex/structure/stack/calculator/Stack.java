package com.vibex.structure.stack.calculator;

public class Stack {
    private int maxSize;    // 栈容量
    private int[] stack;    // 数组模拟栈，数据存入该数组
    private int top = -1;   // 栈顶

    public Stack(int maxSize) {
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

    /**
     * show the top value of the stack
     */
    public int peak() {
        return stack[top];
    }

    /**
     * 返回运算符的优先级
     * 数字越大，则优先级越高
     */
    public int priority(int operator) {
        if (operator == '*' || operator == '/') {
            return 1;
        } else if (operator == '+' || operator == '-') {
            return 0;
        } else {
            return -1;
        }
    }

    /**
     * 判断是否为运算符
     */
    public boolean isOperator(char val) {
        return val == '+' || val == '-' || val == '*' || val == '/';
    }

    /**
     * 计算方法
     */
    public int cal(int num1, int num2, int operator) {
        int res = 0;    // 存放计算结果
        switch (operator) {
            case '+':
                res = num2 + num1;
                break;
            case '-':
                res = num2 - num1;  // the order is important
                break;
            case '*':
                res = num2 * num1;
                break;
            case '/':
                res = num2 / num1;
                break;
            default:
                break;
        }

        return res;
    }
}
