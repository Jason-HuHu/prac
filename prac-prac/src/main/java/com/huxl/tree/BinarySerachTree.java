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

    /**
     * 判断是否存在
     * @param x 待确认的节点值
     * @return 返回是否存在
     */
    public boolean contains(T x) {
        return contains(x,root);
    }

    /**
     * 找到树中的最小值
     * @return 最小值
     */
    public T findMin(){
        if (isEmpty()) {
            throw new NullPointerException();
        }

        return findMin(root).element;
    }

    /**
     * 查找最大值
     * @return 最大值
     */
    public T findMax(){
        if (isEmpty()) {
            throw new NullPointerException();
        }
        return findMax(root).element;
    }

    /**
     * 向树中添加元素
     * @param x 待添加的元素
     */
    public void insert(T x) {
        root = insert(x,root);
    }

    /**
     * 从树中移除元素
     * @param x 待移除的元素
     */
    public void remove(T x) {
        root = remove(x,root);
    }

    /**
     * 打印树
     */
    public void printTree(){
        if (isEmpty()) {
            System.out.println("Empty tree");
        }else {
            printTree(root);
        }
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

    /**
     * Internal method to insert into a subtree
     * @param x the item to insert
     * @param root the node that roots the subtree
     * @return the new root of the subtree
     */
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

    /**
     * Internal method to remove from a subtree
     * @param x the item to remove
     * @param root the node that roots the subtree
     * @return the new root of the subtree
     */
    private BinaryNode<T> remove(T x,BinaryNode<T> root) {
        if (root == null) {
            //Item not found;do nothing
            return null;
        }

        int compareResult = x.compareTo(root.element);

        if (compareResult < 0) {
            root.left = remove(x,root.left);
        }else if (compareResult > 0) {
            root.right = remove(x,root.right);
        } else if (root.left != null && root.right !=null) {
            //Two Child
            root.element = findMin(root.right).element;
            root.right =remove(root.element,root.right);
        }else {
            root = (root.left != null) ? root.left : root.right;
        }

        return root;
    }

    /**
     * Internal method to print a subtree in sorted order
     * @param t the node that roots the subtree
     */
    private void printTree(BinaryNode<T> t){
        if (t != null) {
            printTree(t.left);
            System.out.println(t.element);
            printTree(t.right);
        }
    }


}
