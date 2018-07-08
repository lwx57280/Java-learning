package com;

import java.util.ArrayList;

public class ObjectMain {
    public static void main(String[] args) {
        int a = 1000;
        int b = 1000;
        System.out.println(a == b);
        Integer c = 100;
        Integer d = 100;
        System.out.println(c == d);
        System.out.println(c.equals(d));

        ArrayList<Integer> squares = new ArrayList<>();
        for (int i = 1; i <= 5; i++)
            squares.add(i * i);
        System.out.println(new ObjectAnalyzer().toString(squares));
    }
}
