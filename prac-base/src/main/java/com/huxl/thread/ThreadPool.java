package com.huxl.thread;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @author huxl
 * @createDate 2018/1/25 17:27
 */
public class ThreadPool {
    private static Logger logger = LoggerFactory.getLogger(ThreadPool.class);

    public static void main(String[] args) {
        logger.info("main");
//        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(10,20,200,
//                TimeUnit.MINUTES,new ArrayBlockingQueue<Runnable>(5));
        //生成线程池
        ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newFixedThreadPool(10);
        for (int i = 0; i < 15; i++) {
            MyTask myTask = new MyTask(i);
            executor.submit(myTask);
            executor.execute(myTask);
            logger.info(Thread.currentThread().getName());
//            System.out.println("线程池中线程数目:" + executor.getPoolSize() + "队列中等待执行的任务数目：" +
//                    executor.getQueue().size() + "已执行完的任务数目：" + executor.getCompletedTaskCount());

        }

        executor.shutdown();

    }


}
