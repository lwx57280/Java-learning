package com;

/**
 * 对象引用和堆栈的区别
 * 堆:由操作系统自动分配是否，存储函数的参数值局部变量的值等。其他操作方式类似与数据结构中的栈。
 * <p>
 * 栈内存：用于存储局部变量，当数据使用完，所占空间会自动释放。
 * 堆内存：数组和对象，通过new建立的实例都存放在堆内存中。
 * 栈：是操作系统
 * 堆栈数据结构区别
 * 1、堆:可以被堪称是一棵树，如堆排序
 * 2、栈:一种先进后出的数据结构
 */
public class Main {
    public static void main(String[] args) {
        // 所有对象都在堆内存创建
        UserBean userBean = new UserBean();
        userBean.setUserName("张三");
        userBean.setPassWord("123456");
//        System.out.println(userBean.getUserName() + "--" + userBean.getPassWord());

        // userBean 在堆内存userBean2内存地址引用指向userBean
        UserBean userBean2 = userBean;
        // 修改了类的成员变量值,因此两个对象输出结果一致
        userBean2.setUserName("李四");
        userBean2.setPassWord("456789");
        System.out.println(userBean.getUserName() + "--" + userBean.getPassWord());     // 李四-456789
        System.out.println(userBean2.getUserName() + "--" + userBean2.getPassWord());   // 李四-456789
    }
}
