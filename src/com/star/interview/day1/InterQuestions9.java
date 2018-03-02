package com.star.interview.day1;

import java.util.Stack;

/**
 * 两个栈实现一个队列
 */
public class InterQuestions9 {
    private Stack<Integer> stack1 = new Stack<>();
    private Stack<Integer> stack2 = new Stack<>();

    /**
     * 在队列尾部插入一个数
     * @param tail 要插入的数字
     */
    public void appendTail(int tail){
        stack1.push(tail);
    }

    /**
     * 删除队列头部的元素
     * @return 删除的元素
     */
    public  int deleteHead() throws Exception {
        if (stack2.empty()){
            if (stack1.empty())
                throw new Exception("queue is empty.");
            while (!stack1.empty()){
                stack2.push(stack1.pop());
            }
        }
        return stack2.pop();
    }

    public static void main(String[] args) throws Exception {
        InterQuestions9 queue = new InterQuestions9();
        //queue.deleteHead();
        queue.appendTail(1);
        queue.appendTail(2);
        queue.appendTail(3);
        System.out.println(queue.deleteHead());
        queue.appendTail(4);
        System.out.println(queue.deleteHead());
        System.out.println(queue.deleteHead());
        System.out.println(queue.deleteHead());

    }
}
/* 测试结果
1
2
3
4
 */