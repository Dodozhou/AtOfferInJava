package com.star.interview.day1;

public class InterQuestions3 {

    /**
     * 在一个长度为n的数组里的所有数字都在0~n-1的范围内。数组中某些数字是重复的，
     * 但不知道有几个数字重复了，也不知道每个数字重复了几次。请找出数组中任意一个重复的数字
     * 。例如，如果输入长度为7的数组{2,3,1,0,2,5,3}，那么对应的输出是重复的数字2或者3。
     * @param array 查找的数组
     * @return 重复值或者-1（异常）
     */
    public static int duplicate(int[] array){
        //安全验证部分
        if (array == null || array.length <= 0 )
            return -1;
        for (int i=0;i<array.length;i++){
            if (array[i] < 0 || array[i]>array.length -1)
                return -2;
        }

        //算法实现部分
        for (int i=0;i<array.length;i++){
            while (array[i] != i){
                if (array[i] == array[array[i]]){
                    return array[i];
                }
                int temp = array[i];
                array[i] = array[temp];
                array[temp] = temp;
            }
        }
       return -1;
    }

    /**
     * 测试例程
     * @param args 0
     */
    public static void main(String[] args) {
        int[] array = {2,3,1,0,3,5,2};
        int dup = duplicate(array);
        if (dup == -1)
            System.out.println("不存在重复数字");
        else if (dup == -2)
            System.out.println("输入的数组不符合条件");
        else
            System.out.println("重复数字是："+dup);
    }
}
