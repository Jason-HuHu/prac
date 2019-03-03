package com.huxl.tree;

/**
 * 二叉查找树
 * @param <T>
 */
public class BinarySerachTree<T extends Comparable<? super T>> {

    private static class BinaryNode<T>{
        public BinaryNode() {
        }

        public BinaryNode(T element) {
            this(element,null,null);
        }

        public BinaryNode(T element, BinaryNode<T> left, BinaryNode<T> right) {
            this.element = element;
            this.left = left;
            this.right = right;
        }

        /**
         * The data in the node
         */
        T element;
        /**
         * left child
         */
        BinaryNode<T> left;
        /**
         * Right child
         */
        BinaryNode<T> right;

        public T getElement() {
            return element;
        }


    }

    /**
     * 根节点
     */
    private BinaryNode<T> root;

    public BinarySerachTree(){
        this.root = null;
    }

    /**
     * 置空
     */
    public void makeEmpty(){
        this.root = null;
    }

    /**
     * 判断是否为空
     * @return
     */
    public boolean isEmpty(){
        return root == null;
    }

    public boolean contains(T x) {
        return contains(x,root);
    }

    public T findMin(){
        if (isEmpty()) {
            throw new NullPointerException();
        }

        return findMin(root).element;
    }

    public T findMax(){
        if (isEmpty()) {
            throw new NullPointerException();
        }
        return findMax(root).element;
    }

    public void insert(T x) {
        root = insert(x,root);
    }
    /**
     * Internal method to find an item in a subtree
     * @param x is an item to search for
     * @param root the node that roots the subtree
     * @return node containing the matched item
     */
    private boolean contains(T x, BinaryNode<T> root) {

        if (root == null) {
            return false;
        }
        int compareResult = x.compareTo(root.element);
        if (compareResult < 0) {
            return contains(x,root.left);
        }else if (compareResult > 0) {
            return contains(x,root.right);
        }else {
            //Match
            return true;
        }
    }

    /*
    递归和循环的优缺点
    递归：
        1.代码可读性好，代码简洁
        2.由于递归需要系统堆栈，所以消耗的空间要比非递归要大很多
    循环：
        1.速度快，结构简单
        2.并不能解决所有问题
     */
    /**
     * recursion 递归实现
     * Internal method to find the smallest item in the subtree
     * @param root the node that roots the subtree
     * @return node containing the smallest item
     */
    private BinaryNode<T> findMin(BinaryNode<T> root){
        if (root == null) {
            return null;
        }else if (root.left == null) {
            return root;
        }
        return findMin(root.left);

    }
    /**
     * loop 循环实现
     * Internal method to find the largest item in the subtree
     * @param root the node that roots the subtree
     * @return node containing the largest item
     */
    private BinaryNode<T> findMax(BinaryNode<T> root) {
        if (root != null) {
            while (root.right != null) {
                root = root.right;
            }
        }

        return root;
    }

    private BinaryNode<T> insert(T x,BinaryNode<T> root) {
        if (root == null) {
            return new BinaryNode<>(x,null,null);
        }

        int compareResult = x.compareTo(root.element);

        if (compareResult < 0) {
            root.left = insert(x,root.left);
        }else if (compareResult > 0) {
            root.right = insert(x,root.right);
        }

        return root;
    }
}
