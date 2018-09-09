package com.recursion;

/**
 * java 递归
 */
public class RecursionDemo {

    public static void main(String[] args) {
        System.out.println(calc(10));
    }

    public static int calc(int n) {
        if (n == 1 || n == 2) {
            return 1;
        } else {
            return calc(n - 1) + calc(n - 2);
        }
    }
}
