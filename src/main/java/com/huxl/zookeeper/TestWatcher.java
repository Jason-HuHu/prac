package com.huxl.zookeeper;

import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;

public class TestWatcher implements Watcher {
    @Override
    public void process(WatchedEvent watchedEvent) {
        System.out.println("-----------------------------------");
        System.out.println("path:" + watchedEvent.getPath());
        System.out.println("type:" + watchedEvent.getType());
        System.out.println("state:" + watchedEvent.getState());
        System.out.println("-----------------------------------");

    }
}
