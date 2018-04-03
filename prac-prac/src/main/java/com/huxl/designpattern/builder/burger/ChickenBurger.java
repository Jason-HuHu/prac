package com.huxl.designpattern.builder.burger;

/**
 * TODO...
 *
 * @author huxl
 * @since 2018/3/22 11:36
 */
public class ChickenBurger extends Burger {
    @Override
    public String name() {
        return "Chicken Burger";
    }

    @Override
    public float price() {
        return 25.0f;
    }
}
