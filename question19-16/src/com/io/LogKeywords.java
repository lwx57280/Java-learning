package com.io;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

/**
 * 阿里初试笔试题
 * 根据关键字读取日志文件，按出现次数排序打印关键字
 */
public class LogKeywords {
    public static void main(String[] args) throws IOException {


        BufferedReader bufReader = new BufferedReader(new FileReader("question19-16/share.log"));
        System.out.println("请输入关键字：（以空格为间隔，并且关键词不能包含`符号）");
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        String[] keywords = input.split(" ");

        long start = System.currentTimeMillis();

        // 该map的key为关键字，value为关键字出现次数
        Map<String, Integer> strMap = new HashMap<>();
        String result =null;
        System.out.println(Arrays.toString(keywords));
        // 按行读取日志文件，对每一行分别计算关键字次数，累加进map
        while ((result = bufReader.readLine()) != null) {
            result += "`";
            for (int i = 0; i < keywords.length; i++) {
                //通过split方法实现搜索关键字次数功能
                int count = (result.split(keywords[i])).length - 1;
                strMap.put(keywords[i], strMap.get(keywords[i]) == null ? count : (strMap.get(keywords[i]) + count));
            }
        }

        // 将上面map的每个Entry存入list
        ArrayList<Map.Entry<String,Integer>> entryArrayList = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : strMap.entrySet()) {
            entryArrayList.add(entry);
        }
        // 自定义list的比较器，根据value从大到小排列Entry元素
        Collections.sort(entryArrayList, (o1, o2) -> o2.getValue() - o1.getValue());
        // java8版本
        entryArrayList.forEach(strInEntry -> System.out.println(strInEntry.getKey() + "-->" + strInEntry.getValue()));
        long end = System.currentTimeMillis();
        System.out.println("搜索耗时：" + (end - start) + " ms");
    }
}
