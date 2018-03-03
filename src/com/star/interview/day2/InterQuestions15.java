package com.star.interview.day2;

public class InterQuestions15 {
    /**
     * 利用了如下原理：“一个数减1，再和原数相与，能去掉该数二进制表示中的最右边的一个1”
     * @param n 整数
     * @return 1的个数
     */
    public static int numOfOne(int n){
        if (n == 0)
            return 0;
        int count=0;
        while (n != 0){
            count++;
            n = (n-1) & n;
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(numOfOne(0));
        System.out.println(numOfOne(8));
        int n = -10;
        System.out.println(n + "的二进制中1的个数：" + numOfOne(n));
    }
}
