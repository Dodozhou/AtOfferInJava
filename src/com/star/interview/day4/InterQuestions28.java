package com.star.interview.day4;

class BinaryTreeNode{
    double nValue;
    BinaryTreeNode left;
    BinaryTreeNode right;
    public BinaryTreeNode(double nValue) {
        this.nValue = nValue;
    }
}
/**
 * 求解二叉树是否对称
 */
public class InterQuestions28 {
    /**
     * 入口方法，负责进行参数校验和递归调用
     * @param root 树
     * @return 是否对称
     */
    public static boolean isSymmetrical(BinaryTreeNode root) {
        return root == null || isSymmetrical(root, root);
    }

    /**
     * 核心递归方法，进行前序遍历和对称前序遍历对应位置的比较
     * @param tree1 root树
     * @param tree2 root树
     * @return true 对称 or false 不对称
     */
    private static boolean isSymmetrical(BinaryTreeNode tree1, BinaryTreeNode tree2){
        if (tree1 == null && tree2 == null)
            return true;
        if (tree1 == null || tree2 == null)
            return false;
        if (tree1.nValue != tree2.nValue)
            return false;
        return isSymmetrical(tree1.left,tree2.right) && isSymmetrical(tree1.right,tree2.left);
    }


}
