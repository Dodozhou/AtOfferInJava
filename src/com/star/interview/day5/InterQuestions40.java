package com.star.interview.day5;

/**
 * 最小的k个数
 */
public class InterQuestions40 {
    /**
     * 以数组的left位置的数作为枢纽值，对数组进行一趟快速排序，找到枢纽值的恰当位置，并返回该位置
     * @param arr 数组
     * @param left 数组的左边界
     * @param right 数组的右边界
     * @return 左边界数值的最终位置
     */
    public int partition(int[] arr, int left, int right) {

        int result = arr[left];
        if (left > right)
            return -1;

        while (left < right) {
            while (left < right && arr[right] >= result) {
                right--;
            }
            arr[left] = arr[right];
            while (left < right && arr[left] < result) {
                left++;
            }
            arr[right] = arr[left];
        }
        arr[left] = result;
        return left;
    }

    /**
     * 求最小k个数的核心方法。
     * @param input 输入的数组
     * @param k 前k个最小数
     * @return 包含k个最小数的数组
     */
    public int[] getLeastNumbers(int[] input,int k){
        if(k==0 || input == null || input.length == 0)
            return null;

        int start = 0,end = input.length-1;
        int index = partition(input,start,end);
        int[] output = new int[k];
        while (index!=k-1) {
            if (index > k - 1) {
                end = index-1;
                index = partition(input, start, end);
            } else {
                start = index+1;
                index = partition(input, start, end);
            }
        }
        for(int i = 0;i<k;i++){
            output[i] = input[i];
        }
        return output;
    }

    public static void main(String[] args){
        int[] arr= {4,5,1,6,2,2,3,8};
        InterQuestions40 test = new InterQuestions40();
        int[] output=test.getLeastNumbers(arr, 4);
        for(int i = 0;i<output.length ;i++){
            System.out.print(output[i]+",");
        }
    }
}
