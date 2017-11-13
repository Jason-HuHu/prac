package com.huxl.prac;

import redis.clients.jedis.Jedis;

import java.util.Set;

public class RedisAdapter {
    public static void main(String [] args) {
        //连接redis服务器
        Jedis jedis = new Jedis("139.196.78.99",6379);
        //权限验证
        jedis.auth("Huxlredis123");
        System.out.println("服务正在运行: "+jedis.ping());

        Set<String> keys = jedis.keys("*");
        System.out.println(keys);

        testStr(jedis);
    }

    public static void testStr(Jedis jedis){
        jedis.set("str1","strVal1");
        System.out.println(jedis.get("str1"));
    }
}
