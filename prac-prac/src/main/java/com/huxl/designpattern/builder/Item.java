package com.huxl.designpattern.builder;

/**
 * @author huxl
 * @since 2018/3/22 11:20
 */
public interface Item {
    public String name();
    public Packing packing();
    public float price();
}
