package com.huxl.designpattern.observer;

import java.util.ArrayList;
import java.util.List;

/**
 * TODO...
 *
 * @author huxl
 * @since 2018/3/23 9:47
 */
public class Subject {
    private List<Observer> observers = new ArrayList<>();
    private int state;

    public int getState() {
        return state;
    }
    public void setState(int state) {
        this.state = state;
        notifyAllObservers();
    }

    //添加观察者
    public void attach(Observer observer) {
        observers.add(observer);
    }

    //提醒所有观察者
    public void  notifyAllObservers() {
        for (Observer observer : observers) {
            observer.update();
        }
    }



}
