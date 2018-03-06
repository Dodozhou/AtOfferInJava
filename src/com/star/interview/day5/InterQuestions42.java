package com.star.interview.day5;

/**
 * 连续子数组的最大和
 */
public class InterQuestions42 {
    /**
     * 连续子数组的最大和
     * @param array 数组
     * @return 子数组的最大和
     * @throws Exception 非法输入异常
     */
    public int greatestSumOfSubArray(int[] array) throws Exception {
        if (array == null|| array.length<1)
            throw new Exception("invalid input!");
        int greatestSum=0;
        int curSum =0;
        for (int i=0;i<array.length;i++){
            if (curSum <= 0)
                curSum = array[i];
            else
                curSum += array[i];

            if (curSum>greatestSum)
                greatestSum = curSum;
        }
        return greatestSum;
    }

    public static void main(String[] args) throws Exception {
        InterQuestions42 test = new InterQuestions42();
        int[] array = {1,-2,3,10,-4,7,2,-5};
        int[] array2 = {-1,-5,-2,-6,-8};
        System.out.println(test.greatestSumOfSubArray(array));
        System.out.println(test.greatestSumOfSubArray(array2));
    }
}
