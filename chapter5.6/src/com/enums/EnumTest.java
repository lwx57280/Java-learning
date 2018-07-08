package com.enums;

import java.util.Scanner;

/**
 * 枚举类
 */
public class EnumTest {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.println("Enter a size:(SMALL, MEDIUM,LARGE, EXTRA_LARGE)");
        String input = in.next().toUpperCase();
        SizeEnum size = Enum.valueOf(SizeEnum.class, input);
        System.out.println("size=:" + size);
        System.out.println("abbreviation=:" + size.getAbbreviation());
        if (size == SizeEnum.EXTRA_LARGE) {
            System.out.println("Good job -- you paid attention to the");
        }
        System.out.println("="+SizeEnum.LARGE.toString());

        for (SizeEnum value:SizeEnum.values()){
            System.out.println("value=:"+value.name());
        }
        // ordinal方法返回enum声明中枚举常量的位置，位置从0开始计数。
        int ordinal = SizeEnum.MEDIUM.ordinal();
        System.out.println("ordinal=:"+ordinal);
    }
}
