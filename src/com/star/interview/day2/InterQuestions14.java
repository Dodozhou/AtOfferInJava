package com.star.interview.day2;

public class InterQuestions14 {
    /**
     * 基于动态规划思想的实现方式
     * @param len 绳子长度
     * @return 最大乘积
     */
    public static int maxAfterCutting_Solution1(int len){
        if (len <2)
            return 0;
        if (len == 2)
            return 1;
        if (len == 3)
            return 2;

        int[] products = new int[len+1];
        products[0] = 0;
        products[1] = 1;
        products[2] = 2;
        products[3] = 3;

        int max = 0;
        for (int i=4;i<=len;i++){
            max=0;
            for (int j=1;j<=i/2;j++){
                int product = products[j]*products[i-j];
                if (max < product)
                    max = product;
            }
            products[i]=max;
        }

        return products[len];
    }

    /**
     * 基于贪婪算法的思想，尽可能多地剪长度等于3的段
     * @param len 绳子长度
     * @return 最大乘积
     */
    public static int maxAfterCutting_Solution2(int len){
        if (len <2)
            return 0;
        if (len == 2)
            return 1;
        if (len == 3)
            return 2;

        //尽可能多地减去长度为3的是绳子段
        int timesOf3 = len/3;
        if (len-timesOf3*3 == 1)
            timesOf3 -= 1;
        int timesOf2 = (len-timesOf3*3)/2;

        return (int)(Math.pow(3,timesOf3)*Math.pow(2,timesOf2));
    }

    public static void main(String[] args) {
        System.out.println(maxAfterCutting_Solution1(7));
        System.out.println(maxAfterCutting_Solution2(7));
    }
}
