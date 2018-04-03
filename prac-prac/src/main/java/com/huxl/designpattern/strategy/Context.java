package com.huxl.designpattern.strategy;

/**
 * TODO...
 *
 * @author huxl
 * @since 2018/3/23 11:19
 */
public class Context {
    private Stratge stratge;
    public Context (Stratge stratge) {
        this.stratge = stratge;
    }

    public int executeStratge(int num1, int num2) {
        return stratge.doOperation(num1,num2);
    }
}
