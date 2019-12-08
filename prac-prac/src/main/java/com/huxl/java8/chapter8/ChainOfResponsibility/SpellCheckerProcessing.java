package com.huxl.java8.chapter8.ChainOfResponsibility;

/**
 * 拼写检查
 * @author huxl
 * @since 2019/12/5-16:35
 */
public class SpellCheckerProcessing extends ProcessingObject<String>{
    @Override
    protected String handleWork(String input) {
        return input.replaceAll("labda","lambda");
    }
}
