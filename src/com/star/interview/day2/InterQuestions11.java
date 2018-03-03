package com.star.interview.day2;

/**
 * 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。
 * 输入一个递增排序的数组的一个旋转，输出旋转数组的最小元素。例如，
 * 数组{3,4,5,1,2}为{1,2,3,4,5}的一个旋转，该数组的最小值为1.
 */
public class InterQuestions11 {
    /**
     * 主方法，对外的接口，用于处理数组为空或者数组大小小于1的特殊情况
     * @param arr 数组
     * @return 最小的数
     * @throws Exception 数组输入错误
     */
    public static int getMini(int[] arr) throws Exception {
        if (arr == null || arr.length <= 0)
            throw new Exception("数组输入错误");
        else
            return getMini(arr,0,arr.length-1);
    }

    /**
     * 核心方法。找到并返回最小值
     * @param arr 数组
     * @param start 起始位置
     * @param end 终点位置
     * @return 最小数
     */
    public static int getMini(int[] arr,int start,int end){
        //start<end 针对数组只有一个元素的特殊情况，此时start=end
        //arr[start]>=arr[end] 针对数组本身递增的特殊情况
        while (start < end && arr[start]>=arr[end]) {
            int mid = (start + end) / 2;
            if (arr[start] > arr[mid])
                return getMini(arr, start, mid);
            else if (arr[start] < arr[mid])
                return getMini(arr, mid, end);
            else
                return arr[mid + 1];
        }
        return arr[start];
    }

    public static void main(String[] args) throws Exception {
        int[] a={3,4,5,1,2};
        System.out.println(getMini(a));
    }
}
