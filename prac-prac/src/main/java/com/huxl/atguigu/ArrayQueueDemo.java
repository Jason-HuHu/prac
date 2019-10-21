package com.huxl.atguigu;

import java.util.Arrays;

/**
 * 数组实现队列(该种实现有缺陷，不能重复使用)
 * @see CircleArrayQueue
 * @author huxl
 */
public class ArrayQueueDemo {
    public static void main(String[] args) {
        Queue queue = new Queue(10);
        queue.add(1);
        queue.add(2);
        queue.add(3);
        queue.add(4);

        System.out.println(queue.get());
        System.out.println("头" + queue.head());
        System.out.println(queue.get());
        System.out.println("头" + queue.head());
        System.out.println(queue.get());
        System.out.println("头" + queue.head());
        System.out.println(queue.get());
        System.out.println(queue.toString());
        queue.add(1);
        queue.add(2);
        queue.add(3);
        queue.add(4);
        queue.add(5);
        queue.add(6);
        queue.add(7);
        queue.add(8);
        queue.add(9);
        queue.add(10);
        System.out.println(queue.toString());
        queue.get();
        queue.get();
        System.out.println(queue.toString());
    }

}

class Queue{
    /**
     * 最大长度
     */
    private int maxSize;
    /**
     * 队列头部索引
     */
    private int front;
    /**
     * 队列尾部索引
     */
    private int rear;
    /**
     * 存放数据的数组
     */
    private int[] arr;

    public Queue(int maxSize){
        this.maxSize = maxSize;
        this.arr = new int[maxSize];
        this.front = -1;
        this.rear = -1;
    }

    public void add(int arg){
        if (isFull()) {
            System.out.println("队列已满");
            return;
        }
        this.front ++;
        this.arr[front] = arg;
    }

    public int get(){
        if (isEmpty()) {
            System.out.println("队列中无元素");
            return 0;
        }

        rear++;
        int val = arr[rear];
        arr[rear] = 0;
        return val;
    }
    public int head(){
        return arr[front];
    }
    private boolean isEmpty(){
        return front == rear;
    }

    private boolean isFull(){
        return front == maxSize -1;
    }

    @Override
    public String toString() {
        return Arrays.toString(arr);
    }
}
