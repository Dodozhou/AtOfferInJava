package com.star.interview.day5;

public class InterQuestions44 {
    /**
     * 求digits位数字总共有多少个
     * @param digits 数字的位数
     * @return 总共有多少个
     */
    public int countOfIntegers(int digits){
        if (digits == 1)
            return 10;
        return (int)(9*Math.pow(10,digits-1));
    }

    public int digitAtIndex(int index){
        if (index<0)
            return -1;

        int digits = 1;
        while (true){
            int numbers = countOfIntegers(digits);
            if (index<numbers*digits)
                return digitAtIndex(index,digits);
            index -= numbers*digits;
            digits++;
        }
    }

    /**
     * 当已经知道了要找的那一位数字是几位数，可以用如下函数求得那一位数字
     * @param index 数字
     * @param digits 位数
     * @return 那一位数字
     */
    private int digitAtIndex(int index, int digits) {
        int number = beginNumber(digits)+index/digits;
        int indexFromRight = digits -index%digits;
        for (int i=1;i<indexFromRight;i++)
            number/=10;
        return number%10;
    }

    /**
     * 求第一个m位数。如第一个1位数是0，第一个2位数是10.
     * @param digits 位数
     * @return 起始数字
     */
    private int beginNumber(int digits) {
        if (digits ==1)
            return 0;
        return (int)Math.pow(10,digits-1);
    }
}
