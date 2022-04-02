package com.vibex.structure.array;

public class SparseArray {
    public static void main(String[] args) {
        // 创建原始二维数组 11 * 11
        int chessArr[][] = new int[11][11];
        chessArr[1][2] = 1;
        chessArr[2][3] = 2;

        for(int[] row : chessArr) {
            for(int data : row) {
                System.out.printf("%d\t", data);
            }
            System.out.printf("\n");
        }

        // 遍历原始二维数组
        int sum = 0;
        for(int i = 0; i < chessArr.length; i++) {
            for(int j = 0; j < 11; j++) {
                if(chessArr[i][j] != 0) {
                    sum++;
                }
            }
        }

        // 创建对应的稀疏数组
        int sparseArr[][] = new int[sum+1][3];
        sparseArr[0][0] = 11;
        sparseArr[0][1] = 11;
        sparseArr[0][2] = sum;

        int count = 0;
        for(int i = 0; i < chessArr.length; i++) {
            for(int j = 0; j < 11; j++) {
                if(chessArr[i][j] != 0) {
                    count++;
                    sparseArr[count][0] = i;
                    sparseArr[count][1] = j;
                    sparseArr[count][2] = chessArr[i][j];
                }
            }
        }

        // 输出稀疏数组的形式
        System.out.println("--------");
        for (int i = 0; i < sparseArr.length; i++) {
            System.out.printf("%d\t%d\t%d\t\n", sparseArr[i][0], sparseArr[i][1], sparseArr[i][2]);
        }

        // 稀疏数组恢复成原始二维数组
        int chessArr2[][] = new int[sparseArr[0][0]][sparseArr[0][1]];
        for (int i = 1; i < sparseArr.length; i++) {
            chessArr[sparseArr[i][0]][sparseArr[i][1]] = sparseArr[i][2];
        }
    }

}
