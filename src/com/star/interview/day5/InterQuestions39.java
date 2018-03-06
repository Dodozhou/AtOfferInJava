package com.star.interview.day5;

/**
 * 找出数组中出现次数超过一半的数字
 */
public class InterQuestions39 {
    /**
     * 找出数组中出现次数超过一半的数字
     * @param array 要查找的数组
     * @return 超过一半的数字
     * @throws Exception 当数组为空是抛异常
     */
    public int moreThanHalfNum(int[] array) throws Exception {
        if (array == null || array.length == 0)
            throw new Exception();
        int num;
        int times=1;
        num = array[0];
        for (int i=1;i<array.length;i++){
            if (num == array[i]){
                times++;
            }else{
                if (times == 0) {
                    num = array[i];
                    times =1;
                }
                else
                    times--;
            }
        }
        return num;
    }

    public static void main(String[] args){
        InterQuestions39 test = new InterQuestions39();
        int[] array = {1,2,3,2,2};
        try {
            System.out.println(test.moreThanHalfNum(array));
        } catch (Exception e) {
            System.out.println("the array is null!");
        }
    }
}
