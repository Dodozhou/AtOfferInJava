package com.star.interview.day2;

/**
 * 求出斐波那契数列的第n项
 */
public class InterQuestions10 {
    /**
     * 求斐波拉契数列的第n项。
     * @param n 第n项
     * @return 第n项的值
     */
    public static long Fibonacci(int n){
        int[] result  = {0,1};
        if (n<0)
            return -1;
        if (n<2)
            return result[n];

        long fibNMinusOne = 1;
        long fibNMinusTwo = 0;
        long fibN = 0;
        for (int i=2;i<=n;i++){
            fibN = fibNMinusOne+fibNMinusTwo;

            fibNMinusTwo = fibNMinusOne;
            fibNMinusOne = fibN;
        }

        return fibN;
    }

    public static void main(String[] args) {
        System.out.println(Fibonacci(6));
    }
}
