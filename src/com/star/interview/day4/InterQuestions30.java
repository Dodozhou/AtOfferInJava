package com.star.interview.day4;


import java.util.Stack;

/**
 * 包含min函数的栈
 */
public  class InterQuestions30<AnyType extends Comparable<? super AnyType>> {
    private Stack<AnyType> stack = new Stack<>();
    private Stack<AnyType> assistStack = new Stack<>();

    public void push(AnyType data){
        if (stack.isEmpty() || data.compareTo(assistStack.peek())<0) {
            stack.push(data);
            assistStack.push(data);
        } else {
            stack.push(data);
            assistStack.push(assistStack.peek());
        }
    }

    public AnyType pop(){
        if (!stack.empty()) {
            assistStack.pop();
            return stack.pop();
        }
        return null;
    }

    public AnyType min(){
        return assistStack.peek();
    }

    public static void main(String[] args) {
        InterQuestions30<Integer> myStack = new InterQuestions30<>();
        myStack.push(3);
        myStack.push(4);
        myStack.push(2);
        myStack.push(1);
        System.out.println(myStack.pop());
        System.out.println(myStack.pop());
        myStack.push(0);
    }

}
