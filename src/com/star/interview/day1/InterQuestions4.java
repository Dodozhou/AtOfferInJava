package com.star.interview.day1;

public class InterQuestions4 {
    public static void main(String[] args) {
        int[][] arr={{1,2,8,9},{2,4,9,12},{4,7,10,13},{6,8,11,15}};
        System.out.println(findNumber(arr,7));
    }

    /**
     *在一个二维数组中，每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增排序。
     * 请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
     * @param array 数组
     * @param num 要查找的数字
     * @return 找到：true 找不到：false
     */
    public static boolean findNumber(int[][] array, int num){
        //安全验证部分
        if (array == null)
            return false;
        //算法部分
        int i=0;
        int j=array[0].length -1;
        while (i <array.length && j >=0) {
            if (num == array[i][j])
                return true;
            else if (num < array[i][j])
                j--;
            else
                i++;
        }
        return false;
    }
}
