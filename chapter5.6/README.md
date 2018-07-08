# java 枚举

    所有的枚举类型都是Enum类的子类。它们继承了这个类的许多方法。其中最有用的一个是toString，
    这个方法能够返回枚举常量名。
    
        例如：SizeEnum.LARGE.toString()将返回字符串“LARGE”。
        toString的逆方法是静态的valueOf。例如，语句：
        SizeEnum size = Enum.valueOf(SizeEnum.class, “LARGE”);
        将l设置SizeEnum.LARGE。
       	每个枚举类型都有一个静态的values方法，它将返回一个包含全部枚举值的数组。
       	
       	例如，如下调用
       	SizeEnum[] value =SizeEnum.values();
       	
       	返回包含元素 SizeEnum.SMALL,SizeEnum.MEDIUM,SizeEnum.LARGE,SizeEnum.EXTRA_LARGE的数组。
       	
       	ordinal方法返回enum声明中枚举常量的位置，位置从0开始计数。