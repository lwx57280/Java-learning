package com;


import java.lang.reflect.Field;
import java.util.*;

public class sortMapDemo {
    public static void main(String[] args) {
        Map<Integer, Person> map = initMap();

        Map<Integer, Person> personMap = sortMap(map, true);
        System.out.println("升序:");
        show(personMap);

        Map<Integer, Person> personMap1 = sortMap(map, false);
        System.out.println("倒序:");
        show(personMap1);
    }

    /**
     * 初始化一个无序Map集合
     *
     * @return
     */
    private static Map<Integer, Person> initMap() {
        Person zhangsan = new Person("张三", 20);
        Person lisi = new Person("李四", 30);
        Person wangliuOne = new Person("王六", 10);
        Person wangliuTwo = new Person("王六", 10);
        Person xiaoqiangOne = new Person("小强", 15);
        Person xiaoqiangTwo = new Person("小强", 15);

        Map<Integer, Person> map = new HashMap<>();
        map.put(2, wangliuTwo);
        map.put(5, xiaoqiangTwo);
        map.put(4, xiaoqiangOne);
        map.put(3, wangliuTwo);
        map.put(1, wangliuOne);
        map.put(7, lisi);
        map.put(6, zhangsan);
        return map;
    }


    private static void show(Map<Integer, Person> personMap) {

        for (Map.Entry<Integer, Person> entry : personMap.entrySet()) {
            Integer key = entry.getKey();
            Person person = personMap.get(key);
            System.out.println("key=:" + key + ",name=:" + person.getName() + ",age=:" + person.getAge());
        }
    }

    /**
     * Map排序
     *
     * @param origMap 待排序
     * @param isDesc  是否倒序
     * @param <K>
     * @param <V>
     * @return 有序
     */
    public static <K, V> Map<K, V> sortMap(Map<? extends Integer, V> origMap, final boolean isDesc) {

        if (origMap == null || origMap.isEmpty()) {
            return null;
        }
        if (isDesc) {
            Map<Integer, V> sortTempMap = new TreeMap<Integer, V>(new Comparator<Integer>() {
                @Override
                public int compare(Integer key1, Integer key2) {
                    return key1.compareTo(key2);
                }
            });
            sortTempMap.putAll(origMap);
            return (Map<K, V>) sortTempMap;
        } else {
            Map<Integer, V> sortTempMap = new TreeMap<Integer, V>(new Comparator<Integer>() {
                @Override
                public int compare(Integer key1, Integer key2) {
                    return key2.compareTo(key1);
                }
            });
            sortTempMap.putAll(origMap);
            return (Map<K, V>) sortTempMap;
        }
    }
    static class Person {

        private String name;
        private int age;

        public Person() {
        }

        public Person(String name, int age) {
            this.name = name;
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }
    }

}
