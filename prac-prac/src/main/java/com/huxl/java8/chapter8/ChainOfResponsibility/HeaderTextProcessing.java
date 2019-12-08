package com.huxl.java8.chapter8.ChainOfResponsibility;

/**
 * TODO..
 *
 * @author huxl
 * @since 2019/12/5-16:32
 */
public class HeaderTextProcessing extends ProcessingObject<String> {
    @Override
    protected String handleWork(String input) {
        return "From Raoul,Mario and Alan：" + input;
    }
}
