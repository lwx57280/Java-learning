package com;

/**
 * 参数数量可变的方法
 */
public class DynamicParam {
    public static void main(String[] args) {
        double result = max(3.1, 40.4, -5, 50.5);
        System.out.println("result=:" + result);
    }

    /**
     * 计算若干个数值的最大值
     *
     * @param values
     * @return
     */
    public static double max(double... values) {
        double largest = Double.MIN_VALUE;
        System.out.println("largest=:" + largest);
        for (double v : values)
            if (v > largest)
                largest = v;
        return largest;
    }
}
