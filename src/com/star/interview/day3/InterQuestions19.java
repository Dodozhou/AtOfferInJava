package com.star.interview.day3;

public class InterQuestions19 {
    /**
     * 字符串匹配的主方法，负责处理字符串为空等特殊情况，以及核心递归方法的调用
     * @param str 字符串
     * @param pattern 模式
     * @return true or false
     */
    public static boolean match(String str,String pattern){
        if (str == null || pattern == null)
            return false;
        if (str.equals("") && pattern.equals(""))
            return true;
        return matchCore(str,0,pattern,0);
    }

    /**
     * 匹配的核心递归方法
     * @param str 字符串
     * @param strIndex 当前遍历到的字符串的位置
     * @param pattern 模式
     * @param ptnIndex 当前遍历到的模式的位置
     * @return true or false
     */
    private static boolean matchCore(String str,int strIndex, String pattern,int ptnIndex) {
        //出口1，str和patter都到了末尾
        if (strIndex==str.length() && ptnIndex==pattern.length())
            return true;
        //出口2，str没有到末尾，pattern到了末尾
        if (strIndex !=str.length() &&  ptnIndex == pattern.length())
            return false;
        //出口3，str到末尾，pattern没到末尾
        if (strIndex == str.length() &&  ptnIndex != pattern.length())
            return false;

        //第二个字符是*的情况
        if (ptnIndex+1<pattern.length() && pattern.charAt(ptnIndex+1)== '*'){
            if (pattern.charAt(ptnIndex) == '.' || str.charAt(strIndex) == pattern.charAt(ptnIndex)){
                return matchCore(str,strIndex+1,pattern,ptnIndex+2) //出现一次
                        || matchCore(str,strIndex+1,pattern,ptnIndex) //出现多次
                        || matchCore(str,strIndex,pattern,ptnIndex+2); //出现0次
            }else
                return matchCore(str,strIndex,pattern,ptnIndex+2);//首字母不匹配
        }

        //第二个字符不是*
        if (str.charAt(strIndex) == pattern.charAt(ptnIndex) || pattern.charAt(ptnIndex) == '.')
            return matchCore(str,strIndex+1,pattern,ptnIndex+1);
        return false;

    }

    public static void main(String[] args) {
        String str = "a";
        String pattern = ".";
        System.out.println(str+" "+match(str,pattern)+" "+pattern);

        String str1 = "aaa";
        String pattern1 = "ab*ac*a";
        System.out.println(str1+" "+match(str1,pattern1)+" "+pattern1);

        String str2 = "aaa";
        String pattern2 = "aa.a";
        System.out.println(str2+" "+match(str2,pattern2)+" "+pattern2);
        String str3 = "aaa";
        String pattern3 = "ab*a";
        System.out.println(str3+" "+match(str3,pattern3)+" "+pattern3);
    }
}
