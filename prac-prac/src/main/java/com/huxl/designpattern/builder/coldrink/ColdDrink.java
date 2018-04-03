package com.huxl.designpattern.builder.coldrink;

import com.huxl.designpattern.builder.Item;
import com.huxl.designpattern.builder.Packing;
import com.huxl.designpattern.builder.Bottle;

/**
 * 冷饮抽象类
 *
 * @author huxl
 * @since 2018/3/22 11:30
 */
public abstract class ColdDrink implements Item {
    @Override
    public Packing packing() {
        return new Bottle();
    }

    @Override
    public abstract float price();
}
