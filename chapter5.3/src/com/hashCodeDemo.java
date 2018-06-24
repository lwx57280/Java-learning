package com;

import java.util.ArrayList;

/**
 * 泛型数组列表
 */
public class hashCodeDemo {
    public static void main(String[] args) {

        Manager boss = new Manager("Car Cracker", 80000, 1987, 12, 15);
        boss.setBouns(5000);

//        Employee[] staff = new Employee[3];
        ArrayList<Employee> staff = new ArrayList<>(100);
        staff.add(boss);
        staff.add(new Employee("Harry Hacker", 50000, 1989, 10, 1));
        staff.add(new Employee("Tommy Tester", 40000, 1990, 3, 15));
        // staff.size()将返回staff数组列表的当前元素数量，它等价于数组a的a.length
        System.out.println("staff=:"+staff.size());
        for (Employee e : staff) {
            System.out.println("name=:" + e.getName() + ",salary=:" + e.getSalary() + ",HireDay:" + e.getHireDay());
//              System.out.println("e=:"+e.equals(boss));
            System.out.println("=:" + e.toString());
        }
    }

}
