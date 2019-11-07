package com.huxl.juc;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

/**
 * 测试多线程下静态变量的读写
 * @author huxl
 * @since 2019/11/7-9:05
 */
public class SynchronizedNullDemo {

    private static volatile Map<String,Object> testMap = new HashMap<>();

    public static void main(String[] args) {


        MyThread t1 = new MyThread();
        MyThread t2 = new MyThread();
        new Thread(t2).start();
        new Thread(t1).start();
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(testMap.get("test"));
    }

    public static Object getStrFromMap(String newStr,Object condition) {
        Object result = testMap.get(newStr);
        if (result == null) {
            synchronized (SynchronizedNullDemo.class) {

                //Java8之后推荐这种写法
                result = testMap.computeIfAbsent(newStr,k -> condition);
                /*result = testMap.get(newStr);
                if (result == null) {
                    result = condition;
                    testMap.put(newStr,result);
                }*/


            }
            System.out.println("类锁释放：" + Thread.currentThread().getName());
        }

        return result;
    }

    public static class MyThread implements Runnable{

        @Override
        public void run() {
            Object result = SynchronizedNullDemo.getStrFromMap("test",Thread.currentThread().getName());
            System.out.println("当前线程：" + Thread.currentThread().getName() + "返回结果：" + result);
        }
    }

}
