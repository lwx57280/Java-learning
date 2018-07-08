package com;

/**
 *
 * 二分查找法。必须有前提：数组中的元素要有序。
 */
public class BinaryArray {
    public static void main(String[] args) {
        int[] arry = {10, 11, 12, 13, 14, 15, 16, 17};
        int num = halSearch(arry, 15);
        System.out.println("num=:" + num);
    }

    public static int halSearch(int[] arry, int key) {
        int min = 0, max, mid;
        max = arry.length - 1;
        mid = (max + min) >> 1;
        while (arry[mid] != key) {
            if (key > arry[mid]) {
                min = mid + 1;
            } else if (key < arry[mid])
                max = mid - 1;
            if (max < mid)
                return -1;
            mid = (max + min) >> 1;
        }
        return mid;
    }


}
