package com.star.interview.day5;

import java.util.*;

public class InterQuestions45 {
    /**
     * 定义一种新的比较规则
     * @param m 第一个数
     * @param n 第二个数
     * @return 两者的组合的大小
     */
    public boolean isSmall(String m,String n){
        String result1 = m+n;
        String reslut2 = n+m;
        for (int i =0;i<result1.length();i++){
            if (result1.charAt(i)<reslut2.charAt(i))
                return true;
            if (result1.charAt(i)>reslut2.charAt(i))
                return false;
        }
        return false;
    }
    public void getMin(int[] array){
        if (array == null || array.length<1)
            return ;
        printMinNumber(array,0,array.length-1);
        for(int i : array)
            System.out.print(i);
    }

    /**
     * 使用快速排序的思路进行排序
     * @param arr 数组
     * @param left 起始处
     * @param right 中止处
     */
    public void printMinNumber(int[] arr,int left,int right){
        if(left < right){
            int main_number = arr[right];
            int small_cur = left;
            for(int j = left;j<right;j++){
                if(isSmall(String.valueOf(arr[j]),String.valueOf(main_number))){
                    int temp = arr[j];
                    arr[j] = arr[small_cur];
                    arr[small_cur] = temp;
                    small_cur++;
                }
            }
            arr[right]= arr[small_cur];
            arr[small_cur] = main_number;
            printMinNumber(arr,0,small_cur-1);
            printMinNumber(arr,small_cur+1,right);
        }

    }

    public static void main(String[] args){
        int arr[] = {3,32,321};
        InterQuestions45 test = new InterQuestions45();
        //test.getMin(arr);
        test.printMin(arr);
    }

    /**
     * 使用了ArrayList的排序功能、sort的comparable构造参数以及lambda表达式
     * @param arr 数组
     */
    public void printMin(int[] arr){
        ArrayList<Integer> list = new ArrayList<>();
        for (int anArr : arr)
            list.add(anArr);
        list.sort((o1, o2) -> {  //lambda表达式
            String s1 = o1+""+o2;
            String s2 = o2+""+o1;
            return s1.compareTo(s2);
        });
        for (Integer aList : list) {
            System.out.print(String.valueOf(aList));
        }
    }

}
