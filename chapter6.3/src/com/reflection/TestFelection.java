package com.reflection;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * 反射动态获取类的父类和实现的接口，内部类、构造、方法、属性,取属性值，设置属性值
 */
public class TestFelection {
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException, InvocationTargetException {
        String str = "com.reflection.T";
        Class<?> c = Class.forName(str);
        Object o = c.newInstance();
        Method[] methods = c.getMethods();
        for (Method method : methods) {
            if (method.getName().equals("mm")) {
                method.invoke(o);
            }
            if (method.getName().equals("m1")) {
                method.invoke(o, 1, 2);
                // 返回一个 类对象的数组， 类以声明顺序表示由该对象方法的形参参数类型。
                for (Class paramType:method.getParameterTypes()){
                    System.out.println(paramType.getName());
                }
            }
            if(method.getName().equals("getS")){
                // 返回一个 类对象
                Class<?> returnType = method.getReturnType();
                //  方法对象表示的方法的名称
                System.out.println(returnType.getName());
            }
        }
    }
}

class T {

    int i;
    String s;

    static {
        System.out.println("T loaded!");
    }

    public T() {
        System.out.println("T constructed!");
    }

    public void m1(int i, int j) {
        this.i = i + j;
        System.out.println(this.i);
    }

    public void mm() {
        System.out.println("mm invoked!");
    }

    public String getS() {
        return s;
    }
}
