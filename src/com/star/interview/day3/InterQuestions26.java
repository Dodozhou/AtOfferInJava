package com.star.interview.day3;

class BinaryTreeNode{
    double nValue;
    BinaryTreeNode left;
    BinaryTreeNode right;

    public BinaryTreeNode(double nValue) {
        this.nValue = nValue;
    }
}

public class InterQuestions26 {
    /**
     * 判断树A是否包含树B
     * @param A 树A
     * @param B 树B
     * @return 是否包含
     */
    public static boolean hasSubtree(BinaryTreeNode A,BinaryTreeNode B){
        boolean result =false;

        if (A != null && B != null){
            if (isEqual(A.nValue,B.nValue))
                result = doesTree1HasTree2(A,B);
            if (!result)
                result = hasSubtree(A.left,B);
            if (!result)
                result = hasSubtree(A.right,B);
        }
        return result;
    }

    /**
     * 在根节点相同的情况下，判断tree1是否包含tree2
     * @param tree1 树1
     * @param tree2 树2
     * @return 是否包含
     */
    private static boolean doesTree1HasTree2(BinaryTreeNode tree1, BinaryTreeNode tree2) {
        if (tree2 == null)
            return true;
        if (tree1 == null)
            return false;

        if (!isEqual(tree1.nValue,tree2.nValue))
            return false;
        return doesTree1HasTree2(tree1.left,tree2.left) && doesTree1HasTree2(tree1.right,tree2.right);
    }

    /**
     * 由于只需要判断是否想到能，不需要判断大小，所以将double转为String，
     * 再使用equals进行比较
     * @param a 数字1
     * @param b 数字2
     * @return 是否相等
     */
    private static boolean isEqual(double a, double b) {
        return String.valueOf(a).equals(String.valueOf(b));
    }

    public static void main(String[] args) {
        BinaryTreeNode tree1 = new BinaryTreeNode(0.501);
        BinaryTreeNode node1 = new BinaryTreeNode(1.501);
        BinaryTreeNode node2 = new BinaryTreeNode(2.501);
        tree1.left=node1;
        tree1.right = node2;

        BinaryTreeNode tree2 = new BinaryTreeNode(0.501);
        BinaryTreeNode node3 = new BinaryTreeNode(1.501);
        BinaryTreeNode node4 = new BinaryTreeNode(2.501);
        tree2.left=node3;
        //tree2.right=node4;

        System.out.println(hasSubtree(tree1,tree2));
    }
}
