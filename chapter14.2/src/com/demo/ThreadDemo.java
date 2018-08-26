package com.demo;

/**
 * 创建线程的目的是为了开启一条执行路径，去运行指定的代码和其他代码实现同时运行。
 * 而运行的指定代码就是这个执行路径的任务，
 * jvm创建的主线程的任务都定义在了主函数中。
 *
 * 而自定义的线程它的任务在哪儿呢？
 * Thread类用于描述线程，线程是需要任务的。所以Thread类也对任务的描述。
 * 这个任务就通过Thread类中的run方法来实现，也就是说，run方法就是封装在自定义线程运行任务的函数。
 *
 * run方法中定义就是线程要运行的任务代码。
 *
 * 开启线程是为了运行指定代码，所以只有继承Thread类，并复写run方法
 * 将运行的代码定义在run方法中即可。
 */
public class ThreadDemo {
    public static void main(String[] args) {
        Demo demo1 = new Demo("旺财");
        Demo demo2 = new Demo("xiaoqiang");
        //开启线程，调用run方法
        demo1.start();
        System.out.println("haha");
        demo2.start();
    }
}
