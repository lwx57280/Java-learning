package com.thread.demo;

/**
 * 线程同步
 */
public class syncThreadTest {

    public static void main(String[] args) {
        final Bank bank = new Bank();
        Thread tadd = new Thread(() -> {
            while (true) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                bank.addMoney(100);
                bank.lookMoney();
                System.out.println("\n");
            }
        });

        Thread tsub = new Thread(() -> {
            while (true) {
                bank.subMoney(100);
                bank.lookMoney();
                System.out.println("\n");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        tsub.start();

        tadd.start();
    }
}
