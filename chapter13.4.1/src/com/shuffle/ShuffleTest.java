package com.shuffle;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * 随机洗牌和排序算法
 */
public class ShuffleTest {
    public static void main(String[] args) {
        List<Integer> numbers = new ArrayList<>();
        for(int i=0;i<=49;i++)
            numbers.add(i);
        // 随机打乱列表
        Collections.shuffle(numbers);
        System.out.println(numbers);
        // 从打乱后的列表中选前6个值
        List<Integer> winningCombination = numbers.subList(0, 6);
        Collections.sort(winningCombination);
        System.out.println(winningCombination);

        // 逆序排序
        Comparator cmp = Collections.reverseOrder();
        Collections.sort(winningCombination,cmp);
        System.out.println("cmp="+winningCombination);

        // 正序排列
        Comparator cmp2 = Collections.reverseOrder(cmp);
        Collections.sort(winningCombination,cmp2);
        System.out.println("cmp2="+winningCombination);
    }
}
