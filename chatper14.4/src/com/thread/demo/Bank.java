package com.thread.demo;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Bank {
    private int count = 0;   // 账号余额

    private Lock lock = new ReentrantLock();

    /**
     * 存钱
     */
    public void addMoney(int money) {
        // (同步代码块，对于锁的操作是隐式的。 )
        synchronized (this) {
            count += money;
            System.out.println(System.currentTimeMillis() + "存进" + money);
        }
    }

    /**
     * 取钱
     */
    public void subMoney(int money) {
        synchronized (this) {
            if (count - money < 0) {
                System.out.println("余额不足！");
                return;
            }
            count -= money;
            System.out.println(System.currentTimeMillis() + "取钱:" + money);
        }
    }

    public void lookMoney(){
        System.out.println("账户余额:" + count);
    }
}
