package com.huxl.java8.chapter8.ChainOfResponsibility;

import java.util.function.Function;
import java.util.function.UnaryOperator;

/**
 * 责任链模式
 * @author huxl
 * @since 2019/12/5-16:40
 */
public class ChainDemo {
    public static void main(String[] args) {
        ProcessingObject<String> p1 = new HeaderTextProcessing();
        ProcessingObject<String> p2 = new SpellCheckerProcessing();

        p1.setSuccessor(p2);

        String result = p1.handle("Aren't labda really sexy?");

        System.out.println(result);


        System.out.println("Lambda is working ...");
        UnaryOperator<String> headerProcessing = text -> "From Raoul,Mario and Alan: " + text;
        UnaryOperator<String> spellCheckerProcessing = text -> text.replaceAll("labda","lambda");

        Function<String,String> pipeline = headerProcessing.andThen(spellCheckerProcessing);

        String result1  = pipeline.apply("Aren't labda really sexy?");
        System.out.println(result1);

    }
}
