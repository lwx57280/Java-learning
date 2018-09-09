package com.recursion;

/**
 * 递归 5的阶乘
 */
public class TestCalc {
    public static void main(String[] args) {
        System.out.println(method(5));
    }

    public static int method(int n) {
        if (n == 1)
            return 1;
        else
            return n * method(n - 1);
    }
}
