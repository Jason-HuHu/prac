package com.huxl.designpattern.bridge;

/**
 * TODO...
 *
 * @author huxl
 * @since 2018/3/22 17:37
 */
public class RedCircle implements DrawAPI {
    @Override
    public void drawCircle() {
        System.out.println("Red Circle");
    }
}
