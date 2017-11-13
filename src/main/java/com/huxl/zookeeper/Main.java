package com.huxl.zookeeper;

import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.ZooDefs;
import org.apache.zookeeper.ZooKeeper;
import org.apache.zookeeper.data.Stat;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException, KeeperException, InterruptedException {
//        ZooKeeper zooKeeper = new ZooKeeper("132.126.3.122:2181,132.126.3.122:2182,132.126.3.122:2183",30000, new TestWatcher());
        ZooKeeper zooKeeper = new ZooKeeper("132.126.3.122:2181",30000, new TestWatcher());
        String node = "/testzk";
        Stat stat = zooKeeper.exists(node, false);

        if (null == stat) {
            //创建节点
            String createResult = zooKeeper.create(node, "test".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.EPHEMERAL);
            System.out.println(createResult);
        }

        byte[] b = zooKeeper.getData(node, false, stat);
        System.out.println(new String(b));
    }

}

