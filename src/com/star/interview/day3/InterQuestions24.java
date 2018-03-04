package com.star.interview.day3;

public class InterQuestions24 {
    /**
     * 逆序的接口方法
     * @param head 链表头节点
     * @return 逆序后的头节点
     */
    public static ListNode reverseLinkList(ListNode head){
        if (head == null)
            return null;
        ListNode pre = null,cur = head,next = cur.nextNode;
        if (next == null)
            return head;
        return reverseCore(pre,cur,next);
    }

    /**
     * 逆序的核心递归方法
     * @param pre 当前已经逆序的最后一个节点
     * @param cur 当前没有逆序的第一个节点
     * @param next 当前没有逆序的第二个节点
     * @return 已经逆序的链表的头节点
     */
    public static ListNode reverseCore(ListNode pre,ListNode cur,ListNode next){
        cur.nextNode = pre;
        if (next == null)
            return cur;
        return reverseCore(cur,next,next.nextNode);
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


        System.out.println("逆序之前：");
        ListNode pre = root;
        while (pre != null){
            System.out.print(pre.nodeValue+",");
            pre = pre.nextNode;
        }

        System.out.println();
        System.out.println("逆序之后：");
        ListNode reverse = reverseLinkList(root);
        while (reverse != null){
            System.out.print(reverse.nodeValue+",");
            reverse = reverse.nextNode;
        }
    }
    /* 测试结果
    逆序之前：
    1,2,3,4,5,6,
    逆序之后：
    6,5,4,3,2,1,
     */
}
