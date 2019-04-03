package com.huxl.redis;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 * @author huxl
 * @createDate 2017/12/7 19:45
 */
public class JedisPoolUtil {
    private static volatile JedisPool jedisPool = null;
    private JedisPoolUtil(){}

    public static JedisPool getJedisPoolInstance() {
        if (null == jedisPool) {
            synchronized (JedisPoolUtil.class) {
                if (null == jedisPool) {
                    JedisPoolConfig poolConfig = new JedisPoolConfig();
                    poolConfig.setMaxTotal(1000);
                    poolConfig.setMaxIdle(32);
                    poolConfig.setMaxWaitMillis(100*1000);
                    poolConfig.setTestOnBorrow(true);
                    jedisPool = new JedisPool(poolConfig,"127.0.0.1",6379);
                }
            }
        }
        return jedisPool;
    }
    public static void release(JedisPool jedisPool, Jedis jedis) {
        if (null != jedis) {
            jedis.close();
        }
    }


}
