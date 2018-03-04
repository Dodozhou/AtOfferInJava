package com.star.interview.day3;

import java.util.List;

/**
 * 链表中环的入口
 */
public class InterQuestions23 {
    public static ListNode EntryNodeOfLoop(ListNode head){
        ListNode mettingNode = mettingNode(head);
        if (mettingNode == null)
            return null;

        int i = 1;
        ListNode next = mettingNode.nextNode;
        while (mettingNode != next){
            next = next.nextNode;
            i++;
        }

        ListNode one = head,two = head;
        for (int j=0;j<i;j++ ){
            one = one.nextNode;
        }
        while (one != two){
            one = one.nextNode;
            two = two.nextNode;
        }
        return one;
    }

    private static ListNode mettingNode(ListNode head) {
        ListNode slow = head.nextNode;
        if (slow == null)
            return null;
        ListNode fast = slow.nextNode;
        while (fast != null){
           if (slow == fast)
               return fast;
           slow = slow.nextNode;
           fast = fast.nextNode;
           if (fast != null)
               fast = fast.nextNode;
        }
        return null;
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
        node5.nextNode = node3;

        System.out.println(mettingNode(root).nodeValue);
        System.out.println(EntryNodeOfLoop(root).nodeValue);
    }
}
