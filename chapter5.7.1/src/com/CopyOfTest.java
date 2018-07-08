package com;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * 使用反射编写泛型数组
 */
public class CopyOfTest {
    public static void main(String[] args) {

        int[] a = {1, 2, 3};
        a = (int[]) goodCopyOf(a, 10);
        System.out.println(Arrays.toString(a));

        String[] b = {"Tom", "Dick", "Harry"};
        b = (String[]) goodCopyOf(b, 10);
        System.out.println(Arrays.toString(b));

//        System.out.println("下面的调用将生成一个异常");
//
//        b = (String[])goodCopyOf(b,10);
    }

    /**
     * 此方法试图通过分配新数组并复制所有元素来增长数组。
     *
     * @param a
     * @param newLength
     * @return
     */
    public static Object[] badCopyOf(Object[] a, int newLength) {
        Object[] newArray = new Object[newLength];
        System.arraycopy(a, 0, newArray, 0, Math.min(a.length, newLength));
        return newArray;
    }

    /**
     * 此方法通过分配相同类型的新数组并复制所有元素来增长数组。
     *
     * @param a
     * @param newLength
     * @return
     */
    public static Object goodCopyOf(Object a, int newLength) {
        Class cl = a.getClass();
        // 确定此 类对象是否表示数组类。
        if (!cl.isArray()) {
            return null;
        }
        Class componentType = cl.getComponentType();
        // 返回指定数组对象的长度，如 int 。
        int length = Array.getLength(a);
        // 返回一个具有给定类型、给定位数的新数组
        Object newArray = Array.newInstance(componentType, newLength);
        // 将指定源数组中的数组从指定位置复制到目标数组的指定位置。
        System.arraycopy(a, 0, newArray, 0, Math.min(length, newLength));
        return newArray;
    }
}
