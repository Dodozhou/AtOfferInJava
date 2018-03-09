package com.star.interview.day6;

/**
 * 给定一个数字，我们按照如下规则把它翻译为字符串：0翻译成“a”，
 * 1翻译成“b”，......，11翻译成“l”，......，25翻译成“z”。
 * 一个数字可能有多个翻译。例如，12258有5种翻译，分别是“bccfi”、“bwfi”、
 * “bczi”、“mcfi”和“mzi”。请编程实现一个函数，用来计算一个数字有多少种不同的翻译方法。
 */
public class InterQuestions46 {
    public static int getTranslationCount(int number){
        if(number<0)
            return 0;
        if(number==1)
            return 1;
        return getTranslationCount(Integer.toString(number));
    }
    //动态规划，从右到左计算。
    //f(r-2) = f(r-1)+g(r-2,r-1)*f(r);
    //如果r-2，r-1能够翻译成字符，则g(r-2,r-1)=1，否则为0
    public static int getTranslationCount(String number) {
        int f1 = 0,f2 = 1,g = 0;
        int temp;
        for(int i=number.length()-2;i>=0;i--){
            if(Integer.parseInt(number.charAt(i)+""+number.charAt(i+1))<26)
                g = 1;
            else
                g = 0;
            temp = f2;
            f2 = f2+g*f1;
            f1 = temp;
        }
        return f2;
    }
    public static void main(String[] args){
        System.out.println(getTranslationCount(-10));  //0
        System.out.println(getTranslationCount(1234));  //3
        System.out.println(getTranslationCount(12258)); //5
    }

}
