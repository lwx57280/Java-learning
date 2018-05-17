package com;

import java.util.*;

/**
 * Title: dict <br/>
 * <p>
 * Description: <br/>
 *
 * @author jxzhang
 * @DATE 2018年05月15日 20:52
 * @Verdion 1.0 版本
 * ${tags}
 */
public class CompareTest {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("第三天","第二天", "第二天", "第一天", "第三天","第一天");

        Collections.sort(list, new DaySort());

        for (String rs : list) {
            System.out.println(rs);
        }
    }

    static class DaySort implements Comparator {

        private Map<String, Integer> baseRule = new HashMap<>();

        public DaySort() {
            baseRule.put("第一天", 1);
            baseRule.put("第二天", 2);
            baseRule.put("第三天", 3);
        }

        @Override
        public int compare(Object o1, Object o2) {
            Integer a = baseRule.get((String) o1);
            Integer b = baseRule.get((String) o2);
            if (a < b) {
                return -1;
            } else if (a > b) {
                return 1;
            } else {
                return 0;
            }
        }
    }
}
