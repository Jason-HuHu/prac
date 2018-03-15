package com.huxl.concurrent;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author huxl
 * @createDate 2018/3/14 9:29
 */
public class ConcurrentHashMapMain {
    public static void main(String[] args) {
        testConcurrentHashMap();
    }

    private static void testConcurrentHashMap(){
        Map<String,Object> currentHashMap = new ConcurrentHashMap<>();
        Runnable task = new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 100000; i++){
                    currentHashMap.put("a" + i,i);
                }
            }
        };

        new Thread(task).start();
        new Thread(task).start();
        System.out.println(currentHashMap.size());

    }

}
