package com;

public class Manager extends Employee {

    private double bouns;

    public Manager(String name, double salary, int year, int month, int day) {
        // 这里关键字super具有不同含义,是调用超类Employee中含有name, salary,  year, month, day参数构造器
        super(name, salary, year, month, day);
        this.bouns = 0;
    }

    public double getSalary(){
        double baseSalary= super.getSalary();
        return baseSalary+ bouns;
    }

    public double getBouns() {
        return bouns;
    }

    public void setBouns(double bouns) {
        this.bouns = bouns;
    }
}
