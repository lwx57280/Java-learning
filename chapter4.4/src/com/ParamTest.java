package com;

public class ParamTest {
    public static void main(String[] args) {

        // Test1:方法不能修改数值参数
        System.out.println("Testing tripleValue:");
        double percent = 10;
        System.out.println("Before:percent=" + percent);
        tripleValue(percent);
        System.out.println("After :percent=" + percent);

        // Test2:方法可以更改对象参数的状态。
        System.out.println("\nTesting tripleSalary:");
        Employee harry = new Employee("Harry", 50000);
        System.out.println("Before :salary=" + harry.getSalary());
        tripleSalary(harry);
        System.out.println("After :salary=" + harry.getSalary());

        // Test3:方法无法将新对象附加到对象参数
        System.out.println("\nTesting swap:");
        Employee a = new Employee("Alice", 70000);
        Employee b = new Employee("Bob", 60000);
        System.out.println("Before :a=" + a.getName());
        System.out.println("Before :b=" + b.getName());
        swap(a, b);
        System.out.println("After :a=" + a.getName());
        System.out.println("After :b=" + b.getName());

    }

    private static void swap(Employee x, Employee y) {
        Employee temp = x;
        x = y;
        y = temp;
        System.out.println("End of method :x="+x.getName());
        System.out.println("End of method :y="+y.getName());
    }

    /**
     * works
     *
     * @param harry
     */
    private static void tripleSalary(Employee x) {
        x.raiseSalary(200);
        System.out.println("End of method :salary=" + x.getSalary());
    }

    /**
     * 还是不工作
     *
     * @param percent
     */
    private static void tripleValue(double percent) {
        percent = 3 * percent;
        System.out.println("End of method: percent=" + percent);
    }
}
