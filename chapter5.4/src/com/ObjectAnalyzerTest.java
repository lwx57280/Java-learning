package com;

import org.omg.CORBA.IntHolder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 对象包装器和自动装箱
 */
public class ObjectAnalyzerTest {
    public static void main(String[] args) {
        List<Integer> squares = new ArrayList<>();
        for (int i = 1; i <= 5; i++) {
            squares.add(i * i);
        }
        // 自动装箱 squares.add(Integer.valueOf(10));
        squares.add(10);
        System.out.println(squares.size());

        System.out.println(Arrays.toString(squares.toArray()));
        for (int i = 0; i < squares.size(); i++) {
            // 自动拆箱 int num = ((Integer)squares.get(i)).intValue();
            int num = squares.get(i);
            System.out.println("num=:" + num);
            break;
        }
        // System.out.println(new ObjectAnalyzer().toString(squares));

        int a = 8;
        triple(a);
//        System.out.printf("%d %s",a,"widgets");

        Integer x = 100;
        tripleInteger(x);

        IntHolder t = new IntHolder(9);
        change(t);
    }

    public static void triple(int x) {
        // 修改局部变量
        x = Integer.valueOf(3) * x;
        System.out.println("x=:" + x);
    }

    public static void tripleInteger(Integer x) {
        // 修改局部变量
        x = 3 * x;
        System.out.println("x=:" + x);
    }

    public static void change(IntHolder x) {
        // 每个持有者类型都包含一个共有域值
        x.value = 3 * x.value;
        System.out.println("x=:" + x.value);
    }
}
