package com;

import java.io.Console;
import java.util.Scanner;

public class strDemo {

    public static void main(String[] args) {
        //print();
        //连接
//        concat();

        strBuilderDemo();

        demoInput();
    }

    private static void concat() {
        // 拼接
        String expletive = "Expletvie";
        String PG13 = "deleted";
        String message = expletive + PG13;
        System.out.println("message=:" + message);

        int age = 13;
        String rating = "PG" + age;
        System.out.println("rating=:" + rating);
    }

    private static void print() {
        String greeting = "Hello ";
        System.out.println("greeting长度=:" + greeting.length());
        // 字符串中下标从0开始计算直到下标结束位置,不包含结束位置将所有在此字符 String使用默认语言环境的规则，以小写。
        // greeting = greeting.substring(0, greeting.length() - 1);

        System.out.println("s=:" + greeting.length());
        System.out.println("s=:" + greeting);
        // 首先提取需要的字符串，然后再拼接上替换的字符串
        /*String temp = greeting.substring(0, 3) + "p!";
        System.out.println("temp=:"+temp);*/
        // 不可变字符串有一个优点：编译器可以让字符串共享

        // 获取指定文本范围内的Unicode代码点数。
//        int cpCount =greeting.codePointCount(0,greeting.length());
//        System.out.println("cpCount=:"+cpCount);

//        返回 char指定索引处的值。
        char first = greeting.charAt(0);
        char last = greeting.charAt(3);
        System.out.println("first=:" + first);
        System.out.println("last=:" + last);
        System.out.println("greeting=:" + greeting);

        int i = 2;
        int index = greeting.offsetByCodePoints(0, i);
        int cp = greeting.codePointAt(index);
        System.out.println("cp=:" + cp);
        System.out.println("greeting=:" + greeting.indexOf("H"));
//        返回指定字符的最后一次出现的字符串中的索引。
        System.out.println("lastIndex=:" + greeting.lastIndexOf("l"));
//        返回指定字符的最后一次出现的字符串中的索引，从指定的索引开始向后搜索。
        System.out.println("lastIndex2=:" + greeting.lastIndexOf(0, i));
//        将所有在此字符 String使用默认语言环境的规则，以小写。
        System.out.println("lowerCase=:" + greeting.toLowerCase());
        int length = greeting.length();
        System.out.println("greeting长度=:" +length);
        System.out.println("lowerCase=:" + greeting.trim());
        System.out.println("greeting长度=:" + greeting.length());
    }

    private static void strBuilderDemo(){
        StringBuffer buffer= new StringBuffer();
        buffer.append("dd");
        buffer.append("-abc");
        String s = buffer.toString();
        System.out.println("s=:"+s);

        StringBuilder builder = new StringBuilder();
        builder.append("ch");
        builder.append("str");


        builder.insert(1,"demo");
        String commleted = builder.toString();
        System.out.println("commleted=:"+commleted);

    }

    private static void demoInput(){
        Scanner in = new Scanner(System.in);
        System.out.println("What is your name?");
        String name = in.nextLine();
        System.out.println("name+:"+name);
        System.out.println("How old are you?");
        int age = in.nextInt();
        System.out.println("age=:"+age);

        display(name,age);
    }

    private static void display(String name,int age){

        System.out.println("Hello,"+name+". Next year ,you'11 be "+(age+1));
    }
}
