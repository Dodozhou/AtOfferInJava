package com.star.interview.day4;

import java.util.Queue;
import java.util.concurrent.LinkedBlockingDeque;

/**
 * 按层打印二叉树
 */
public class InterQuestions32 {
    /**
     * 使用队列按层打印二叉树
     * @param tree 二叉树
     */
    public void printBinaryNodeTreeByLevel(BinaryTreeNode tree){
        Queue<BinaryTreeNode> queue = new LinkedBlockingDeque<>();
        if (tree == null)
            return;
        System.out.print(tree.nValue+" ");
        if (tree.left != null)
            queue.add(tree.left);
        if (tree.right != null)
            queue.add(tree.right);

        BinaryTreeNode head;
        while (queue.size()>0){
             head=queue.poll();
            System.out.print(head.nValue+" ");
            if (head.left != null)
                queue.add(head.left);
            if (head.right != null)
                queue.add(head.right);
        }
    }

    public static void main(String[] args) {
        BinaryTreeNode node1 = new BinaryTreeNode(8);
        BinaryTreeNode node2 = new BinaryTreeNode(6);
        BinaryTreeNode node3 = new BinaryTreeNode(10);
        BinaryTreeNode node4 = new BinaryTreeNode(5);
        BinaryTreeNode node5 = new BinaryTreeNode(7);
        BinaryTreeNode node6 = new BinaryTreeNode(9);
        BinaryTreeNode node7 = new BinaryTreeNode(11);

        node1.left=node2;
        node1.right = node3;
        node2.left=node4;
        node2.right=node5;
        node3.left = node6;
        node3.right = node7;

        /*//只有左子树
        node1.left = node2;
        node2.left = node4;*/

        InterQuestions32 test = new InterQuestions32();
        test.printBinaryNodeTreeByLevel(node1);
    }

}
