package com.star.interview.day4;

public class InterQuestions29 {
    /**
     * 打印矩阵的接口方法，是递归方法的入口
     * @param matrix 要打印的矩阵
     */
    public void printMatrix(int[][] matrix){
        if (matrix == null)
            return;
        int row = 0,col = 0;
        int rows = matrix.length,cols = matrix[0].length;

        printCore(matrix,row,col,rows,cols);
    }

    /**
     * 打印矩阵的核心递归方法
     * @param matrix 矩阵
     * @param row 打印起始的起始行
     * @param col 打印起始的起始列
     * @param rows 还没打印的行数
     * @param cols 还没打印的列数
     */
    private void printCore(int[][] matrix, int row, int col, int rows, int cols) {
        if (rows < 1 || cols<1)
            return;
        //第一步，打印一行
        for (int i =0;i<cols;i++)
            System.out.print(matrix[row][col + i] + " ");

        //第二步，需要条件rows>1
        if (rows>1){
            for (int j =1;j<rows;j++)
                System.out.print(matrix[row+j][col+cols-1]+" ");
        }
        //第三步，需要条件中间的矩阵至少要有两行两列
        if (rows>=2 && cols>=2){
            for (int m =1;m<cols;m++)
                System.out.print(matrix[row+rows-1][col+cols-1-m]+" ");
        }

        //第四部，至少有3行2列
        if (rows>=3 && cols>=2){
            for (int n=1;n<=rows-2;n++)
                System.out.print(matrix[row+rows-1-n][col]+" ");
        }
        printCore(matrix,row+1,col+1,rows-2,cols-2);
    }
    //测试方法
    public static void main(String[] args) {
        InterQuestions29 test = new InterQuestions29();
        int[][] matrix0 = {{1,2,3},{5,6,7},{9,10,11},{13,14,15}};
        int[][] matrix1 = {{1,2,3,4},{5,6,7,8}};
        int[][] matrix2 = {{1}};
        int[][] matrix3 = {{}};
        int[][] matrix4 = null;
        System.out.println("mateix0:");
        test.printMatrix(matrix0);
        System.out.println("mateix1:");
        test.printMatrix(matrix1);
        System.out.println("mateix2:");
        test.printMatrix(matrix2);
        System.out.println("mateix3:");
        test.printMatrix(matrix3);
        System.out.println("mateix4:");
        test.printMatrix(matrix4);
    }
}