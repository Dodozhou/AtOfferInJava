package com.star.interview.day5;

/**
 * 字符串的排列
 */
public class InterQuestions38 {
    /**
     * 求一个字符串的全排列
     * @param str 字符串
     * @param i 当前起始位置
     */
    public static void permutation(char[] str, int i) {
        if (i >= str.length)
            return;
        if (i == str.length - 1) {
            System.out.println(String.valueOf(str));
        } else {
            for (int j = i; j < str.length; j++) {
                char temp = str[j];
                str[j] = str[i];
                str[i] = temp;

                permutation(str, i + 1);

                temp = str[j];
                str[j] = str[i];
                str[i] = temp;
            }
        }
    }

    public static void main(String[] args) {
        String s = "abc";
        permutation(s.toCharArray(),0);
    }

}
