package com;

import java.io.Serializable;
import java.util.*;

public class Main {
    /**
     * 按照此顺序排序：{"1:小明","2:小强","3:小志","4:小华","5:小红"}
     *
     * @param args
     */
    public static void main(String[] args) {
        String[] array = {"5:小红", "1:小明", "3:小志", "2:小强", "4:小华"};
        System.out.println("array=:" + Arrays.toString(array));
        Map<Integer, String> map = new HashMap<>();
        for (String temp : array) {
            String[] tem = temp.split(":");
            map.put(Integer.parseInt(tem[0]), tem[1]);
        }
        Set<Integer> keySet = map.keySet();
        Iterator<Integer> it = keySet.iterator();
        while (it.hasNext()) {
            Integer key = it.next();
            String value = map.get(key);
            System.out.println(key + "-" + value);
        }

        int[] luckyNumbers = {2, 3, 5, 7, 11, 13};
        // 调用静态方法Arrays.toString()将生成字符串
        String s = Arrays.toString(luckyNumbers);
        System.out.println(s);

        int[][] arr = {{1, 2, 3}, {4, 5, 6, 7}, {7, 8, 9}};
        // 要想打印多维（即，数组的数组）则需要调用Arrays.deepToString();方法
        String deep = Arrays.deepToString(arr);
        System.out.println("deep=:" + deep);
        System.out.println(System.out);
    }
}
