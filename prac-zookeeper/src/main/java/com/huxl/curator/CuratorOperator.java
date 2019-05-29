package com.huxl.curator;

import org.apache.curator.RetryPolicy;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.retry.ExponentialBackoffRetry;

/**
 * Curator基本操作
 *
 * @author huxl
 * @since 2019/5/22 17:48
 */
public class CuratorOperator {

    private CuratorFramework client;

    private static final String ZK_SERVER_PATH = "192.168.99.100:2181";

    private static final int SESSION_TIMEOUT = 60*1000;

    public static void main(String[] args) {

        CuratorOperator curatorOperator = new CuratorOperator();


    }

    public CuratorOperator(){

        /*
            curator 连接zk的策略

         */
        RetryPolicy retryPolicy = new ExponentialBackoffRetry(1000,5);

        client = CuratorFrameworkFactory.builder()
                .connectString(ZK_SERVER_PATH)
                .sessionTimeoutMs(SESSION_TIMEOUT).retryPolicy(retryPolicy)
                .build();
        //启动
        client.start();
    }

    public void closeZKClient(){
        if (client!=null) {
            client.close();
        }
    }

}
