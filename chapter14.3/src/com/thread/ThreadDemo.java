package com.thread;

public class ThreadDemo {
    public static void main(String[] args) {
        Thread t1 = new Thread(new RunnableDemo("旺财"));
        Thread t2 = new Thread(new RunnableDemo("光头强"));
        //开启线程，调用run方法
        t1.start();
        //一个线程只能被启动一次。第二次启动时将会抛出java.lang.IllegalThreadExcetpion异常
        // t1.start();
        t2.start();
    }
}
