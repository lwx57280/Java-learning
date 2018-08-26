package com.lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Bank {
    private int count = 0;   // 账号余额

    private Lock lock = new ReentrantLock();

    /**
     * 存钱
     */
    public void addMoney(int money) {
        // 上锁
        lock.lock();
        try {
            count += money;
            System.out.println(System.currentTimeMillis() + "存进：" + money);
        } finally {
            // 释放锁
            lock.unlock();
        }
    }

    /**
     * 取钱
     */
    public void subMoney(int money) {
        lock.lock();
        try {
            if (count - money < 0) {
                System.out.println("余额不足！");
                return;
            }
            count -= money;
            System.out.println(System.currentTimeMillis() + "取钱:" + money);
        }finally {
            lock.unlock();
        }
    }

    /**
     * 查询
     */
    public void lookMoney() {
        System.out.println("账户余额:" + count);
    }
}
