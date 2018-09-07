package com.dynamic;

public class TestJDKClassLoader {
    public static void main(String[] args) {
        // bootstrap class loader核心类是被bootstrap loader加载

        // extesion class loader 负责jdk拓展类
        //  核心的ClassLoader
//        System.out.println(String.class.getClassLoader());
//
//        // 这是一个拓展类
//        System.out.println(com.sun.crypto.provider.DESKeyFactory.class.getClassLoader().getClass().getName());
//
//        // 装载自定义类
//        System.out.println(TestJDKClassLoader.class.getClassLoader().getClass().getName());
//        // 获取系统的classloader
//        System.out.println(ClassLoader.getSystemClassLoader().getClass().getName());

        ClassLoader classLoader = TestJDKClassLoader.class.getClassLoader();
        while (null != classLoader) {
            System.out.println(classLoader.getClass().getName());
            classLoader = classLoader.getParent();

        }
    }
}
