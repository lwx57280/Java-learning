package com;

import com.com.horstman.corejava.Employee;
import static java.lang.System.*;
/**
 * 该程序演示了包的使用。
 *类的导入和静态导入
 * @see com.com.horstman.corejava#raiseSalary(double)
 */
public class packageTest {
    public static void main(String[] args){

        Employee harry = new Employee("Harry Hacker",50000,1989,10,1);
        harry.raiseSalary(5);

        // 因为静态导入语句，我们不必使用 System.out
        out.println("name=:"+harry.getName()+",salary=:"+harry.getSalary());
    }

}
