package com.huxl.designpattern.observer;

/**
 * TODO...
 *
 * @author huxl
 * @since 2018/3/23 9:48
 */
public abstract class Observer {
    protected Subject subject;
    public abstract void update();

}
