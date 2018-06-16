package com;

import java.time.Clock;
import java.time.Instant;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;


public class hashCodeDemo {
    public static void main(String[] args) {
        String s = "Ok";
        StringBuffer sb = new StringBuffer(s);
        System.out.println("hashCode=:" + s.hashCode() + " " + sb.hashCode());
        String t = new String("OK");
        StringBuffer tb = new StringBuffer(t);
        System.out.println("hashCode=:" + t.hashCode() + " " + tb.hashCode());

        // Lambda表达式
        lambdaDemo();
        // 函数式接口
        functionalInterfaceDemo();
        // 方法与构造函数引用
        methodOrConstruction();

        // Annotation 注解
        annotationDemo();
        // Clock 时钟
        ClockDemo();

//        Consumer 接口
        Manager boss= new Manager("Car Cracker",80000,1987,12,15);
        boss.setBouns(5000);

        Employee[] staff = new Employee[3];
        staff[0]=boss;
        staff[1]=new Employee("Harry Hacker",50000,1989,10,1);
        staff[2]=new  Employee("Tommy Tester",40000,1990,3,15);

        for (Employee e:staff) {
            System.out.println("name=:" + e.getName() + ",salary=:" + e.getSalary() + ",HireDay:" + e.getHireDay());
          //  System.out.println("e=:"+e.equals(boss));
            System.out.println("=:"+e.toString());
        }
    }

    /**
     *  JDK1.8 新特性：Clock 时钟
     *  Clock类提供了访问当前日期和时间的方法，Clock是时区敏感的，可以用来
     *  取代 System.currentTimeMillis() 来获取当前的微秒数。某一个特定的时间
     *  点也可以使用Instant类来表示，Instant类也可以用来创建老的java.util.Date对象。
     */
    private static void ClockDemo() {
        Clock clock = Clock.systemDefaultZone();
        long millis = clock.millis();
        System.out.println("millis=:"+millis);
        Instant instant = clock.instant();
        System.out.println("instant=:"+instant);
    }

    /**
     * JDK1.8 新特性：Annotation 注解
     * java编译器会隐性的帮你定义好@Hints注解
     */
    private static void annotationDemo() {
        Hint hint = Person2.class.getAnnotation(Hint.class);
        System.out.println("hint=:"+hint);
//        Hints hints1 = Person2.class.getAnnotation(Hints.class);
//        System.out.println(hints1.value().length);  // 2
        Hint[] hint2 = Person2.class.getAnnotationsByType(Hint.class);
        System.out.println("hint2=:"+hint2.length);

    }

    /**
     * JDK8 新特性: 方法与构造函数引用
     * Java 8 允许你使用 :: 关键字来传递方法或者构造函数引用，下面的代码展示了
     * 如何引用一个静态方法，我们也可以引用一个对象的方法：
     */
    private static void methodOrConstruction() {
        Converter<String,Integer> converter = Integer::valueOf;
        Integer converted = converter.convert("1234");
        System.out.println("converted2=:"+converted);

        // 只需要使用 Person::new 来获取Person类构造函数的引用，
        // Java编译器会自动根据PersonFactory.create方法的签名来选择合适的构造函数。
        PersonFactory<Person> personFactory = Person::new;
        Person person = personFactory.create("Peter", "Parker");

        System.out.println("person=:"+person.firstName+" | "+person.lastName);

    }


    /**
     *  JDK8 新特性: 函数式接口
     *  Lambda表达式是如何在java的类型系统中表示的呢？每一个lambda表达式都对应一个类型，
     *  通常是接口类型。而“函数式接口” *  是指仅仅只包含一个抽象方法的接口，每一个该
     *  类型的lambda表达式都会被匹配到这个抽象方法。*  因为 默认方法 不算抽象方法，所以
     *  你也可以给你的函数式接口添加默认方法。
     */
    private static void functionalInterfaceDemo() {
        Converter<String, Integer> converter = (from) -> Integer.valueOf(from);
        Integer converted = converter.convert("123");
        System.out.println("converted=:"+converted);
    }

    /**
     * JDK8 新特性: Lambda表达式
     */
    private static void lambdaDemo() {
        List<String> names = Arrays.asList("peter", "anna", "mike", "xenia");
//        Collections.sort(names, new Comparator<String>() {
//            @Override
//            public int compare(String a, String b) {
//                return b.compareTo(a);
//            }
//        });

//        在Java 8 中你就没必要使用这种传统的匿名对象的方式了，Java 8提供了更简洁的语法，lambda表达式
//        Collections.sort(names,(String a,String b)->{
//            return b.compareTo(a);
//        });
        // 代码变得更短且更具有可读性，但是实际上还可以写得更短：
        // Collections.sort(names, (String a, String b) -> b.compareTo(a));
        // 对于函数体只有一行代码的，你可以去掉大括号{}以及return关键字，但是你还可以写得更短点：
        Collections.sort(names, (a, b) -> b.compareTo(a));

        for (String temp : names) {
            System.out.println("temp=:" + temp);
        }
    }


}
