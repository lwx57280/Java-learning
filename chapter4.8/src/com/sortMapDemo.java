package com;


import java.util.*;

public class sortMapDemo {
    public static void main(String[] args) {
        Map<Integer, Person> map = initMap();
        //show(map);
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
        Person zhangsan = new Person(2, "张三", 20);
        Person lisi = new Person(5, "李四", 30);
        Person wangliuOne = new Person(4, "王六", 10);
        Person wangliuTwo = new Person(3, "王六", 10);
        Person xiaoqiangOne = new Person(1, "小强", 15);
        Person xiaoqiangTwo = new Person(11, "小强", 15);
        Person xiongda = new Person(13, "熊大", 25);

        Map<Integer, Person> map = new HashMap<>();
        map.put(wangliuTwo.getId(), wangliuTwo);
        map.put(xiaoqiangTwo.getId(), xiaoqiangTwo);
        map.put(xiaoqiangOne.getId(), xiaoqiangOne);
        map.put(wangliuOne.getId(), wangliuOne);
        map.put(lisi.getId(), lisi);
        map.put(zhangsan.getId(), zhangsan);
        map.put(xiongda.getId(), xiongda);
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
        Map<K,V> sortedMap = new LinkedHashMap<>();

        if (origMap == null || origMap.isEmpty()) {
            return null;
        }
        //if (isDesc) {
        List<Map.Entry<? extends Integer, V>> arrayList = new ArrayList<>(origMap.entrySet());
        Collections.sort(arrayList, new Comparator<Map.Entry<? extends Integer, V>>() {
            @Override
            public int compare(Map.Entry<? extends Integer, V> o1, Map.Entry<? extends Integer, V> o2) {
                int key1 = 0, key2 = 0;
                try {
                    key1 = o1.getKey();
                    key2 = o2.getKey();
                } catch (NumberFormatException e) {
                    key1 = 0;
                    key2 = 0;
                }
                return isDesc == true ? key1 - key2 : key2 - key1;
            }
        });
        Iterator<Map.Entry<? extends Integer, V>> iterator = arrayList.iterator();
        Map.Entry<? extends Integer, V> tempEntry = null;
        while (iterator.hasNext()){
            tempEntry = iterator.next();
            K key =(K) tempEntry.getKey();
            sortedMap.put(key,tempEntry.getValue());
        }
        return sortedMap;
        // 数据是用TreeMap存储的
//        sortTempMap.putAll(origMap);
//        return (Map<K, V>) sortTempMap;
//        } else {
//            Map<Integer, V> sortTempMap = new TreeMap<Integer, V>(new Comparator<Integer>() {
//                @Override
//                public int compare(Integer key1, Integer key2) {
//                    return key2.compareTo(key1);
//                }
//            });
//            sortTempMap.putAll(origMap);
//            return (Map<K, V>) sortTempMap;
//        }
    }

    static class Person {

        private Integer id;

        private String name;

        private Integer age;

        public Person() {
        }

        public Person(Integer id, String name, Integer age) {
            this.id = id;
            this.name = name;
            this.age = age;
        }

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Integer getAge() {
            return age;
        }

        public void setAge(Integer age) {
            this.age = age;
        }
    }
}
