package com;

import java.util.Date;

/**
 * super.getClass()方法调用
 * Test类没有包的情况下输出Test，有包的情况下输出:包.类名
 *
 */
public class Test extends Date{
    public static void main(String[] args) {
        new Test().test();
    }

    public void test(){
        System.out.println(super.getClass().getName());
    }
}
