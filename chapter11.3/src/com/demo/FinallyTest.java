package com.demo;

/**
 * 无论try里执行了return语句、break语句、还是continue语句，finally语句块还会继续执行
 *
 * 注意，当try或者catch的代码在运行的时候，JVM退出了。那么finally语句块就不会执行。同样，如果线程在运行try或者catch的代
 * 码时被中断了或者被杀死了(killed)，那么finally语句可能也不会执行了，即使整个运用还会继续执行。
 */
public class FinallyTest {
    public static void main(String[] args) {
        FinallyTest finallyTest=new FinallyTest();
        int i = finallyTest.add();
        System.out.println("i = "+i);
    }

    public int add() throws NumberFormatException {
        int x = 1;
        try {

           int a = 5/0;
            return ++x;
//            System.exit()


        } catch (Exception e) {
            e.printStackTrace();
        } finally {
//            return ++x;
            ++x;
        }
        return x;
    }
}
