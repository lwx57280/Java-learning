package com;
/**
* @Description:     继承层次
* @Author:         yc
* @CreateDate:     2018/5/13 19:21
* @UpdateUser:     yc
* @UpdateDate:     2018/5/13 19:21
* @UpdateRemark:   修改内容
* @Version:        1.0
*/
public class ManagerTest {
    public static void main(String[] args){
        Manager boss= new Manager("Car Cracker",80000,1987,12,15);
        boss.setBouns(5000);

        Employee[] staff = new Employee[3];
        staff[0]=boss;
        staff[1]=new Employee("Harry Hacker",50000,1989,10,1);
        staff[2]=new  Employee("Tommy Tester",40000,1990,3,15);

        for (Employee e:staff)
            System.out.println("name=:"+e.getName()+",salary=:"+e.getSalary());


    }
}
