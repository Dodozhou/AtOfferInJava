package com.star.interview.day6;
class ListNode{
    int nValue;
    ListNode nextNode;

    public ListNode(int nValue) {
        this.nValue = nValue;
    }
}
/**
 * 两个链表的第一个公共节点
 */
public class InterQuestions52 {
    /**
     * 求两个链表的第一个公共节点
     * @param list1 链表1的头节点
     * @param list2 链表2的头节点
     * @return 第一个公共节点或者null（不存在公共节点）
     */
    public ListNode findFirstCommonNode(ListNode list1,ListNode list2){
        int nodesNumOfList1 = 0,nodesNumOfList2 = 0;
        ListNode temp = list1;
        while (temp != null){ //遍历list1，得到list1的节点个数
            nodesNumOfList1++;
            temp = temp.nextNode;
        }
        temp = list2;
        while (temp != null){ //遍历list2，得到list2的节点个数
            nodesNumOfList2++;
            temp = temp.nextNode;
        }
        if (nodesNumOfList1 == 0 ||nodesNumOfList2 == 0) //如果两个节点之一或者全部没有元素，返回null
            return null;
        if (nodesNumOfList2>nodesNumOfList1){  //将较长的链表设为list1
            temp = list1;
            list1 = list2;
            list2 = temp;
        }
        for (int i=0;i<nodesNumOfList1-nodesNumOfList2;i++){ //较长的链表先走n步，n等于节点数目只差
            list1 = list1.nextNode;
        }

        while (list1!=list2){  //两个节点同时向后移动，直到遇到公共节点
            list1 = list1.nextNode;
            list2 = list2.nextNode;
        }
        return list1;
    }

    public static void main(String[] args) {
        InterQuestions52 test = new InterQuestions52();
        ListNode head1 = new ListNode(1);
        ListNode node12 = new ListNode(2);
        ListNode node13 = new ListNode(3);
        ListNode node14 = new ListNode(6);
        ListNode node15 = new ListNode(7);

        ListNode head2 = new ListNode(4);
        ListNode node22 = new ListNode(5);

        head1.nextNode = node12;
        node12.nextNode = node13;
        node13.nextNode = node14;
        node14.nextNode = node15;

        head2.nextNode = node22;
        node22.nextNode = node14;

        System.out.println(test.findFirstCommonNode(head1,head2).nValue);
    }




}
