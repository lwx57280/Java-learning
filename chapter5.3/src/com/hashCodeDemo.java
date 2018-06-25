package com;

import java.util.ArrayList;

/**
 * 泛型数组列表
 *
 * List:
 * | -- Vector:内部是数组数据结构,是线程安全的。增、删、查都很慢！效率低
 * | -- ArrayList:内部是数组数据结构，是线程不安全的。替代了Vector。查询的速度很快、增删慢。
 *  ArrayList是List接口实现类，可以动态调整大小的数组。不同步，默认初始容量为10，当元素超过10个以后
 * 会重新分配内存空间，并将所有的对象从较小的数组中拷贝到较大的数组中，那么容量变化的规则是(旧容量*3)/2+1
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
