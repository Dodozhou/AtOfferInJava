package com.star.interview.day2;

/**
 * 回溯法求矩阵路径
 */
public class InterQuestions12 {
    /**
     * 计算矩阵路径的主方法，进行参数校验，递归控制的工作。
     * @param matrix 矩阵
     * @param rows 行数
     * @param cols 列数
     * @param str 需要匹配字符数组
     * @return true 字符串匹配成功 or false 字符串匹配失败
     */
    public static boolean hasPath(char[] matrix,int rows,int cols,char[] str){
        if (matrix == null || rows<1 || cols<1 || str == null)  //参数校验
            return false;

        boolean[] visit = new boolean[rows*cols]; //标记矩阵，访问过的置true

        for (int i=0;i<rows;i++)
            for (int j = 0;j<cols;j++)
                if (hasPathCore(matrix,rows,cols,i,j,str,0,visit))
                    return true;
        return false;
    }

    /**
     * 查找矩阵路径的核心方法。负责路径匹配和回退等工作。
     * @param matrix 矩阵
     * @param rows 总行数
     * @param cols 总列数
     * @param row 当前行数
     * @param col 当前列数
     * @param str 需要匹配的字符数组
     * @param current 当前位置
     * @param visit 标记矩阵
     * @return true当前位置符合 or false 当前位置不符合
     */
    private static boolean hasPathCore(char[] matrix, int rows, int cols, int row, int col, char[] str, int current, boolean[] visit) {
        int index = row*cols+col; //当前位置
        if (row >= rows || col>=cols ||row <0 || col<0 || visit[index] || matrix[index] != str[current])
            return false;

        visit[index] = true; // current下标的字符匹配成功
        if (current == str.length-1) //字符串的最后一个字符匹配成功，结束
            return true;

        current++; //准备匹配下一个字符
        if (hasPathCore(matrix,rows,cols,row-1,col,str,current,visit) ||
            hasPathCore(matrix,rows,cols,row+1,col,str,current,visit) ||
            hasPathCore(matrix,rows,cols,row,col-1,str,current,visit)  ||
            hasPathCore(matrix,rows,cols,row,col+1,str,current,visit))
            return true;
        current--; //四个方向都不对，返回上一层
        visit[index] = false;
        return false;
    }

    public static void main(String[] args) {
        char[] matrix = {'a','b','c','e',
                        's','f','c','s',
                        'a','d','e','e'};
        String str = "abfb";
        System.out.println(hasPath(matrix, 3, 4, str.toCharArray()));
    }


}
