package com.thread;

/**
 * 创建线程方式二：实现Runnable接口
 * <p>
 * 实现Runnable接口的好处：
 * 1、将线程的任务从线程的子类中分离出来，进行了单独的封装。
 * 按照面向对象的思想将任务封装成对象
 * 2、避免了java单继承的局限性。
 * <p>
 * 所以，创建线程的第二种方式较为常用。
 */
public class RunnableDemo implements Runnable {

    private String name;

    public RunnableDemo(String name) {
        super();
        this.name = name;
    }

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println(name + "......i=" + i + "........name=" + Thread.currentThread().getName());
        }
    }
}
