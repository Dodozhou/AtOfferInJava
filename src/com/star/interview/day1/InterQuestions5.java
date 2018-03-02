package com.star.interview.day1;



import java.util.Arrays;


/**
 * 请实现一个函数，把字符串中的每个空格替换成%20.例如，输入“We are happy.”，则输出“we%20are%20happy.”。
 */
public class InterQuestions5 {
    /**
     * 替换字符串中的空格
     * @param str 字符串
     * @return 替换后的字符串
     */
    public static char[] replaceSpace(String str){
        if(str == null || str.length() == 0)
            return null;

        int spCount=0;
        int i,j;
        char[] chars = str.toCharArray();
        //计算空格的个数
        for (char aChar : chars) {
            if (aChar == ' ')
                spCount++;
        }
        //发现一个新的空格，新数组的长度就要加2
        char[] newChars = new char[chars.length+2*spCount];

        i=chars.length-1;
        j=newChars.length-1;
        //处理原始字符串中第一个空格及之后的字符
        while (i != j) {
            while (chars[i] != ' ') {
                newChars[j--] = chars[i--];
            }
            newChars[j--] = '0';
            newChars[j--] = '2';
            newChars[j--] = '%';
            //处理完成，跳过空格
            i--;
        }
        //将第一个空格前的字符复制到新字符数组中去
        for (int m=i;m>=0;m--){
            newChars[m] = chars[m];
        }
        return newChars;
    }

    public static void main(String[] args) {
        String s0 = "we are happy.";
        char[] s1 = replaceSpace(s0);
        System.out.println(new String(s1));
        //不能使用如下方式打印字符数组
        //System.out.println(s1.toString());
        /*用System.out.print()显示某个对象时，会调用该对象的toString()方法，对于数组也一样。
        而对于数组，调用toString()的默认实现是打印对象类型+hashCode()
         */

    }
}
