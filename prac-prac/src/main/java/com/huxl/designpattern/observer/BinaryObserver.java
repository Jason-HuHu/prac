package com.huxl.designpattern.observer;

/**
 * TODO...
 *
 * @author huxl
 * @since 2018/3/23 9:53
 */
public class BinaryObserver extends Observer {
    public BinaryObserver(Subject subject){
        this.subject = subject;
        subject.attach(this);

    }
    @Override
    public void update() {
        System.out.println("Binary String" + Integer.toBinaryString(subject.getState()));
    }
}
