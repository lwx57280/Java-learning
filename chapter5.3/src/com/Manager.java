package com;

public class Manager extends Employee {

    private static final long serialVersionUID = 5908474939085985057L;

    private double bouns;

    public Manager(String name, double salary, int year, int month, int day) {
        // 这里关键字super具有不同含义,是调用超类Employee中含有name, salary,  year, month, day参数构造器
        super(name, salary, year, month, day);
        this.bouns = 0;
    }

    @Override
    public double getSalary() {
        double baseSalary= super.getSalary();
        return baseSalary+ bouns;
    }

    public double getBouns() {
        return bouns;
    }

    public void setBouns(double bouns) {
        this.bouns = bouns;
    }

    public boolean equals(Object otherObj){
        if(!super.equals(otherObj))
            return false;
        Manager other =(Manager)otherObj;
        // 检查此类和其他类是否属于同一个类。
        return bouns==other.bouns;
    }

    @Override
    public String toString() {
        // 如果超类使用了getClass().getName(),那么子类只要调用super.toString()就可以了,如下:
        return super.toString()+"[bouns="+bouns+"]";
    }
}
