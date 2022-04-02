package com.vibex.structure.stack.calculator;

import com.vibex.structure.stack.array.ArrayStack;

public class Calculator {

    public static void main(String[] args) {

//        String exp = "30+2*6-2";
//        String exp = "5-6/2-1";
//        String exp = "70+5*2-7";
//        String exp = "5-6/3-2";
        String exp = "5-3/3-2";

        Stack numStack = new Stack(10);
        Stack operatorStack = new Stack(10);

        int index = 0;  // scan index
        int num1 = 0;
        int num2 = 0;
        int operator = 0;
        int res = 0;
        char ch = ' ';  // store the scan results

        String keepNum = "";  // concat the string

        while (true) {
            ch = exp.substring(index, index + 1).charAt(0);

            if (operatorStack.isOperator(ch)) {
                // when the ch is an operator
                if (!operatorStack.isEmpty()) {
                    // current operator's priority <= operator in the stack
                    if (operatorStack.priority(ch) <= operatorStack.priority(operatorStack.peak())) {
                        num1 = numStack.pop();
                        num2 = numStack.pop();
                        operator = operatorStack.pop();
                        res = numStack.cal(num1, num2, operator);
                        numStack.push(res);
//                        operatorStack.push(ch);
                        index--;
                    } else {
                        // current operator's priority > operator in the stack
                        operatorStack.push(ch);
                    }
                } else {
                    operatorStack.push(ch);
                }
            } else {
                // when the ch is a number
                // according to ASCII table, the difference between the true value and stored number of a number is 48
//                numStack.push(ch - 48);

                ////////////////////////////////////////////////////////////////////////////////////////////////////////
                // problem: when it is a multi-digit number
                // when dealing with numbers, have a look at the next digit of the index of exp
                // if it is a number, keep scanning; if it is an operator, push it into the stack
                // define a string var to concat
                keepNum += ch;

                // when the ch is the last string of the exp
                if (index == exp.length() - 1) {
                    numStack.push(Integer.parseInt(keepNum));
                } else {
                    if (operatorStack.isOperator(exp.substring(index+1, index+2).charAt(0))) { // the next string is an operator
                        numStack.push(Integer.parseInt(keepNum));
                        keepNum = "";
                    }
                }
            }
            // make the index+1, and judge if it is at the end of the exp
            index++;
            if (index >= exp.length()) {
                break;
            }
        }

        // pop the data from the stack to calculate
        while (true) {
            // when the operatorStack is empty, the number in the numStack is the fina result
            if (operatorStack.isEmpty()) {
                break;
            }

            num1 = numStack.pop();
            num2 = numStack.pop();
            operator = operatorStack.pop();
//            if (operatorStack.priority(operator) <= )
            res = numStack.cal(num1, num2, operator);

            numStack.push(res);
        }

        int finalRes = numStack.pop();

        System.out.printf("The expression %s = %d", exp, finalRes);

    }

}
