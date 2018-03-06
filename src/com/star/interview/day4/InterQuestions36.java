package com.star.interview.day4;

import com.sun.org.apache.bcel.internal.generic.BIPUSH;

public class InterQuestions36 {
    static class BinaryTreeNode{
        int nValue;
        BinaryTreeNode left;
        BinaryTreeNode right;

        public BinaryTreeNode(int nValue) {
            this.nValue = nValue;
        }
    }

    /**
     * 主方法，负责递归方法ConvertNode的调用
     * @param rootOfTree 二叉搜索树的根
     * @return 双向链表的最小值节点
     */
    public BinaryTreeNode convert(BinaryTreeNode rootOfTree){
        BinaryTreeNode lastNodeInList = null;
        lastNodeInList= ConvertNode(rootOfTree, null);

        BinaryTreeNode headOfList = lastNodeInList;
        while (headOfList != null && headOfList.left != null)
            headOfList = headOfList.left;

        return headOfList;

    }

    /**
     * 转换的核心方法，递归地改变链的指向
     * @param node 当前树的根节点
     * @param lastNodeInList 左链的最小节点
     * @return 当前链的最大节点
     */
    private BinaryTreeNode ConvertNode(BinaryTreeNode node, BinaryTreeNode lastNodeInList) {
        if (node == null)
        return null;

        if (node.left != null){
            lastNodeInList=ConvertNode(node.left,lastNodeInList);
        }

        node.left = lastNodeInList;
        if (lastNodeInList!=null)
            lastNodeInList.right = node;
        lastNodeInList = node;

        if (node.right != null)
            lastNodeInList = ConvertNode(node.right,lastNodeInList);
        return lastNodeInList;
    }

    public static void main(String[] args) {
        BinaryTreeNode node1 = new BinaryTreeNode(10);
        BinaryTreeNode node2 = new BinaryTreeNode(5);
        BinaryTreeNode node3 = new BinaryTreeNode(12);
        BinaryTreeNode node4 = new BinaryTreeNode(4);
        BinaryTreeNode node5 = new BinaryTreeNode(7);

        node1.left=node2;
        node1.right=node3;
        node2.left=node4;
        node2.right=node5;

        InterQuestions36 test =new InterQuestions36();
        BinaryTreeNode list= test.convert(node1);
        while (list!=null){
            System.out.print(list.nValue +",");
            list = list.right;
        }
    }
    /*测试结果
    4,5,7,10,12,
     */

}
