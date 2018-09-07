package com.dynamic;

/**
 * ClassLoad动态加载机制
 */
public class TestDynamicLoading {
    public static void main(String[] args) {
        new A();
        System.out.println("**---------------------------**");
        new B();

        new C();
        new C();

        new D();
        new D();

    }
}

class A{

}

class B{

}

class C{
    /**
     * 静态语句块: static语句块在加载后执行一次。
     */
    static {
        System.out.println("CCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCC");
    }

}
class D{
    /**
     * dynamic语句块:每次new一个对象的时候会被调用一次
     */
    {
        System.out.println("——————DDDD———————");
    }
}