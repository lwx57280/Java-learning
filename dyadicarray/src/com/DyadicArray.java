package com;

import staticsandinstance.VarianTest;

/**
 * 二维数组
 */
public class DyadicArray {
    public static void main(String[] args){
        //每创建一个实例对象，就会分配一个instanceVar，即可能分配多个instanceVar，
        // 并且每个instanceVar的值都只自加了1次。

        VarianTest test = new VarianTest();
        VarianTest test1 = new VarianTest();

        //通常并不使用标号这种方式，而是让外层的循环条件表达式的结果可以受到里层循环体代码的控制
        int arr[][]={{1,2,3},{4,5,6,7},{7,8,9}};
        boolean found =false;

        for (int i=0;i<arr.length && !found;i++){
            for(int j=0;j<arr[i].length;j++){
                System.out.println("i="+i+",j="+j);
                if(arr[i][j]==5){
                    found =true;
                    break;
                }
            }
        }
    }
}
