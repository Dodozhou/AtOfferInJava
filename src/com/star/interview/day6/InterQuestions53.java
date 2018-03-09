package com.star.interview.day6;

import com.star.interview.day1.InterQuestions5;

/**
 * 数字在排序数组中出现的次数
 */
public class InterQuestions53 {
    /**
     * 通过二分查找法，以O(logn)时间得到数字在有序数组中出现的次数
     * @param array 数组
     * @param num 要查找的数字
     * @return 要查找数字的个数
     */
    public int timesOfANumber(int[] array,int num){
        int number = 0;
        if (array != null && array.length>0) {
            int firstIndex = firstLocationOfNum(array, 0, array.length, num);
            int lastIndex = lastLocationOfNum(array, 0, array.length, num);
            if (lastIndex > -1 && firstIndex >-1)
                number = lastIndex - firstIndex + 1;
        }
        return number;
    }

    /**
     * 求num的第一个数字的方法
     * @param array 数组
     * @param start 起始位置
     * @param end 终止位置
     * @param num 要查找的数字
     * @return num的第一个位置
     */
    private int firstLocationOfNum(int[] array, int start, int end, int num) {
        if (start<end) {
            int mid = (start + end) / 2;
            if (num < array[mid] || (num == array[mid] && array[mid - 1] == num))
                return firstLocationOfNum(array, start, mid - 1, num);
            if (num > array[mid])
                return firstLocationOfNum(array, mid + 1, end, num);
            if (num == array[mid])
                return mid;
        }
        return -1;
    }

    /**
     * 找到最后一个num的位置
     * @param array 数组
     * @param start 起始位置
     * @param end 终止位置
     * @param num 要寻找的数字
     * @return 最后一个num的位置
     */
    private int lastLocationOfNum(int[] array, int start, int end, int num) {
        if (start<end) {
            int mid = (start + end) / 2;
            if (num < array[mid])
                return lastLocationOfNum(array, start, mid - 1, num);
            if (num > array[mid] || (num == array[mid] && array[mid + 1] == num))
                return lastLocationOfNum(array, mid + 1, end, num);
            if (num == array[mid])
                return mid;
        }
        return -1;
    }

    public static void main(String[] args) {
        InterQuestions53 test = new InterQuestions53();
        int[] a= {1,2,2,2,2,3,4,5};
        System.out.println(test.timesOfANumber(a,2));
    }
}
