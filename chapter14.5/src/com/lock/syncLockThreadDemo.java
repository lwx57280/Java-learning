package com.lock;

/**
 * 效果和前两种方法差不多。
 * 如果synchronized关键字能满足用户的需求，就用synchronized，因为它能简化代码 。
 * 如果需要更高级的功能，就用ReentrantLock类，
 * 此时要注意及时释放锁，否则会出现死锁，通常在finally代码释放锁
 */
public class syncLockThreadDemo {
    public static void main(String[] args) {
        final Bank bank = new Bank();
        Thread tadd = new Thread(()->{
           while (true){
               try{
                   Thread.sleep(1000);

               }catch (InterruptedException e){
                   e.printStackTrace();
               }
               bank.addMoney(100);
               bank.lookMoney();
               System.out.println("\n");
           }
        });

        Thread tsub = new Thread(()->{
            while (true){
                bank.subMoney(100);
                bank.lookMoney();
                System.out.println("\n");
                try{
                    Thread.sleep(1000);
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
            }
        });

        tsub.start();

        tadd.start();
    }
}
