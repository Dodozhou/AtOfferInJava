package com.star.interview.day5;

import java.util.Comparator;
import java.util.PriorityQueue;

public class InterQuestions41 {
    private int count = 0;
    private PriorityQueue<Integer> minHeap = new PriorityQueue<>();
    private PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(15, new Comparator<Integer>() {
        @Override
        public int compare(Integer o1, Integer o2) {
            return o2 - o1;
        }
    });

    //读入字符，放到合适位置
    public void Insert(Integer num) {
        if (num == null)
            return;
        if (count %2 == 0) {
            maxHeap.offer(num);
            int filteredMaxNum = maxHeap.poll();//平衡两个堆，将右边小顶堆的最小元素交给左边的大顶堆
            minHeap.offer(filteredMaxNum);
        } else {
            minHeap.offer(num);
            int filteredMinNum = minHeap.poll();
            maxHeap.offer(filteredMinNum);
        }
        count++;
    }

    //求中位数
    public Double GetMedian() {
        if (count %2 == 0) {
            return (double) (minHeap.peek() + maxHeap.peek()) / 2;
        } else {
            return new Double(minHeap.peek());
        }
    }

    public static void main(String[] args) {
        InterQuestions41 test = new InterQuestions41();
        int[] a={5,3,4,8,9,2,3,1};
        //int[] b={4};
        for (int i=0;i<a.length;i++)
            test.Insert(a[i]);
        System.out.println(test.GetMedian());
       /* test.Insert(b[0]);
        System.out.println(test.GetMedian());*/
    }
}
