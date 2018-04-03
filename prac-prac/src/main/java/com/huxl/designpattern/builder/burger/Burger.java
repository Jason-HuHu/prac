package com.huxl.designpattern.builder.burger;

import com.huxl.designpattern.builder.Item;
import com.huxl.designpattern.builder.Packing;
import com.huxl.designpattern.builder.Wrapper;

/**
 * 汉堡抽象类
 *
 * @author huxl
 * @since 2018/3/22 11:30
 */
public abstract class Burger implements Item {
    @Override
    public Packing packing() {
        return new Wrapper();
    }

    @Override
    public abstract float price();
}
