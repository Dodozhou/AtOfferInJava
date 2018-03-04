package com.star.interview.day3;

/**
 * 表示数值的字符串
 */
public class InterQuestions20 {
    /**
     * 字符串的字符数组形式
     * @param str 字符数组
     * @return true or false
     */
    public boolean isNumeric(char[] str) {
        //标记符号、小数点、e是否出现过
        boolean sign = false;
        boolean decimal = false;
        boolean hasE = false;
        for (int i=0;i<str.length;i++) {
            if (str[i] == 'e' || str[i] == 'E') {
                if (i == str.length - 1) return false;
                if (hasE) return false;
                hasE = true;
            } else if (str[i] == '+' || str[i] == '-') {
                if (sign && str[i - 1] != 'e' && str[i - 1] != 'E') return false;
                if (!sign && i > 0 && str[i - 1] != 'e' && str[i - 1] != 'E') return false;
                sign = true;
            } else if (str[i] == '.') {
                if(hasE||decimal) return false;
                decimal = true;
            } else if (str[i] < '0' || str[i] > '9') {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        InterQuestions20 test = new InterQuestions20();
        System.out.println(test.isNumeric("-1E-16".toCharArray()));
        System.out.println(test.isNumeric("12e+4.3".toCharArray()));
    }
}
