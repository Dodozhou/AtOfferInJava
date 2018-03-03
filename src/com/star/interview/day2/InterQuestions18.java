package com.star.interview.day2;

import java.util.List;

/**
 * 删除链表的下一个节点
 */
public class InterQuestions18 {
    public static void deleteNode(ListNode head,ListNode nodeTobeDeleted){
        if (head == null || nodeTobeDeleted == null)
            return;

        if (nodeTobeDeleted.nextNode == null) {//要删除的节点是尾节点
            if (head.nextNode == null) {
                head = null;
                return;
            }
            deleteTail(head, nodeTobeDeleted);
        }
        else{
            nodeTobeDeleted.nodeValue = nodeTobeDeleted.nextNode.nodeValue;
            nodeTobeDeleted.nextNode = nodeTobeDeleted.nextNode.nextNode;
        }
    }

    private static void deleteTail(ListNode head, ListNode nodeTobeDeleted) {
        ListNode current = head;
        while (current != null){
            if (current.nextNode == nodeTobeDeleted)
                current.nextNode = nodeTobeDeleted.nextNode;
            current = current.nextNode;
        }
    }

    public static void main(String[] args) {
        ListNode root = new ListNode(0);
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);

        root.nextNode=node1;
        node1.nextNode=node2;
        node2.nextNode=node3;

        printListNode(root);
        deleteNode(root,node1);
        printListNode(root);
        deleteNode(root,root);
        printListNode(root);
        deleteNode(root,node3);
        printListNode(root);
    }

    /**
     * 打印链表的函数，方便测试效果
     * @param root  链表头节点
      */
    public static void printListNode(ListNode root){
        ListNode current = root;
        while (current!=null){
            System.out.print(current.nodeValue+",");
            current = current.nextNode;
        }
        System.out.println();
    }

}



/**
 * 链表节点类
 */
class ListNode{
    int nodeValue;
    ListNode nextNode;

    public ListNode(int nodeValue) {
        this.nodeValue = nodeValue;
    }
}