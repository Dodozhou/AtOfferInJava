package com.star.interview.day5;

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
 * 序列化和反序列化一颗二叉树
 */
public class InterQuestions37 {
    //一个全局的计数变量
    private static int index=0;

    /**
     * 序列化方法
     * @param treeNode 要序列化的二叉树根节点
     * @param ser 一个空字符串，用于存放序列
     * @return 序列化后的字符串
     */
    public String serialize(BinaryTreeNode treeNode,String ser){
        if (treeNode == null)
            return ser;
        ser += treeNode.nValue;
        ser += ",";

        if (treeNode.left!=null)
             ser=serialize(treeNode.left,ser);
        else
            ser+="$,";
        if (treeNode.right!=null)
            ser=serialize(treeNode.right,ser);
        else
            ser+="$,";
        return ser;
    }

    /**
     * 反序列化方法
     * @param ser 序列通过“，”分割后形成的字符串数组
     * @return 发序列化后的根节点
     */
    public BinaryTreeNode deSerialize(String[] ser){
        if (ser == null || index >= ser.length)
            return null;
        String sNum = ser[index];
        BinaryTreeNode treeNode =null;
        if (!sNum.equals("$")){
            treeNode = new BinaryTreeNode(Integer.parseInt(sNum));
            index++;
            treeNode.left = deSerialize(ser);
            index++;
            treeNode.right =deSerialize(ser);
        }
        return treeNode;
    }


    public static void main(String[] args) {
        InterQuestions37 test = new InterQuestions37();
        BinaryTreeNode node1 = new BinaryTreeNode(10);
        BinaryTreeNode node2 = new BinaryTreeNode(5);
        BinaryTreeNode node3 = new BinaryTreeNode(12);
        BinaryTreeNode node4 = new BinaryTreeNode(4);
        BinaryTreeNode node5 = new BinaryTreeNode(7);

        node1.left=node2;
        node1.right=node3;
        node2.left=node4;
        node2.right=node5;
        String ser=test.serialize(node1,"");

        BinaryTreeNode tree =test.deSerialize(ser.split(","));
        printBinaryNodeTree(tree);
    }

    private static void printBinaryNodeTree(BinaryTreeNode tree) {
        if (tree == null)
            return;
        System.out.print(tree.nValue+",");
        printBinaryNodeTree(tree.left);
        printBinaryNodeTree(tree.right);
    }
}
