package com.huxl.designpattern.strategy.operation;

import com.huxl.designpattern.strategy.Stratge;

/**
 * TODO...
 *
 * @author huxl
 * @since 2018/3/23 11:17
 */
public class OperationMultiply implements Stratge {
    @Override
    public int doOperation(int num1, int num2) {
        return num1 * num2;
    }
}
