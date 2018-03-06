package com.star.interview.day4;

/**
 * 二叉搜索树的后序遍历序列
 */
public class InterQuestions33 {
    /**
     * 验证序列是否为二叉搜索树的后续遍历
     * @param seq 要验证的序列
     * @param start  序列的起始位置
     * @param end 序列的结束位置
     * @return 是或否
     */
    public boolean verifySeqOfBST(int[] seq,int start,int end){
        //参数校验
        if (seq == null || seq.length == 0)
            return false;
        //成功出口
        if (end == start || end-start == 1)
            return true;
        int root = seq[end];

        //找出右子树的第一个节点
        int i=start;
        for (;i<end;i++){
            if (seq[i]>root)
                break;
        }
        //验证右子树是否大于根节点
        int j=i;
        for (;j<end;j++){
            if (seq[j]<root)
                return false;
        }
        //左子序列递归验证
        boolean left = false;
        if (i>start)
            left = verifySeqOfBST(seq,start,i-1);
        //右子序列递归验证
        boolean right = false;
        if (i<end)
            right = verifySeqOfBST(seq,i,end-1);

        return left && right;
    }

    public static void main(String[] args) {
        InterQuestions33 test = new InterQuestions33();
        int[] a = {5,7,6,9,11,10,8};
        int[] b= {7,4,6,5};
        int[] c= {2,4};
        System.out.println(test.verifySeqOfBST(a,0,a.length-1));
        System.out.println(test.verifySeqOfBST(b,0,b.length-1));
        System.out.println(test.verifySeqOfBST(c,0,c.length-1));
    }
}
