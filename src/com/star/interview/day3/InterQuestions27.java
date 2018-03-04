package com.star.interview.day3;

import com.sun.org.apache.bcel.internal.generic.BIPUSH;

/**
 * 求二叉树的镜像
 */
public class InterQuestions27 {
    public void mirrorRecursively(BinaryTreeNode tree){
        if (tree == null)
            return ;
        if (tree.left == null && tree.right == null)
            return ;
        //交换左右子节点
        BinaryTreeNode temp = tree.left;
        tree.left = tree.right;
        tree.right = temp;

        if (tree.left!=null)
            mirrorRecursively(tree.left);
        if (tree.right != null)
            mirrorRecursively(tree.right);
    }

    /**
     * 在Java里面只有基本类型和按照下面这种定义方式的String是按值传递，
     * 其它的都是按引用传递。就是直接使用双引号定义字符串方式：String str = “Java私塾”;
     * @param args 参数
     */
    public static void main(String[] args) {
        BinaryTreeNode tree1 = new BinaryTreeNode(0.501);
        BinaryTreeNode node1 = new BinaryTreeNode(1.501);
        BinaryTreeNode node2 = new BinaryTreeNode(2.501);
        tree1.left=node1;
        tree1.right = node2;
        System.out.println(tree1.nValue);
        System.out.println(tree1.left.nValue);
        System.out.println(tree1.right.nValue);

        InterQuestions27 mirror = new InterQuestions27();
        mirror.mirrorRecursively(tree1);
        System.out.println(tree1.nValue);
        System.out.println(tree1.left.nValue);
        System.out.println(tree1.right.nValue);
    }
}
