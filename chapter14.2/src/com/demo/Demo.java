package com.demo;

/**
 * 创建线程方式一：继承Thread类。
 * 步骤：
 *      1、定义一个类继承Thread类。
 *      2、覆盖Thread类中的run方法。
 *      3、直接创建Thread的子类对象创建线程。
 *      4、调用Start方法开启线程并调用线程的任务run方法执行。
 *
 *      可以通过Thread的getName获取线程的名称，Thread-编号（从0开始）
 */
public class Demo extends Thread {

    private String name;

    public Demo() {
    }

    public Demo(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
            System.out.println(name + "......i" + i);
        }
    }
}
