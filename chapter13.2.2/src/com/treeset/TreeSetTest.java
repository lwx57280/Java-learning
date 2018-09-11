package com.treeset;

import java.util.Comparator;
import java.util.SortedSet;
import java.util.TreeSet;

/**
 * 这个Item通过比较对一组Item进行排序。
 */
public class TreeSetTest {
    public static void main(String[] args) {
        SortedSet<Item> parts = new TreeSet<>();
        parts.add(new Item("Toaster", 1234));
        parts.add(new Item("Widget", 4562));
        parts.add(new Item("Modem", 9912));
        System.out.println(parts);

        SortedSet<Item> sortByDescription = new TreeSet<>(new Comparator<Item>() {
            @Override
            public int compare(Item o1, Item o2) {
                String descA = o1.getDescription();
                String descB = o2.getDescription();
                return descA.compareTo(descB);
            }
        });
        sortByDescription.addAll(parts);
        System.out.println(sortByDescription);
    }
}
