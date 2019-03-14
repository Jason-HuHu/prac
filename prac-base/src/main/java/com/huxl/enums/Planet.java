package com.huxl.enums;

/**
 * 枚举实例
 *
 * @author xiaoh
 * @since 2019/2/19 10:12
 */
public enum  Planet {
    /**
     *
     */
    EARTH(5.975e+24, 6.378e6);

    private final double mass;
    private final double radius;
    private final double surfaceGravity;
    private static final double G = 6.67300E-11;


    Planet(double mass, double radis) {
        this.mass = mass;
        this.radius = radis;
        this.surfaceGravity = G * mass / (radis * radis);
    }

    public double mass() {
        return mass;
    }

    public double radius() {
        return radius;
    }

    public double surfaceGravity() {
        return surfaceGravity;
    }

    public double surfaceWeight(double mass) {
        //F = ma
        return mass * surfaceGravity;
    }
}
