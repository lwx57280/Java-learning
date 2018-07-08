package com;

/**
 * 数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。
 */
public class arryDemo {


    public static void main(String[] args) {
        int[] arr1 = {0, 1, 2};          // 统计出现次数返回-1
        int[] arr2 = {0, 1, 2, 1};       // 统计元素出现一半返回1
        int[] arr = {0, 1, 2, 1, 1};     // 统计数组元素3个相等的返回-1

        System.out.println(find(arr1));

    }

    private static int find(int[] arr) {
        int length = arr.length;
        if (length == 0) {
            return 0;
        }
        int num = arr[0], count = 1;
        for (int i = 0; i < length; i++) {
            if (arr[i] == num) {
                count++;
            } else {
                count--;
            }
            if (count == arr[i]) {
                num = arr[i];
                count = 1;
            }
        }
        count = 0;
        for (int i = 0; i < length; i++) {
            if (arr[i] == num) {
                count++;
            }
        }
        if (count * 2 > length)
            return num;
        return 0;
    }
}
