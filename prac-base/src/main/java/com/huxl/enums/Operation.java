package com.huxl.enums;

/**
 * TODO..
 *
 * @author xiaoh
 * @since 2019/2/19 15:00
 */
public enum Operation {

    /**
     *
     */
    PLUS("+"){
        @Override
        double apply(double x, double y) {
            return x + y;
        }
    },
    MINUS("-"){
        @Override
        double apply(double x, double y) {
            return x - y;
        }
    },
    TIMES("*"){
        @Override
        double apply(double x, double y) {
            return x * y;
        }
    },
    DIVIDE("/"){
        @Override
        double apply(double x, double y) {
            return x/y;
        }
    };

    private final String symbol;

    Operation(String symbol) {
        this.symbol = symbol;
    }

    @Override
    public String toString() {
        return symbol;
    }

    abstract double apply(double x, double y);
}
