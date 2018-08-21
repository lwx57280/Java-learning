package com;

import java.lang.reflect.Method;

/**
 * 调用任意方法
 */
public class MethodTableTest {
    public static void main(String[] args) {
        // 获取指向正方形和sqrt方法的方法指针
        try {
            Method square = MethodTableTest.class.getMethod("square", double.class);
            Method sqrt = Math.class.getMethod("sqrt", double.class);
            // x值和y值的打印表
            printTable(1, 10, 10, square);
            printTable(1, 10, 10, sqrt);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }


    }

    /**
     * 返回数字的平方
     *
     * @param x
     * @return
     */
    public static double square(double x) {
        return x * x;
    }

    /**
     * 打印方法的x值和y值的表。
     *
     * @param i
     * @param i1
     * @param i2
     * @param square
     */
    private static void printTable(int from, int to, int n, Method f) {
        // 将方法打印为表标题
        System.out.println(f);

        double dx = (to - from) / (n - 1);
        for (double x = from; x <= to; x += dx) {
            try {
                double y = (double) f.invoke(null, x);
                System.out.printf("%10.4f | %10.4f%n", x, y);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
