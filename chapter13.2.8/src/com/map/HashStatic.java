package com.map;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class HashStatic {

    private static int x = 100;

    public static void main(String[] args) {
        HashStatic hashStatic = new HashStatic();
        hashStatic.x++;
        HashStatic hs2 = new HashStatic();
        hs2.x++;
        hashStatic = new HashStatic();

        hashStatic.x++;
        HashStatic.x--;
        System.out.println("x="+x);

        List<String> strings = Arrays.asList("Amy", "Bob", "Carl");

    }
}
