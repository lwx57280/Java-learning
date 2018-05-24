package com;

public class Cat extends Animal {
    @Override
    void eat() {
        System.out.println("吃鱼");
    }

    /**
     * 猫做的事情
     */
    public void work(){
        System.out.println("抓老鼠");
    }
}
