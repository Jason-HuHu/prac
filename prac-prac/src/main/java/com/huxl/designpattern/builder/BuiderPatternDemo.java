package com.huxl.designpattern.builder;

/**
 * 建造者模式Demo
 *
 * @author huxl
 * @since 2018/3/22 16:07
 */
public class BuiderPatternDemo {
    public static void main(String[] args) {
        MealBuilder mealBuilder = new MealBuilder();

        Meal vegMeal = mealBuilder.prepareVegMeal();
        System.out.println("Veg Meal");
        vegMeal.showItems();
        System.out.println("Total cost:" + vegMeal.getCost());

        Meal nonVegMeal = mealBuilder.prepareNonVegMeal();
        System.out.println("NonVeg Meal");
        nonVegMeal.showItems();
        System.out.println("Total cost:" + nonVegMeal.getCost());

    }
}
