package com.huxl.designpattern.observer;

/**
 * TODO...
 *
 * @author huxl
 * @since 2018/3/23 9:55
 */
public class OctalObserver extends Observer {
    public OctalObserver(Subject subject) {
        this.subject = subject;
        subject.attach(this);
    }
    @Override
    public void update() {
        System.out.println("Octal String：" + Integer.toOctalString(subject.getState()));
    }
}
