package com.star.interview.day2;

public class InterQuestions13 {
    /**
     * 计算可以进入的格子数目
     * @param rows 行数
     * @param cols 列数
     * @param k 限制值
     * @return 步数
     */
    public static int movingCount(int rows,int cols,int k){
        int count = 0;
        for (int row=0;row<rows;row++)
            for (int col=0;col<cols;col++)
                if (getDigitSum(row,col)<k)
                    count++;
        return count;
    }

    /**
     * 计算两个数字的位数和
     * @param row 行
     * @param col 列
     * @return 位数和
     */
    private static int getDigitSum(int row, int col) {
        int sum = 0;
        while (row>0) {
            sum += row % 10;
            row /= 10;
        }
        while (col>0){
            sum += col%10;
            col /=10;
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(movingCount(4,4,4));
    }


}
