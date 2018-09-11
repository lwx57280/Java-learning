package com.priorityqueue;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.PriorityQueue;

/**
 * 优先级队列
 */
public class PriorityQueueTest {

    public static void main(String[] args) {
        PriorityQueue<GregorianCalendar> pg = new PriorityQueue<>();
        pg.add(new GregorianCalendar(1960, Calendar.DECEMBER, 9));
        pg.add(new GregorianCalendar(1815, Calendar.DECEMBER, 10));
        pg.add(new GregorianCalendar(1930, Calendar.DECEMBER, 3));
        pg.add(new GregorianCalendar(1910, Calendar.JUNE, 22));

        System.out.println("Iterating over elements");
        for (GregorianCalendar date : pg) {
            System.out.println(date.get(Calendar.YEAR));
        }
        System.out.println(pg.size());
        System.out.println("Removing elements");
        while (!pg.isEmpty())
            System.out.println(pg.remove().get(Calendar.YEAR));

            System.out.println(pg.size());
    }
}
