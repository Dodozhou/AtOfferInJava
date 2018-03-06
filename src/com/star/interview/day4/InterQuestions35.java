package com.star.interview.day4;
class ComplexListNode{
    int nValue;
    ComplexListNode nextNode;
    ComplexListNode siblingNode;
}
public class InterQuestions35 {
    /**
     * 主方法，负责方法调用和参数校验
     * @param head 复杂链表的头节点
     * @return 复制链表
     */
    public ComplexListNode clone(ComplexListNode head){
        if (head == null)
            return null;
        cloneNodes(head);// 复制原节点
        connectSiblings(head); //连接兄弟节点
        return reConnectNodes(head); //拆分并返回复制的复杂链表
    }

    /**
     * 克隆节点，并将节点连接到原节点之后
     * @param head 原链表的头节点
     */
    private void cloneNodes(ComplexListNode head){
        ComplexListNode current = head;
        while (current!=null){
            ComplexListNode cloneNode = new ComplexListNode();
            cloneNode.nValue = current.nValue;
            cloneNode.nextNode = current.nextNode;

            cloneNode.nextNode = current.nextNode;
            current.nextNode = cloneNode;

            current = cloneNode.nextNode;
        }
    }

    /**
     * 复制兄弟链
     * @param head 未复制兄弟链的链表
     */
    private void connectSiblings(ComplexListNode head) {
        ComplexListNode current = head;
        while (current != null){
            ComplexListNode cloneNodeOfCurrent = current.nextNode;
            //连接克隆节点的兄弟节点
            if (current.siblingNode !=null )
            cloneNodeOfCurrent.siblingNode = current.siblingNode.nextNode;
            current = cloneNodeOfCurrent.nextNode;
        }
    }

    /**
     * 拆分两个链表的方法
     * @param head 复制后，但连在一起的链表头节点
     * @return 复制的链表
     */
    private ComplexListNode reConnectNodes(ComplexListNode head) {
        ComplexListNode node = head;
        ComplexListNode cloneHead = null;
        ComplexListNode cloneNode = null;

        if (node != null){
            cloneHead=cloneNode=node.nextNode;
            node.nextNode=cloneNode.nextNode;
            node=node.nextNode;
        }

        while (node != null){
            cloneNode.nextNode=node.nextNode;
            cloneNode = cloneNode.nextNode;
            node.nextNode = cloneNode.nextNode;
            node = node.nextNode;
        }
        return cloneHead;
    }

    public static void main(String[] args) {
        InterQuestions35 test = new InterQuestions35();

        ComplexListNode node1 = new ComplexListNode();
        node1.nValue = 1;
        ComplexListNode node2 = new ComplexListNode();
        node2.nValue = 2;
        ComplexListNode node3 = new ComplexListNode();
        node3.nValue = 3;
        ComplexListNode node4 = new ComplexListNode();
        node4.nValue = 4;
        ComplexListNode node5 = new ComplexListNode();
        node5.nValue = 5;

        node1.nextNode = node2;
        node1.siblingNode = node3;
        node2.nextNode = node3;
        node2.siblingNode = node5;
        node3.nextNode = node4;
        node3.siblingNode = null;
        node4.nextNode = node5;
        node4.siblingNode = node2;

        ComplexListNode clone = test.clone(node1);
        while (clone!=null){
            System.out.print("node:"+clone.nValue);
            if (clone.nextNode!=null)
                System.out.print("next:"+clone.nextNode.nValue);
            if (clone.siblingNode!=null)
                System.out.print(":sibling"+clone.siblingNode.nValue);
            clone = clone.nextNode;
            System.out.println();
        }
    }
    /* 测试结果
    node:1next:2:sibling3
    node:2next:3:sibling5
    node:3next:4
    node:4next:5:sibling2
    node:5
     */
}
