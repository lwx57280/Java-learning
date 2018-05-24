package com;

public class Dog extends Animal {
    @Override
    void eat() {
        System.out.println("吃骨头");
    }

    /**
     * 狗做的事情
     */
    public void work(){
        System.out.println("看家");
    }
}
