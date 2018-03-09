package com.star.interview.day6;

/**
 * 字符串中第一个只出现1次的字符
 */
public class InterQuestions50 {
    /**
     * 查找字符串中第一个只出现1次的字符的方法
     * @param str 查找的对象字符串
     * @return 第一个不重复字符的字符串形式
     */
    public String firstNonRepeatNumber(String str){
        if (str == null ) //参数校验
            return null;

        int[] hashTable = new int[256];
        for (int i=0;i<str.length();i++)
            hashTable[(int) str.charAt(i)]++ ;
        for (int i=0;i<str.length();i++) {
            if (hashTable[str.charAt(i)] == 1)
                return String.valueOf(str.charAt(i));
        }
        return null;
    }

    public static void main(String[] args) {
        InterQuestions50 test = new InterQuestions50();
        String result = test.firstNonRepeatNumber("abc");
        if (result == null)
            System.out.println("不存在只出现1次的字符");
        else
            System.out.println(result);
    }
}
