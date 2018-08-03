package com;

import java.util.Scanner;

/**
 * 分析堆栈跟踪元素
 * StackTraceElement类含有能够获得文件名和当前执行的代码行号的方法，同
 * 时还含有能够获得类名和方法名。toString()方法将产生一个格式化字符串，其中包含所获得的信息
 */
public class StackTraceTest {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        System.out.println("Enter N:");
        int i = in.nextInt();
        factorial(i);

    }

    /**
     * 计算数的阶乘
     *  打印递归阶乘堆栈
     * @link 生成参考其他的JavaDoc文档，它和@see标记的区别在于，
     * @link 标记能够嵌入到注释语句中，为注释语句中的特殊词汇生成连接。
     * eg.{@link Hello}
     *
     * @param n
     * @return
     */
    public static int factorial(int n) {
        System.out.println("factorial(" + n + "):");
        Throwable t = new Throwable();
        StackTraceElement[] frames = t.getStackTrace();
        for (StackTraceElement f : frames) {
            System.out.println(f);
        }
        int r;
        if (n <= 1)
            r = 1;
        else
            r = n * factorial(n - 1);
        System.out.println("return " + r);
        return r;
    }
}
