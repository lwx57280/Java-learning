package com;

/**
 * finalyy 子句
 */
public class finallyDemo {
    public static void main(String[] args) {
        // 如果f(2)，那么try语句块计算结果是4，并执行return语句。然而，在方法真正返回前，还要执行finally子句。finally子句将使方法返回0，
        // 这个返回值覆盖了原始的返回值4
        int t = f(2);
        System.out.println("t=:"+t);

    }

    /**
     * 在方法返回前，finally 子句的内容将被执行。
     * 如果finally 子句中也有一个return语句，这个返回值将会覆盖原始的返回值
     * @param n
     * @return
     */
    public static int f(int n) {
        try {

            int r = n * n;
            return r;
        } finally {
            if (n == 2) return 0;
        }
    }
}
