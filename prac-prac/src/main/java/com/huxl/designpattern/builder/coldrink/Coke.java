package com.huxl.designpattern.builder.coldrink;

/**
 * TODO...
 *
 * @author huxl
 * @since 2018/3/22 11:55
 */
public class Coke extends ColdDrink {

    @Override
    public String name() {
        return "Coke";
    }

    @Override
    public float price() {
        return 3.0f;
    }
}
