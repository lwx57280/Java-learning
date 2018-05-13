package com;

public class Dome {

    public static void main(String[] args) {

        final double CM_PER_INCH = 2.54;
        int x = 100;
        double paperWidth = 8.5;
        double paperHeight = 11;
//        int result =x
        System.out.println("Paper size in centimeters:" + paperWidth * CM_PER_INCH + " by " + paperHeight * CM_PER_INCH);
    }
}
