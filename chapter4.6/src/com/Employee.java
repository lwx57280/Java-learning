package com;

import java.util.Random;

public class Employee {

    private static int nextId;
    private int id;

    private String name = "";

    private double salary;

    // 静态初始化块
    static {
        Random generator = new Random();
        // 将nextId设置为0到9999之间的随机数
        nextId = generator.nextInt(10000);
    }

    // 对象初始化块
    {
        id = nextId;
        nextId++;
    }

    public Employee() {
    }

    public Employee(double salary) {
        this.salary = salary;
    }

    public Employee(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }

    public int getId() {
        return id;
    }


    public String getName() {
        return name;
    }

    public double getSalary() {
        return salary;
    }



    public void raiseSalary(double byPercent) {
        double raise = this.salary * byPercent / 100;
        this.salary += raise;
    }
}
