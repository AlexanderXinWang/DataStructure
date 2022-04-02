package com.vibex.structure.stack.array;

import java.util.Scanner;

public class ArrayStackDemo {

    public static void main(String[] args) {
        ArrayStack arrayStack = new ArrayStack(4);
        String key = "";
        boolean loop = true;
        Scanner scanner = new Scanner(System.in);

        while (loop) {
            System.out.println("show: Show the stack");
            System.out.println("exit: Exit the program");
            System.out.println("push: Add data into the stack");
            System.out.println("pop: Get data from the stack");
            System.out.println("Please enter your choice");

            key = scanner.next();

            switch (key) {
                case "show":
                    arrayStack.show();
                    break;
                case "exit":
                    scanner.close();
                    loop = false;
                    break;
                case "push":
                    System.out.println("Please enter a number");
                    int value = scanner.nextInt();
                    arrayStack.push(value);
                    break;
                case "pop":
                    try {
                        int res = arrayStack.pop();
                        System.out.printf("The number got from the stack is %d\n", res);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                default:
                    break;
            }
        }
    }

}
