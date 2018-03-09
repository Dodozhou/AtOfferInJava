package com.star.interview.day6;
class BinaryTreeNode{
    int nValue;
    BinaryTreeNode left;
    BinaryTreeNode right;

    public BinaryTreeNode(int nValue) {
        this.nValue = nValue;
    }
    public BinaryTreeNode() {}
}
/**
 * 二叉搜索树的第k大节点
 */
public class InterQuestions54 {
    //全局变量，用来记录已经遍历过的节点的数目
    private static int k = 0;

    /**
     * 查找二叉搜索树的第k大节点的主方法，负责递归调用
     * @param treeNode 二叉搜索树的根节点
     * @param kth 表示k的数字
     * @return 第k大的节点
     */
    public BinaryTreeNode kthNode(BinaryTreeNode treeNode,int kth){
        if (treeNode == null || kth<1)
            return null;
        k = kth;
        return kthNodeCore(treeNode);
    }

    /**
     * 查找k个节点的核心递归方法
     * @param treeNode 树节点
     * @return null或者第k大的节点
     */
    private BinaryTreeNode kthNodeCore(BinaryTreeNode treeNode){
        BinaryTreeNode target = null;

        if (treeNode.left != null)
            target= kthNodeCore(treeNode.left);

        if (target == null){
            if (k==1)
                target = treeNode;
            k--;
        }

        if (target == null && treeNode.right!=null)
            target = kthNodeCore(treeNode.right);

        return target;
    }

    public static void main(String[] args) {
        InterQuestions54 test = new InterQuestions54();
        BinaryTreeNode node1 = new BinaryTreeNode(5);
        BinaryTreeNode node2 = new BinaryTreeNode(3);
        BinaryTreeNode node3 = new BinaryTreeNode(2);
        BinaryTreeNode node4 = new BinaryTreeNode(4);
        BinaryTreeNode node5 = new BinaryTreeNode(6);
        BinaryTreeNode node6 = new BinaryTreeNode(7);

        node1.left = node2;
        node1.right = node5;
        node2.left = node3;
        node2.right = node4;
        node5.right = node6;

        System.out.println(test.kthNode(node1,4).nValue);
    }
}
