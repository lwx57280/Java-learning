package com.synch;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 有许多银行帐户的银行，它使用锁来实现串行存取。
 */
public class Bank {
    private final double[] accounts;

    private Lock bankLock;

    private Condition sufficientFunds;

    public Bank(int n, double initialBalance) {
        this.accounts = new double[n];
        for (int i = 0; i < accounts.length; i++)
            accounts[i] = initialBalance;
        bankLock = new ReentrantLock();
        // 返回一个与该锁相关的条件对象
        sufficientFunds = bankLock.newCondition();
    }

    /**
     * 假定一个线程调用transfer,在执行结束前被剥夺了运行权。假定第二个线程也调用transfer,由于第二个线程不能获得锁，
     * 将在调用lock方法时被阻塞。它必须等待第一个线程完成transfer方法的执行之后才能再度被激活。当第一个线程释放锁
     * 时，那么第二个线程才能开始执行。
     * @param from
     * @param to
     * @param amount
     * @throws InterruptedException
     */
    public void transfer(int from, int to, double amount) throws InterruptedException {
        bankLock.lock();

        try {
            while (accounts[from] < amount)
                // 当前线程放到条件的等候集中
                sufficientFunds.await();
            System.out.print(Thread.currentThread());
            accounts[from] -= amount;
            System.out.printf(" %10.2f from %d to %d", amount, from, to);
            accounts[to] += amount;
            System.out.printf(" Total Balance: %10.2f%n ", getTotalBalance());
            // 解除该条件的等待集中的所有线程的阻塞状态,在对象状态有利于等待线程的方向改变时调用signalAll
            sufficientFunds.signalAll();
        } finally {
            bankLock.unlock();
        }
    }

    /**
     * 获取所有帐户余额的总和。
     *
     * @return
     */
    public double getTotalBalance() {
        // 获得锁
        bankLock.lock();
        try {
            double sum = 0;
            for (double a : accounts)
                sum += a;
            return sum;
        } finally {
            // 释放锁
            bankLock.unlock();
        }
    }

    /**
     * 获取银行帐户的数量
     *
     * @return
     */
    public int size() {
        return accounts.length;
    }
}
