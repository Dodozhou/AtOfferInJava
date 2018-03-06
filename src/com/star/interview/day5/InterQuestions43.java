package com.star.interview.day5;

/**
 * 1~n整数中1出现的次数
 * 比较复杂，多看几遍
 */
public class InterQuestions43 {
    /**
     * 求1的出现次数
     * @param n 1~n
     * @return 出现的次数
     */
    public int count(int n){
        if (n<1)
            return 0;
        int count = 0;
        int base = 1;
        int round = n;
        while (round>0){
            int weight = round%10;
            round/=10;
            count += round*base;
            if (weight == 1)
                count+=(n%base)+1;
            else if (weight>1)
                count+=base;
            base*=10;
        }
        return count;
    }

    public static void main(String[] args) {
        InterQuestions43 test = new InterQuestions43();
        System.out.println(test.count(12));
    }

}
