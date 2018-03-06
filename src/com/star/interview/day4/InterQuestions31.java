package com.star.interview.day4;

import com.star.interview.day1.InterQuestions3;

import java.util.Stack;

/**
 * 栈的压入、弹出序列
 */
public class InterQuestions31<AnyType extends Comparable<? super AnyType>> {
    public  boolean  isOutSeqOfStack(AnyType[] in,AnyType[] out) {
        if (in.length != out.length)
            return false;

        Stack<AnyType> assistStack = new Stack<>();
        int inIndex = 0, outIndex = 0;
        int length = in.length;
        while (in[inIndex].compareTo(out[outIndex]) == 0) {
            inIndex++;
            outIndex++;
            if (inIndex == length)
                return true;
        }
        assistStack.push(in[inIndex++]);
        assistStack.push(in[inIndex++]);

        while (true) {
            if (outIndex == length)
                return true;
            if (assistStack.isEmpty()){
                if (inIndex >length-1)
                    return false;
                else
                    assistStack.push(in[inIndex++]);
            }
            if (assistStack.peek().compareTo(out[outIndex]) == 0) {
                assistStack.pop();
                outIndex++;
            }else {
                assistStack.push(in[inIndex++]);
            }
        }
    }

    public static void main(String[] args) {
        Integer[] in={1,2,3};
        Integer[] out1={3,1,2};
        Integer[] out2={1,2,3};
        Integer[] out3={1,3,2};
        Integer[] out4={2,3,1};
        Integer[] out5={2,1,3};
        Integer[] out6={3,2,1};

        InterQuestions31<Integer> test = new InterQuestions31<>();

        System.out.println(test.isOutSeqOfStack(in,out1));
        //System.out.println(test.isOutSeqOfStack(in,out2));
    }
}
