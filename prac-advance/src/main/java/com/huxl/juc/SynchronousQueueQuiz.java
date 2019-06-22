package com.huxl.juc;

import java.util.concurrent.*;

/**
 * 判断下列程序的执行结果（桃谷）
 * false false false 阻塞
 * @author huxl
 * @since 2019/6/22 11:12
 */
public class SynchronousQueueQuiz {

    public static void main(String[] args) throws InterruptedException {
        BlockingQueue<Integer> queue = new SynchronousQueue<>();
        System.out.print(queue.offer(1) + " ");
        System.out.print(queue.offer(2) + " ");
        System.out.print(queue.offer(3) + " ");
        System.out.print(queue.take());
        System.out.println(queue.size());
    }

    private static void analize(){
        ExecutorService executorService = Executors.newCachedThreadPool();
    }
}
