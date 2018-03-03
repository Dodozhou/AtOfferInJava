package com.star.interview.day2;

public class InterQuestions17 {
    /**
     * 打印的主方法，对外的调用接口
     * @param n 位数
     */
    public static void printToMaxOfNDigits(int n){
        if (n<1)
            return;
        char[] number = new char[n];
        for (int i=0;i<10;i++){
            number[0]=(char)('0'+i);
            printToMaxOfNDigitsRecursively(number,0);
        }
    }

    /**
     * 打印的核心递归方法
     * @param number 字符数组
     * @param index 标示位置的变量
     */
    private static void printToMaxOfNDigitsRecursively(char[] number,int index) {
        if (index == number.length-1) {
            printNumber(number);
            return;
        }
        for (int i=0;i<10;i++){
            number[index+1] = (char)(i+'0');
            printToMaxOfNDigitsRecursively(number,index+1);
        }
    }

    /**
     * 人性化的打印方法，去掉了数字前面无用的0
     * @param number 数字
     */
    private static void printNumber(char[] number) {
        boolean isReady = false;
        for (int i=0;i<number.length;i++){
            if (!isReady && number[i] == '0')
                continue;
            isReady = true;
            System.out.print(number[i]);
        }
        System.out.println();
    }

    public static void main(String[] args) {
        printToMaxOfNDigits(2);
    }


}
