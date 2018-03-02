package com.star.interview.day1;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * 输入一个链表的头节点，从尾到头反过来打印出每个节点的值。链表节点定义如下:
 */
public class InterQuestions6 {
    /**
     * 链表节点内
     */
    static class ListNode{
        int m_nKey;
        ListNode m_pNext;
    }

    /**
     * 逆序输出链表方式一：使用java的栈
     * @param list 需要逆序输出的链表
     */
    public static  void reverseListWithStack(ListNode list){
        if (list == null)
            return;

        Stack<ListNode> stack = new Stack<>();
        while (list != null){
            stack.push(list);
            list = list.m_pNext;
        }
        while (!stack.empty()){
            System.out.println(stack.pop().m_nKey+"  ");
        }
    }

    /**
     * 逆序输出链表方式二：使用递归.
     * 该方式虽然更加简洁，但是如果链表过长，那么可能会导致调用栈溢出。该方式的鲁棒性不如方式一。
     * @param list 链表
     */
    public static void reverseListWithRecursion(ListNode list){
        if (list == null)
            return;

        if (list.m_pNext != null)
            reverseListWithRecursion(list.m_pNext);
            System.out.print(list.m_nKey+"  ");
    }

    public static void main(String[] args) {
        ListNode list = new ListNode();
        list.m_nKey = 0;
        for (int i=7;i>0;i--){
            ListNode newNode = new ListNode();
            newNode.m_nKey = i;
            newNode.m_pNext = list.m_pNext;
            list.m_pNext = newNode;
        }

        reverseListWithStack(list);
        reverseListWithRecursion(list);
    }

}
