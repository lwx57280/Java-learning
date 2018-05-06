package com;

/**
 * 构造器、无参数构造器、对象初始化块、静态初始化快、实例域初始快
 */
public class ConstructorTest {
    public static void main(String[] args){
        //    用三个Employee对象填充Staff数组
        Employee[] staff = new Employee[3];
        staff[0]=new Employee("Harry",40000);
        staff[1]=new Employee(60000);
        staff[2]=new Employee();
        //打印有关所有雇员对象的信息
        for(Employee e:staff)
            System.out.println("name=:"+e.getName()+",id=:"+e.getId()+",salary=:"+e.getSalary());

    }
}
