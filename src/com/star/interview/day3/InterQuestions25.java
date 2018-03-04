package com.star.interview.day3;

public class InterQuestions25 {
    /**
     * 递归地合并两个链表
     * @param list1 链表1
     * @param list2 链表2
     * @return 合并后的链表
     */
    public static ListNode mergeList(ListNode list1,ListNode list2) {
        if (list1 == null)
            return list2;
        if (list2 == null)
            return list1;

        ListNode mergeHead = null;

        if (list1.nodeValue < list2.nodeValue) {
            mergeHead = list1;
            mergeHead.nextNode = mergeList(list1.nextNode, list2);
        } else {
            mergeHead = list2;
            mergeHead.nextNode = mergeList(list1,list2.nextNode);
        }

        return mergeHead;
    }

    public static void main(String[] args) {
        ListNode node0 = new ListNode(0);
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        ListNode node6 = new ListNode(4);

        node0.nextNode = node2;
        node2.nextNode = node4;
        node4.nextNode = node6;

        node1.nextNode = node3;
        node3.nextNode = node5;

        ListNode merge = mergeList(node0,node1);
        while (merge != null){
            System.out.print(merge.nodeValue+",");
            merge = merge.nextNode;
        }
    }


}
