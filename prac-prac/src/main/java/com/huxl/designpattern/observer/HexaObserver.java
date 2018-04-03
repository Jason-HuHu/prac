package com.huxl.designpattern.observer;

/**
 * TODO...
 *
 * @author huxl
 * @since 2018/3/23 10:02
 */
public class HexaObserver extends Observer{
    public HexaObserver(Subject subject) {
        this.subject = subject;
        subject.attach(this);
    }

    @Override
    public void update() {
        System.out.println("Hexa Strring:" + Integer.toHexString(subject.getState()).toUpperCase());

    }
}
