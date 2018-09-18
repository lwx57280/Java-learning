package com.map;

import com.domain.Employee;

import java.util.HashMap;
import java.util.Map;

/**
 * Map映射表
 */
public class MapTest {

    public static void main(String[] args) {
        Map<String, Employee> staff = new HashMap<>();
        staff.put("144-25-5464", new Employee("Amy Lee"));
        staff.put("567-24-2564", new Employee("Harry Hacker"));
        staff.put("157-62-7934", new Employee("Gary Cooper"));
        staff.put("456-62-5527", new Employee("Francesca Cruz"));

        System.out.println("===================");
        foreachEmp(staff);
        // 删除一个条目
        staff.remove("567-24-2564");
        staff.put("456-62-5527", new Employee("Francesca Miller"));
        staff.put(null, null);

        // 查值
        System.out.println(staff.get("157-62-7934"));
        foreachEmp(staff);
        System.out.println(staff.containsKey("157-62-7934"));
        System.out.println(staff.containsValue(staff.get("157-62-7934")));
        System.out.println(staff.containsKey(staff.get("157-62-7934")));

    }

    private static void foreachEmp(Map<String, Employee> staff) {
        //遍历所有条目 ，staff.entrySet()返回Map.Entry对象的视图集，即映射表中的键/值
        for (Map.Entry<String, Employee> entry : staff.entrySet()) {
            String key = entry.getKey();
          //  key.equals();

            Employee value = entry.getValue();
            System.out.println("key= " + key + " value =" + value);
        }
    }
}
