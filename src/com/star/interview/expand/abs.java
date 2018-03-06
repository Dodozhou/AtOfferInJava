package com.star.interview.expand;

public class abs {
    /**
     * 不用任何判断和库函数，求一个整数的绝对值
     * >>>是无符号右移，无论正负，左边都补0
     * @param num 整数
     * @return 绝对值
     */
    public static int myAbs(int num)
    {
        return num * (1 - ((num >>> 31)<<1));
    }

    public static void main(String[] args) {
        System.out.println(myAbs(-5));
        System.out.println(myAbs(5));
    }
}
