package com.huxl.priorityqueue;

/**
 * 二叉堆
 * @author huxl
 * @since 2020/1/10-10:31
 *
 */
public class BinaryHeap<T extends Comparable<? super T>> {

    private static final int DEFAULT_CAPACITY = 10;
    private int currentSize;
    private T[] array;

    public BinaryHeap(){}

    public BinaryHeap(int capacity) {}

    public BinaryHeap(T[] items){
        currentSize = items.length;
        array = (T[])new Comparable[(currentSize+2) * 11/10];
        int i = 1;
        for (T item : items) {
            array[i++] = item;
        }
        buildHeap();
    }

    public void insert(T x){
        if (currentSize == array.length -1) {
            enlargeArray(array.length * 2  + 1);
        }
        //percolate up 上滤
        int hole = ++currentSize;
        for (; (hole > 1) && (x.compareTo(array[hole / 2]) < 0); hole /= 2) {
            array[hole] = array[hole/2];
        }
        array[hole] =x;
    }

    public T findMin(){
        return null;
    }

    public T deleteMin(){
        if (isEmpty()) {
            throw new RuntimeException("队列已经为空");
        }
        T minItem = findMin();
        array[1] = array[currentSize--];
        percolateDown(1);
        return minItem;
    }

    public boolean isEmpty(){
        return true;
    }

    public void makeEmpty(){

    }

    /**
     * Internal method to percolate down in the heap
     * @param hole the index at which the percolate begins.
     */
    private void percolateDown(int hole) {
        int child;
        T tmp = array[hole];
        for (; hole * 2 <= currentSize;hole = child) {
            child = hole * 2;
            if (child != currentSize && array[child +1].compareTo(array[child]) < 0) {
                child++;
            }
            if (array[child].compareTo(tmp) < 0) {
                array[hole] = array[child];
            }else {
                break;
            }
        }
        array[hole] = tmp;
    }

    private void buildHeap(){
        for (int i = currentSize/2; i >0; i--) {
            percolateDown(i);
        }
    }

    private void enlargeArray(int newSize){

    }
}
