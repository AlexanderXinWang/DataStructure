package com.vibex.structure.queue;

import java.util.Scanner;

public class CircleArrayQueueDemo {

    public static void main(String[] args) {
        // 创建一个队列
        CircleArrayQueue queue = new CircleArrayQueue(4);
        char key = ' '; // 接收用户输入
        Scanner scanner = new Scanner(System.in);
        boolean loop = true;

        while (loop) {
            System.out.println("s(show)：显示队列");
            System.out.println("e(exit)：退出程序");
            System.out.println("a(add)：添加数据到队列");
            System.out.println("g(get)：从队列取出数据");
            System.out.println("h(head)：查看队列头的数据");

            key = scanner.next().charAt(0); // 接受一个字符
            switch (key) {
                case 's':
                    queue.showQueue();
                    break;
                case 'e':
                    scanner.close();
                    loop = false;
                    break;
                case 'a':
                    System.out.println("输入一个数");
                    int value = scanner.nextInt();
                    queue.addQueue(value);
                    break;
                case 'g':
                    try {
                        int result = queue.getQueue();
                        System.out.printf("取出的数据是%d\n", result);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'h':
                    try {
                        int result = queue.headQueue();
                        System.out.printf("队列头的数据是%d\n", result);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                default:
                    break;
            }
        }
        System.out.println("程序退出");

    }

}

class CircleArrayQueue {
    private int maxSize;	// 数组最大容量
    private int front;	// 队列头
    private int rear;	// 队列尾
    private int[] arr;	// 用于存放数据，模拟队列

    public CircleArrayQueue(int arrMaxSize) {
        maxSize = arrMaxSize;
        arr = new int[maxSize];
    }

    // 判断队列是否满
    public boolean isFull() {
        return (rear + 1) % maxSize == front;
    }

    // 判断队列是否为空
    public boolean isEmpty() {
        return rear == front;
    }

    // 添加数据到队列
    public void addQueue(int n) {
        if(isFull()) {
            System.out.println("队列满，不能加入数据");
            return;
        }
        arr[rear] = n;
        rear = (rear + 1) % maxSize;
    }

    //获取队列的数据，出队列
    public int getQueue() {
        if(isEmpty()) {
            throw new RuntimeException("队列空，不能取数据");
        }
        // 先把front对应的值保留到一个临时变量
        int value = arr[front];
        // 将front后移，考虑取模
        front = (front + 1) % maxSize;
        return value;
    }

    // 显示队列的所有数据
    public void showQueue() {
        if(isEmpty()) {
            System.out.println("队列为空");
            return;
        }
        // 从front开始遍历，遍历？个元素
        for (int i = front; i < front + valid(); i++) {
            System.out.printf("arr[%d]=%d\n", i % maxSize, arr[i % maxSize]);
        }
    }

    // 当前队列有效数据个数
    public int valid() {
        return (rear + maxSize - front) % maxSize;
    }

    // 显示队列的头数据（不是取出数据）
    public int headQueue() {
        // 判断
        if(isEmpty()) {
            throw new RuntimeException("队列为空");
        }
        return arr[front];
    }

}
