package com;

import java.text.NumberFormat;
import java.util.Date;

public class EmpMain {
    public static void main(String[] args) {
        Employee[] staff = new Employee[3];

        staff[0] = new Employee("Carl Cracker", 1300.00, 1987, 12, 15);
        staff[1] = new Employee("Harry Hacker", 1200.00, 1989, 10, 1);
        staff[2] = new Employee("Tony Tester", 1400.00, 1990, 3, 15);

        Employee harry =new Employee("Carl Cracker", 1500.00, 1987, 12, 15);
        tripleSalary(harry);
        System.out.println("harry=:"+harry.getSalary());
        // 把每个人的工资提高5%
        for (Employee emp : staff)
            emp.raiseSalary(5);


        // 打印有关所有雇员对象的信息
        for (Employee e : staff){
            e.setId();
            System.out.println("name=:" + e.getName() + ",salary=" + e.getSalary() + ",hireDay=" + e.getHireDay());
            // 调用静态方法
            System.out.println("nextId=:"+Employee.getNextId());
        }

        NumberFormat currentFormatter = NumberFormat.getCurrencyInstance();
        NumberFormat percentFormatter = NumberFormat.getPercentInstance();
        double x=0.1;
        System.out.println("currentFormatter=:"+currentFormatter.format(x));
        System.out.println("percentFormatter=:"+percentFormatter.format(x));

        Employee a = new Employee("Alice",1200.00, 1989, 10, 1);
        Employee b = new Employee("Bob",1100.00, 1990, 12, 2);
        // a现在是指bob，b指alice吗？
        swap(a,b);

    }


    public static void tripleSalary(Employee x){
        x.raiseSalary(200);
    }

    /**
     *  交换两个雇员对象的方法
     * @param x
     * @param y
     */
    public static void swap(Employee x,Employee y){
        Employee temp=x;
        x=y;
        y=temp;
    }
}
