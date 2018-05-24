package com;

/**
 * Java 多态(动态绑定)
 * 当使用多态方式调用方法时，首先检查父类中是否有该方法，如果没有，则编译错误；如果有，再去调用子类的同名方法。
 * 多态的好处：可以使程序有良好的扩展，并可以对所有类的对象进行通用处理。
 */
public class MainTest {
    public static void main(String[] args) {
        // 以 Cat 对象调用 show 方法
        show(new Cat());
        // 以 Dog 对象调用 show 方法
        show(new Dog());

        // 向上转型
        Animal animal = new Cat();
        // 调用的是 Cat 的 eat
        animal.eat();

        // 向下转型(强制类型转换)
        Cat cat = (Cat) animal;
        // 调用的是 Cat 的 work
        cat.work();
    }

    public static void show(Animal animal) {
        animal.eat();
        //判断类型
        if (animal instanceof Cat) {
            // 猫做的事情
            Cat cat = (Cat) animal;
            cat.work();
        } else if (animal instanceof Dog) {
            Dog dog = (Dog) animal;
            dog.work();
        }
    }
}
