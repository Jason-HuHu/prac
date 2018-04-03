package com.huxl.designpattern.builder.coldrink;

/**
 * TODO...
 *
 * @author huxl
 * @since 2018/3/22 11:55
 */
public class Pepsi extends ColdDrink {

    @Override
    public String name() {
        return "Pepsi";
    }

    @Override
    public float price() {
        return 35.0f;
    }
}
