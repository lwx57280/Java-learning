package com;

public class constants {
    public static final double CM_PER_INCH = 2.54;

    public static strictfp void main(String[] args) {
        double paperWidth = 8.5;
        double paperHeight = 11;
        System.out.println("Paper size in centimeters:" + paperWidth * CM_PER_INCH + " by " + paperHeight * CM_PER_INCH);

//        System.out.println(15 / 2);
//        System.out.println(15 % 2);
//        System.out.println(15.0 / 2);
        // 除数不能为0
        System.out.println(paperHeight / 0);
        System.out.println(paperWidth / 0);

        int x = 8;
        // 二元运算符  通常将运算符放在赋值号的左侧,例如:*=，/=，%=
        //x += 4;
//        x *= 5;
        x %= 5; // 求余
        System.out.println(x);
        System.out.println();

        // 自增运算符与自减运算符
        autoAdd(12);

        arithmetic(8);
    }

    private static void autoAdd(int n) {
        int m = 7;
        int j = 7;
        int a = 2 * ++m;    // 前缀方式先进行加1运算
        int b = 2 * j++;    // 后缀方式则使用原来的值
        System.out.println("a=:"+a+",b=:"+b);
        n++;
        System.out.println("n==:" + n);
    }

    private static void arithmetic(int a) {
        int fourthBitFromRight=(a&(1<<3)>>3);
        System.out.println("fourthBitFromRight=:"+fourthBitFromRight);

        double x=4;
        double y =Math.sqrt(x);
        System.out.print("y=:"+y);
    }
}
