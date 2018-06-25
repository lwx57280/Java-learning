java反射详解
-----------------
>一、什么是反射?
	通过类说明可以得到这个类的父类、实现的所的接口、内部类、方法、
	构造、属性，可以通过构造实例化对象、唤起方法、取属性值，
	设置属性值。

>java反射机制的作用

    1)在运行时判断任意一个对象所属的类。
    
    2) 在运行时判断任意一个对象所具有的成员变量和方法。
    
    3) 在运行时任意调用一个对象的方法。
    
    4) 在运行时构造任意一个类的对象
    
>二、得到所有构造并实例化对象？

    Class clazz = Class.forName("vo.Customer");
    // 得到所有的构造
    Constructor[] constrs = clazz.getConstructors();
    // 得到一个构造
    Constructor cons = getConstructor(new Class[]{String.class,String.class});
    
    Object obj = cons.newInstance(new Object[]{"张三","1234"});
    
>四、得到所的有方法并唤起方法?
    
    // 得到所有的方法
    Method methods[] = clazz.getMethods();
    // 得到一个方法
    Method setCustomerName = clazz.getMethod("setCustomerName",new Class[]{String.class});
    // 调用默认的构造子实例化得到一个对象
    Object customer=cus_cls.newInstance();
    setCustomerName.invoke(customer,new Object[]{"张三"});
   
>五、得到所有的属性，取属性值，设置属性值?
    
    // 得到所有的属性
    Field fields[] = clazz.getFields();
    // 得到一个属性
    Field customerName = clazz.getField("customerName");
    customerName.set(customer,"张三");
    customerName.get(customer);