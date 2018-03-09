package com.star.interview.day6;

/**
 *在一个mXn的期盼的每一格都放一个礼物，每个礼物都有一定的价值（价值大于0）。
 * 你可以从棋盘的左上角开始拿格子里的礼物，并每次向右或者向下移动一格，直到到达棋盘的右下角。
 * 给定一个棋盘及其上面的礼物，请计算你最多能拿到多少价值的礼物？
 */
public class InterQuestions47 {
    /**
     * 求解矩阵礼物最大值
     * @param array 矩阵数组，一维表示
     * @param rows 行数
     * @param cols 列数
     * @return 最大价值
     */
    public int getMaxValue(int[] array,int rows,int cols){
        //参数校验
        if (array == null|| rows == 0 || cols == 0)
            return 0;
        /*
         * maxValues用来存储到达当前行、当前列时能得到的最大礼物价值。之所以可以用一维数组，是因为j位置存储着
         * 到达它上方元素的最大价值。而我们需要的仅仅是矩阵最后一行，最后一列的一个元素的最大价值。因此，
         * 可以让当前行数-2的数据别覆盖。
         */
        int[] maxValues = new int[cols];
        for (int  i=0;i<rows;i++){
            for (int j=0;j<cols;j++){
                int left = 0;
                int up = 0;
                if (i>0)
                    up = maxValues[j];  //它上方位置的最大价值
                if (j>0)
                    left = maxValues[j-1];  //它左边位置的最大价值
                //上方和左边的最大价值取较大者，并加上当前位置的价值
                maxValues[j] = Math.max(left,up)+array[i*cols+j];
            }
        }
        return maxValues[cols-1]; //返回最后一行，最后一列的最大价值
    }

    public static void main(String[] args) {
        int[] arr = {1,10,3,8,
                     12,2,9,6,
                     5,7,4,11,
                     3,7,16,5};
        int[] arr1 = {1};
        InterQuestions47 test = new InterQuestions47();
        System.out.println(test.getMaxValue(arr,1,1));
    }

}
