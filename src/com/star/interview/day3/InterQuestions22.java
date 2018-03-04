package com.star.interview.day3;

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
/**
 * 链表中倒数第k个节点
 */
public class InterQuestions22 {
    public static ListNode lastButNth(ListNode head,int k){
        if (head == null || k==0)
            return null;
        ListNode one=head,two = head;
        for (int i=0;i<k-1;i++)
            if (two.nextNode != null)
            two = two.nextNode;
        else
            return null;

        while (two.nextNode != null){
            two = two.nextNode;
            one = one.nextNode;
        }
        return one;
    }

    public static void main(String[] args) {
        ListNode root = new ListNode(1);
        ListNode node1 = new ListNode(2);
        ListNode node2 = new ListNode(3);
        ListNode node3 = new ListNode(4);
        ListNode node4 = new ListNode(5);
        ListNode node5 = new ListNode(6);

        root.nextNode = node1;
        node1.nextNode = node2;
        node2.nextNode = node3;
        node3.nextNode = node4;
        node4.nextNode = node5;

        System.out.println(lastButNth(node5,3).nodeValue);
    }
}
