package com.star.interview.day3;

public class InterQuestions21 {
    /**
     * 根据isOdd和isEven的标准将数组元素分为前后两个部分
     * @param array 数组
     */
    public static void reorderOddEven(int[] array){
        if (array == null || array.length<1)
            return;

        int odd = 0,even = array.length-1;
        int temp=0;
        while (odd<even) {
            temp=0;
            if (isOdd(array[odd])) {
                odd++;
                continue;
            }
            if (isEven(array[even])) {
                even--;
                continue;
            }

            temp = array[even];
            array[even] = array[odd];
            array[odd] = temp;
        }
    }

    /**
     * 数组前端的判断标准
     * @param odd 要判断的数
     * @return true or false
     */
    private static boolean isOdd(int odd){
        return odd % 2 != 0;
    }

    /**
     * 数组后端的判断标准
     * @param even 数
     * @return true or false
     */
    private static boolean isEven(int even){
        return even % 2 == 0;
    }

    public static void main(String[] args) {
        int[] arr = {1,5,6,4,3,2};
        reorderOddEven(arr);
        for (int i : arr) {
            System.out.print(i+",");
        }
    }
}
