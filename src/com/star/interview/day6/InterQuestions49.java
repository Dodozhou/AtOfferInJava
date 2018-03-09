package com.star.interview.day6;

/**
 * 丑数
 */
public class InterQuestions49 {
    /**
     * 求第index个丑数
     * @param index 第index个
     * @return 第index个丑数
     */
    public int getUglyNumber(int index){
        if (index<1)
            return -1;
        //三个标记变量
        int T2=0,T3=0,T5=0;
        int nextUglyNum = 0;//下一个丑数
        int[] uglyNumbers = new int[index];
        uglyNumbers[0] = 1;
        for (int i=1;i<index;i++){
            nextUglyNum = getMin(2*uglyNumbers[T2],3*uglyNumbers[T3],5*uglyNumbers[T5]);
            uglyNumbers[i] = nextUglyNum;
            while (2*uglyNumbers[T2] <= nextUglyNum)
                T2++;
            while (3*uglyNumbers[T3] <= nextUglyNum)
                T3++;
            while (5*uglyNumbers[T5] <= nextUglyNum)
                T5++;
        }
        return uglyNumbers[index-1];
    }

    /**
     * 返回3个数中的最小数
     * @param num1 数字1
     * @param num2 数字2
     * @param num3 数字3
     * @return 最小的数
     */
    private int getMin(int num1, int num2, int num3) {
        int min = num1<num2 ? num1:num2;
        return min<num3 ? min:num3;
    }

    public static void main(String[] args) {
        InterQuestions49 test = new InterQuestions49();
        for (int i = 0;i<10;i++)
        System.out.println(test.getUglyNumber(i));

    }
}
