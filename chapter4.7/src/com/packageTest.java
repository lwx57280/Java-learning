package com;

import com.com.horstman.corejava.Employee;

import static java.lang.System.*;

/**
 * @Description: 该程序演示了包的使用。
 * 类的导入和静态导入
 * @Author: yc
 * @CreateDate: 2018/5/7 22:51
 * @UpdateUser: yc
 * @UpdateDate: 2018/5/7 22:51
 * @UpdateRemark: 修改内容
 * @Version: 1.0
 */
public class packageTest {

    public static void main(String[] args) {

        Employee harry = new Employee("Harry Hacker", 50000, 1989, 10, 1);
        harry.raiseSalary(5);
        Boolean aTrue=Boolean.TRUE;
        out.println("aTrue=:"+aTrue);
        // 因为静态导入语句，我们不必使用 System.out
        out.println("name=:" + harry.getName() + ",salary=:" + harry.getSalary());
    }

}
