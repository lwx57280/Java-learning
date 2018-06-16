package com;

/**
 * JDK1.8 : 接口的默认方法
 */
public interface Formula {
    double calculate(int a);

    default double sqrt(int a) {
        return Math.sqrt(a);
    }
}
