package com;

public class PersonTest {

    public static void main(String[] args) {
        Person[] people = new Person[2];
        people[0] = new Employee("Tommy Tester", 40000, 1990, 3, 15);
        people[1] = new Student("Maria Morris", "computer science");

        for (Person p : people) {
            // 这里p是一个抽象类Person变量，Person引用了一个非抽象类的实例
            System.out.println(p.getName() + "," + p.getDescription());
        }
    }
}
