package com.set;

import java.util.*;

/**
 * 算列集 树集 TreeSet可以自动的对元素进行排序
 * <p>
 * 这个程序使用一个集合来打印系统中所有唯一的单词。
 */
public class SetTest {
    public static void main(String[] args) {
        //setAdd();
        SortedSet<String> sorter = new TreeSet<>();
        sorter.add("Bob");
        sorter.add("Amy");
        sorter.add("Carl");

        for(String s:sorter){
            System.out.println(s);
        }
    }

    private static void setAdd() {
        Set<String> words = new HashSet<>();
        long totalTime = 0;
        Scanner in = new Scanner(System.in);

        while (in.hasNext()) {
            String word = in.next();
            long callTime = System.currentTimeMillis();
            words.add(word);
            callTime = System.currentTimeMillis() - callTime;
            totalTime += callTime;
        }
        Iterator<String> iter = words.iterator();
        for (int i = 1; i <= 20 && iter.hasNext(); i++) {
            System.out.println(iter.next());
            System.out.println("....");
            System.out.println(words.size() + "distinct words " + totalTime + "milliseconds");
        }
    }
}
