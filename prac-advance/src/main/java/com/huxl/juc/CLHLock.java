package com.huxl.juc;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

public class CLHLock {
    /**
     * 定义一个结点，默认状态是lock
     */
    public static class CLHNode{
        private volatile boolean isLocked = true;
    }
    /**
     * 尾部结点
     */
    private volatile CLHNode tail;

    private static final ThreadLocal<CLHNode> LOCAL = new ThreadLocal<>();

    private static final AtomicReferenceFieldUpdater<CLHLock,CLHNode> UPDATER = AtomicReferenceFieldUpdater
            .newUpdater(CLHLock.class,CLHNode.class,"tail");

    public void lock(){
        //新建结点并将当前线程保存起来
        CLHNode node = new CLHNode();
        LOCAL.set(node);
        //将新建的结点设置为尾部结点，并返回旧的结点，这里旧的结点就相当于当前结点的前驱结点
        CLHNode preNode = UPDATER.getAndSet(this,node);
        if (preNode != null) {
            //前驱结点不为null，表示当前锁被其他线程占有，通过不断轮询判断前驱结点的锁标识位等待前驱结点释放锁
            while (preNode.isLocked) {
            }
            preNode = null;
            LOCAL.set(node);
        }
        //如果不存在前驱结点，则表示该锁没有被其他线程占有，当前线程获取到锁
    }

    public void unlock(){
        //获取当前线程对应的结点
        CLHNode node = LOCAL.get();
        //如果tail结点等于node，则将tail结点更新为null，同时将node的lock标识位置位false，表示当前线程释放了锁
        if (!UPDATER.compareAndSet(this,node,null)){
            node.isLocked = false;
        }
        node = null;
    }
}
