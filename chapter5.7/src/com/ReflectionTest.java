package com;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Scanner;

/**
 * 异常捕获
 *
 * 一、什么是反射?
 * 通过类说明可以得到这个类的父类、实现的所有接口、内部类、方法、
 * 构造、属性，可以通过构造实例化对象、唤起方法、取属性值，
 * 设置属性值。
 */
public class ReflectionTest {
    public static void main(String[] args) {

        String name;
        if (args.length > 0)
            name = args[0];
        else {
            Scanner in = new Scanner(System.in);
            System.out.println("Enter class name (e.g java.util.Date");
            name = in.next();
        }
        try {
            // 打印类名和超类名称
            Class clazz = Class.forName(name);
            Class superz = clazz.getSuperclass();
            String modifiers = Modifier.toString(clazz.getModifiers());
            if (modifiers.length() > 0)
                System.out.println(modifiers + " ");
            System.out.println("class=:" + name);
            if (superz != null && superz != Object.class)
                System.out.println("extends " + superz.getName());
            System.out.println("\n{\n");
            printConstructors(clazz);
            System.out.println();
            printMethods(clazz);
            System.out.println();
            printFields(clazz);
            System.out.println("}");

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        System.exit(0);
    }

    /**
     * 打印类的所有字段
     *
     * @param clazz
     */
    private static void printFields(Class clazz) {
        Field[] fields = clazz.getDeclaredFields();
        for (Field f : fields) {
            Class<?> type = f.getType();
            String name = f.getName();
            System.out.println(" ");
            String modifiers = Modifier.toString(f.getModifiers());
            if (modifiers.length() > 0)
                System.out.println(modifiers + " ");
            System.out.println(type.getName() + "" + name + ";");
        }
    }

    /**
     * 打印类的所有方法
     *
     * @param clazz
     */
    private static void printMethods(Class clazz) {
        Method[] methods = clazz.getDeclaredMethods();
        for (Method m : methods) {
            Class<?> returnType = m.getReturnType();
            String name = m.getName();
            System.out.println(" ");
            // 打印修饰符、返回类型和方法名称
            String modifiers = Modifier.toString(m.getModifiers());
            if (modifiers.length() > 0)
                System.out.println(modifiers + " ");
            System.out.println(returnType.getName() + " " + name + "(");
            // 定义参数类型
            Class<?>[] paramTypes = m.getParameterTypes();
            for (int i = 0; i < paramTypes.length; i++) {
                if (i > 0)
                    System.out.println(",");
                System.out.println(paramTypes[i].getName());
            }
            System.out.println(");");
        }
    }

    /**
     * 打印类的所有构造函数。
     *
     * @param clazz
     */
    private static void printConstructors(Class clazz) {
        Constructor[] constructors = clazz.getDeclaredConstructors();
        for (Constructor c : constructors) {
            String name = c.getName();
            System.out.println(" ");
            String modifier = Modifier.toString(c.getModifiers());
            if (modifier.length() > 0)
                System.out.println(" ");
            System.out.println(name + "(");
//            打印参数类型
            Class[] parameterTypes = c.getParameterTypes();
            for (int j = 0; j < parameterTypes.length; j++) {
                if (j > 0) {
                    System.out.println(",");
                }
                System.out.println(parameterTypes[j].getName());
            }
            System.out.println(");");
        }
    }
}
