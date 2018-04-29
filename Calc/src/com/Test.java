package com;

public class Test {
    public static void main(String[] args){
        String a = new String("foo");

        String b = new String("foo");
        // ==基本数据类型比较的的就是基本数据类型内存中所存储的值是否相等
        // ，用于比较引用数据类型，比较的是对象的地址是否相等。
        System.out.println("结果为："+(a==b));
        // equals方法是比较两个对象中的内容是否相同。
        System.out.println("结果为："+a.equals(b));
    }
}
