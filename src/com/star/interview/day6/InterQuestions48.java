package com.star.interview.day6;

/**
 * 请从字符串中找出一个最长的不包含重复字符的子字符串，计算该最长子字符串的长度。
 * 假设字符串中只包含'a'~'z'的字符。例如，在字符串“arabcacfr”中，最
 * 长的不含重复字符的子字符串是“acfr”，长度为4.
 */
public class InterQuestions48 {
    /**
     * 获取最长不包含重复字符的子字符串
     * @param str 字符串
     * @return 长度
     */
    public int longestSubStringWithoutDuplication(String str){
        if (str == null || str.length()<1)
            return 0;
        int[] maxValues= new int[26];
        int curLength = 0;
        int maxLength = 0;
        for (int i:maxValues)
            maxValues[i] = -1;

        for (int i=1;i<str.length();i++){
            int preIndex = maxValues[str.charAt(i)-'a']; //获取该字符上一次出现的位置
            if ( preIndex<0 || i-preIndex > curLength)  //该字符之前没出现过或者出现过但是在当前长度范围外
                ++curLength;   //当前长度加一
            else{
                if (curLength>maxLength)  //当前长度大于最大长度，更新最大长度
                    maxLength = curLength;

                curLength = i-preIndex;  //跟新当前长度为两次相同字符的间距
            }
            maxValues[str.charAt(i)-'a'] = i; //更新该字符上一次出现的位置
        }
        if (curLength>maxLength)
            maxLength = curLength;
        return maxLength;
    }

    public static void main(String[] args) {
        InterQuestions48 test = new InterQuestions48();
        System.out.println(test.longestSubStringWithoutDuplication("arabcacfr"));
    }
}
