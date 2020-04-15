package com.huxl.interview;

import java.util.*;

/**
 * Top K 问题，给定一个数组，找出数组中最大/最小的k个数
 */
public class TopKDemo {
    public static void main(String[] args) {
        int[] arr = {8,9,1,211,3,10,4,5,6,7};
        List<Integer> list = new ArrayList<>();

        list.add(13);
        list.add(14);
        list.add(1);
        list.add(2);
        list.add(3);
        PriorityQueue heap = new PriorityQueue(list);
        heap.peek();
        int k = 3;
        System.out.println(Arrays.toString(topKHeap(arr,k)));
        System.out.println(Arrays.toString(topKUp(arr,k)));
    }

    private static int[] topKHeap(int[] arr,int k) {
        if (k <= 0) {
            return new int[0];
        }
        //默认是升序，所以要指定一下comparator成为大顶堆（最大的在堆顶）
        Queue<Integer> heap = new PriorityQueue<>(k,(k1,k2)->Integer.compare(k2,k1));
        for (int i : arr) {
            //当前元素小于堆顶元素才会入堆
            if (heap.isEmpty() || heap.size() < k || i < heap.peek()) {
                heap.offer(i);
            }
            if (heap.size() > k) {
                //删除堆顶最大的元素
                heap.poll();
            }
        }

        int[] topKArr = new int[heap.size()];
        int j = 0;
        //如果要按顺序打印可以采用这种方式
        while (!heap.isEmpty()){
            topKArr[j++] = heap.poll();
        }
        return topKArr;
    }

    private static int[] topKUp(int[] arr,int k) {
        if (k <= 0) {
            return new int[0];
        }
        Queue<Integer> heap = new PriorityQueue<>();
        for (int e : arr) {
            if (heap.isEmpty() || heap.size() < k || e > heap.peek()) {
                heap.offer(e);
            }
            if (heap.size() > k) {
                heap.poll();
            }
        }
        int[]  topKArr = new int[heap.size()];
        int j = 0;
        while (!heap.isEmpty()) {
            topKArr[j++] = heap.poll();
        }
        return topKArr;

    }
}
