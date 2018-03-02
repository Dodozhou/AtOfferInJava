package com.star.interview.day1;

/**
 * 二叉树的节点类
 */
class BinaryTreeNode{
    int m_nValue;
    BinaryTreeNode m_pLeft;
    BinaryTreeNode m_pRight;

    public BinaryTreeNode(int m_nValue, BinaryTreeNode m_pLeft, BinaryTreeNode m_pRight) {
        this.m_nValue = m_nValue;
        this.m_pLeft = m_pLeft;
        this.m_pRight = m_pRight;
    }
}

public class InterQuestions7 {

    /**
     * 重建二叉树的外部接口，主函数
     * @param pre 前序遍历序列
     * @param in 中序遍历序列
     * @return 重构的树
     */
    public static BinaryTreeNode rebuildBinaryTree(int[] pre, int[] in){
        /*int root = pre[0];
        for (int i=0;i<in.length;i++){
            if (in[i] == root)
                break;
        }*/
        if (pre == null || in == null)
            return null;

        return rebuildCore(pre,in,0,pre.length-1,0,in.length-1);
    }


    /**
     * 构建二叉树的核心递归方法
     * @param pre 前序遍历序列
     * @param in 中序遍历序列
     * @param preStart 前序序列起点
     * @param preEnd 前序序列终点
     * @param inStart 中序序列起点
     * @param inEnd 中序序列终点
     * @return 当前树的根节点
     */
    public static BinaryTreeNode rebuildCore(int[] pre, int[] in,
                                             int preStart,int preEnd,
                                             int inStart, int inEnd ){
        int rootValue = pre[preStart];
        BinaryTreeNode tree = new BinaryTreeNode(rootValue,null,null);
        if (preStart == preEnd && inStart == inEnd)
            return tree;
        int root =0;
        //查找根节点在中序遍历中的位置
        for (root=inStart;root<=inEnd;root++){
            if (rootValue == in[root])
                break;
        }
        //左右子树的节点个数
        int leftLength = root-inStart;
        int rightLength = inEnd - root;
        if (leftLength > 0)
            tree.m_pLeft=rebuildCore(pre,in,preStart+1,preStart+leftLength,inStart,root-1);
        if (rightLength > 0)
            tree.m_pRight=rebuildCore(pre,in,preStart+leftLength+1,preEnd,root+1,inEnd);
        return tree;
    }

    /**
     * 二叉树的前序遍历
     */
    public static void preTraversalBinTree(BinaryTreeNode tree){
        if (tree == null)
            return;
        System.out.print(tree.m_nValue+",");
        preTraversalBinTree(tree.m_pLeft);
        preTraversalBinTree(tree.m_pRight);
    }

    /**
     * 二叉树的中序遍历
     */
    public static void inTraversalBinTree(BinaryTreeNode tree){
        if (tree == null)
            return;
        inTraversalBinTree(tree.m_pLeft);
        System.out.print(tree.m_nValue+",");
        inTraversalBinTree(tree.m_pRight);
    }
    /**
     * 二叉树的后序遍历
     */
    public static void postTraversalBinTree(BinaryTreeNode tree){
        if (tree == null)
            return;
        postTraversalBinTree(tree.m_pLeft);
        postTraversalBinTree(tree.m_pRight);
        System.out.print(tree.m_nValue+",");
    }

    /**
     * 主函数，用于测试
     * @param args 参数
     */
    public static void main(String[] args) {
        int[] pre = {1,2,4,7,3,5,6,8};
        int[] in = {4,7,2,1,5,3,8,6};
        BinaryTreeNode tree= rebuildBinaryTree(pre,in);
        System.out.println("先序遍历结果:");
        preTraversalBinTree(tree);
        System.out.println();
        System.out.println("中序遍历结果:");
        inTraversalBinTree(tree);
        System.out.println();
        System.out.println("后序遍历结果:");
        postTraversalBinTree(tree);
    }
}
/*测试结果
先序遍历结果:
1,2,4,7,3,5,6,8,
中序遍历结果:
4,7,2,1,5,3,8,6,
后序遍历结果:
7,4,2,5,8,6,3,1,
Process finished with exit code 0
*/
