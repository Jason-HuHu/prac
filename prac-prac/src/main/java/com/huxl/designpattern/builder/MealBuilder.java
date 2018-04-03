package com.huxl.designpattern.builder;

import com.huxl.designpattern.builder.coldrink.Coke;
import com.huxl.designpattern.builder.coldrink.Pepsi;
import com.huxl.designpattern.builder.burger.ChickenBurger;
import com.huxl.designpattern.builder.burger.VegBurger;

/**
 * TODO...
 *
 * @author huxl
 * @since 2018/3/22 14:17
 */
public class MealBuilder {
    public Meal prepareVegMeal() {
        Meal meal = new Meal();
        meal.addItem(new VegBurger());
        meal.addItem(new Coke());
        return meal;
    }

    public Meal prepareNonVegMeal() {
        Meal meal = new Meal();
        meal.addItem(new ChickenBurger());
        meal.addItem(new Pepsi());
        return meal;
    }
}
