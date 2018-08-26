package com.sync;

/**
 * 线程同步:显示多线程访问数据结构时的数据损坏
 */
public class UnsynchBankTest {
    public static final int NACCOUNTS = 100;

    public static final double INITIAL_BALANCE = 1000;

    public static void main(String[] args) {
        Bank bank = new Bank(NACCOUNTS, INITIAL_BALANCE);
        int i;
        for (i = 0; i < NACCOUNTS; i++) {
            TransferRunnable r = new TransferRunnable(bank,i,INITIAL_BALANCE);
            Thread t = new Thread(r);
            t.start();
        }
    }
}
