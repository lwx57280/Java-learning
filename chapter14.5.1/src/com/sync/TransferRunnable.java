package com.sync;

/**
 * 把钱从一个账户转到另一个银行账户的可运行的
 */
public class TransferRunnable implements Runnable {

    private Bank bank;
    private int fromAccount;
    private double maxAccount;
    private int DELAY = 10;

    public TransferRunnable(Bank bank, int fromAccount, double maxAccount) {
        this.bank = bank;
        this.fromAccount = fromAccount;
        this.maxAccount = maxAccount;
    }

    @Override
    public void run() {
        try {
            while (true) {
                int toAccount = (int) (bank.size() * Math.random());
                double amount = maxAccount * Math.random();
                bank.transfer(fromAccount, toAccount, amount);
                Thread.sleep((int) (DELAY * Math.random()));
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
