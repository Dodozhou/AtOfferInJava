package com.star.interview.day1;

public class InterQuestions8 {
    static class BinaryTreeNode{
        String value;
        BinaryTreeNode left;
        BinaryTreeNode right;
        BinaryTreeNode parent;

        public BinaryTreeNode(String value, BinaryTreeNode left, BinaryTreeNode right, BinaryTreeNode parent) {
            this.value = value;
            this.left = left;
            this.right = right;
            this.parent = parent;
        }
    }

    /**
     * 获取下一个节点的核心方法
     * @param treeNode 当前节点
     * @return 下一个节点或者null
     */
    public static BinaryTreeNode getNext(BinaryTreeNode treeNode){
        if (treeNode == null)
            return null;

        BinaryTreeNode nextNode = null;
        if (treeNode.right != null){
            BinaryTreeNode rNode = treeNode.right;
            while (rNode.left != null){
                rNode = rNode.left;
            }
            nextNode = rNode;
        }else if (treeNode.parent != null){
            BinaryTreeNode current = treeNode;
            BinaryTreeNode parent = treeNode.parent;
            while (parent != null && current == parent.right){
                current = parent;
                parent = current.parent;
            }
            nextNode = parent;
        }
        return nextNode;
    }

    /**
     * main方法用于测试
     * @param args 参数
     */
    public static void main(String[] args) {
        //构造一个二叉树用于测试
        BinaryTreeNode root = new BinaryTreeNode("a",null,null,null);
        root.left = new BinaryTreeNode("b",null,null,root);
        root.right = new BinaryTreeNode("c",null,null,root);
        root.left.left = new BinaryTreeNode("d",null,null,root.left);
        root.left.right = new BinaryTreeNode("e",null,null,root.left);

        BinaryTreeNode node = getNext(root.left);
        //BinaryTreeNode node = getNext(root.left.right);
        //BinaryTreeNode node = getNext(root.right);
        if (node == null)
            System.out.println("该节点是中序遍历的最后一个节点");
        else
        System.out.println("该节点的下一个节点是："+node.value);
    }
}
