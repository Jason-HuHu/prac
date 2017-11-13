package com.huxl.seralization.loadBalancing;


import java.util.*;

/**
 * @author huxl
 * @createDate 2017/10/31 11:40
 * 轮询-负载均衡
 */
public class RoundRobin {
    private static Map<String, Integer> serviceWeightMap = new HashMap();
    private static Integer pos = 0;
    public static void main(String[] args) {

        serviceWeightMap.put("192.168.0.1",1);
        serviceWeightMap.put("192.168.0.2",2);
        serviceWeightMap.put("192.168.0.3",1);
        serviceWeightMap.put("192.168.0.4",3);
        serviceWeightMap.put("192.168.0.5",4);
        serviceWeightMap.put("192.168.0.6",1);
        serviceWeightMap.put("192.168.0.7",5);
        serviceWeightMap.put("192.168.0.8",1);
        serviceWeightMap.put("192.168.0.9",10);
        serviceWeightMap.put("192.168.0.10",1);
        serviceWeightMap.put("192.168.0.11",1);


        for (int i = 0;i < 20; i++) {
            new Thread(new ThreadA()).start();

        }


    }

    public static String testRoundRobin(){
        //重新创建一个map,避免由于服务器上线和下线导致的并发问题
        Map<String,Integer> serverMap = new HashMap<>();
        serverMap.putAll(serviceWeightMap);

        //取得ip地址的list
        Set<String> keySet = serverMap.keySet();
        Iterator<String> it = keySet.iterator();
        ArrayList<String> keyList = new ArrayList<String>();

        while (it.hasNext()) {
         String server = it.next();
         Integer weight = serverMap.get(server);
         for (int i = 0;i < weight; i++) {
             keyList.add(server);
         }
        }

        String server;
        synchronized(pos) {
            if (pos >= keyList.size()) {
                pos = 0;
            }
            server = keyList.get(pos);
            pos ++;

        }
        System.out.println("pos:"+pos);
        System.out.println(server);
        return server;
    }
}
