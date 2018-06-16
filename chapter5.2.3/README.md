# Java-learning

JDK1.8新特性
-----------
    Lambda表达式:
     在Java 8 中你就没必要使用这种传统的匿名对象的方式了，Java 8提供了更简洁的语法，lambda表达式
           Collections.sort(names,(String a,String b)->{
               return b.compareTo(a);
           });
           
           // 代码变得更短且更具有可读性，但是实际上还可以写得更短：
                Collections.sort(names, (String a, String b) -> b.compareTo(a));
           
           // 对于函数体只有一行代码的，你可以去掉大括号{}以及return关键字，但是你还可以写得更短点：
                Collections.sort(names, (a, b) -> b.compareTo(a));
     
     函数式接口:
             *  Lambda表达式是如何在java的类型系统中表示的呢？每一个lambda表达式都对应一个类型，
             *  通常是接口类型。而“函数式接口” *  是指仅仅只包含一个抽象方法的接口，每一个该
             *  类型的lambda表达式都会被匹配到这个抽象方法。*  因为 默认方法 不算抽象方法，所以
             *  你也可以给你的函数式接口添加默认方法。
            
             private static void functionalInterfaceDemo() {
                Converter<String, Integer> converter = (from) -> Integer.valueOf(from);
                Integer converted = converter.convert("123");
                System.out.println("converted=:"+converted);
             }
      
      方法与构造函数引用:
             * Java 8 允许你使用 :: 关键字来传递方法或者构造函数引用，下面的代码展示了
             * 如何引用一个静态方法，我们也可以引用一个对象的方法：
             
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
      