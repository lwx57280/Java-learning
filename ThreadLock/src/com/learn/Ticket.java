package com.learn;

/**
 * 死锁：常见情景之一，同步嵌套
 * 两个或多个线程之间相互等待，导致线程都无法执行，叫做线程死锁。
 */
public class Ticket implements Runnable {
    private int num = 100;

    Object obj = new Object();
    boolean flag = true;

    @Override
    public void run() {
        if (flag) {
            while (true) {
                synchronized (obj) {
                    show();
                }
            }
        }else {
            while (true) {
                this.show();
            }
        }
    }

    public synchronized void show() {
        synchronized (obj) {
            if (num > 0) {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.getMessage();
                }
                System.out.println(Thread.currentThread().getName()+" function......"+num--);
            }
        }
    }


    public static void main(String[] args) {
        Ticket ticket = new Ticket();
        Thread t1=new Thread(ticket);
        Thread t2=new Thread(ticket);

        t1.start();
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
        }
        ticket.flag=false;
        t2.start();
    }
}
