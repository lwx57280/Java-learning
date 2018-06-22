package com;

/**
 * 成员变量作用域和存储位置
 * 成员变量：随着对象的创建而存在，随着对象的消失而消失,存储在堆内存中
 * 初始值：成员变量都有默认初始值
 *
 * 成员变量可以被 public 、protect、private、static等修饰符修饰，
 */
public class UserBean {

    private String userName;

    private String passWord;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }
}
