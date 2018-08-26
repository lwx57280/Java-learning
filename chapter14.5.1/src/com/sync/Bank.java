package com.sync;

public class Bank {
    private final double[] accounts;

    public Bank(int n, double initialBalance) {
        this.accounts = new double[n];
        for (int i = 0; i < accounts.length; i++)
            accounts[i] = initialBalance;
    }

    /**
     * 把钱从一个账户转到另一个账户
     *
     * @param from
     * @param to
     * @param amount
     */
    public void transfer(int from, int to, double amount) {
        if (accounts[from] < amount)
            return;
        System.out.println(Thread.currentThread());
        accounts[from] -= amount;
        System.out.printf(" %10.2f from %d to %d", amount, from, to);
        accounts[to] += amount;
        System.out.printf(" Total Balance:%10.2f%n", getTotalBalance());
    }

    /**
     * 获取所有帐户余额的总和。
     *
     * @return
     */
    public double getTotalBalance() {
        double sum = 0;
        for (double a : accounts)
            sum += a;
        return sum;
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
