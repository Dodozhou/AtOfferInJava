package com.star.interview.day4;

import java.util.Iterator;
import java.util.Stack;

class BinaryTreeNodeFor34{
    int nValue;
    BinaryTreeNodeFor34 left;
    BinaryTreeNodeFor34 right;

    public BinaryTreeNodeFor34(int nValue) {
        this.nValue = nValue;
    }
}
/**
 * 打印出二叉树中和为一个特定整数的路径
 */
public class InterQuestions34 {

    /**
     * 求路径的核心方法
     * @param treeNode 二叉树
     * @param num 特定整数
     * @param sum 当前的和
     * @param stack 存放之前路径的栈
     */
    public void getSpecifiedPath(BinaryTreeNodeFor34 treeNode, int num, int sum, Stack<BinaryTreeNodeFor34> stack) {
        stack.push(treeNode);
        sum += treeNode.nValue;
        if (treeNode.left == null && treeNode.right == null && sum == num) {
            //使用foreach对栈进行遍历，方向是从栈底到栈顶
            for (BinaryTreeNodeFor34 aStack : stack)
                System.out.print(aStack.nValue + "-->");
            System.out.println();
        }
        if (treeNode.left != null)
            getSpecifiedPath(treeNode.left, num, sum , stack);
        if (treeNode.right != null)
            getSpecifiedPath(treeNode.right,num,sum,stack);

        stack.pop();
    }

    public static void main(String[] args) {
        BinaryTreeNodeFor34 node1 = new BinaryTreeNodeFor34(10);
        BinaryTreeNodeFor34 node2 = new BinaryTreeNodeFor34(5);
        BinaryTreeNodeFor34 node3 = new BinaryTreeNodeFor34(12);
        BinaryTreeNodeFor34 node4 = new BinaryTreeNodeFor34(4);
        BinaryTreeNodeFor34 node5 = new BinaryTreeNodeFor34(7);

        node1.left=node2;
        node1.right=node3;
        node2.left=node4;
        node2.right=node5;

        InterQuestions34 test = new InterQuestions34();
        test.getSpecifiedPath(node1,22,0,new Stack<>());
    }
}
