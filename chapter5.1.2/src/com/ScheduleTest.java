//package com;
//
//import java.util.*;
//
//public class ScheduleTest {
//
//    public static void main(String[] args) {
//        TrainingSchedule trainingSchedule1 = new TrainingSchedule();
//        trainingSchedule1.setId("s1");
//        trainingSchedule1.setTitle("第一天");
//
//        TrainingSchedule trainingSchedule2 = new TrainingSchedule();
//        trainingSchedule2.setId("s2");
//        trainingSchedule2.setTitle("第二天");
//
//
//        TrainingSchedule trainingSchedule3 = new TrainingSchedule();
//        trainingSchedule3.setId("s3");
//        trainingSchedule3.setTitle("第一天");
//
//        TrainingSchedule trainingSchedule4 = new TrainingSchedule();
//        trainingSchedule4.setId("s4");
//        trainingSchedule4.setTitle("第二天");
//
//        TrainingSchedule trainingSchedule5 = new TrainingSchedule();
//        trainingSchedule5.setId("s5");
//        trainingSchedule5.setTitle("第二天");
//
//        TrainingSchedule trainingSchedule6 = new TrainingSchedule();
//        trainingSchedule6.setId("s6");
//        trainingSchedule6.setTitle("第三天");
//
//        TrainingSchedule trainingSchedule7 = new TrainingSchedule();
//        trainingSchedule7.setId("s7");
//        trainingSchedule7.setTitle("第三天");
//
//        TrainingSchedule trainingSchedule8 = new TrainingSchedule();
//        trainingSchedule8.setId("s8");
//        trainingSchedule8.setTitle("第一天");
//
//        TrainingSchedule trainingSchedule9 = new TrainingSchedule();
//        trainingSchedule9.setId("s9");
//        trainingSchedule9.setTitle("第三天");
//
//        TrainingSchedule trainingSchedule10 = new TrainingSchedule();
//        trainingSchedule10.setId("s10");
//        trainingSchedule10.setTitle("第二天");
//
////        TrainingSchedule trainingSchedule11 =new TrainingSchedule();
////        trainingSchedule11.setId("s11");
////        trainingSchedule11.setTitle("第二天");
//
//        List<TrainingSchedule> scheduleList = new ArrayList<TrainingSchedule>();
//        scheduleList.add(trainingSchedule1);
//        scheduleList.add(trainingSchedule2);
//        scheduleList.add(trainingSchedule3);
//        scheduleList.add(trainingSchedule4);
//        scheduleList.add(trainingSchedule5);
//        scheduleList.add(trainingSchedule6);
//        scheduleList.add(trainingSchedule7);
//        scheduleList.add(trainingSchedule8);
//        scheduleList.add(trainingSchedule9);
//        scheduleList.add(trainingSchedule10);
////        scheduleList.add(trainingSchedule11);
//        System.out.println("分组前:");
//        printList(scheduleList);
//        System.out.println("分组后:");
//        groupList(scheduleList);
//
////        print(scheduleList);
//    }
//
//    private static void printList(List<TrainingSchedule> scheduleList) {
//
//        for (TrainingSchedule schedule: scheduleList) {
//            System.out.println("schedule=:"+schedule.getId()+"Title=:"+schedule.getTitle());
//        }
//    }
//
//    /**
//     * @param datas 集合对象 或list,set,map等
//     * @return
//     * @throws
//     * @date 2018/5/14 21:59
//     */
//    private static <T> List<List<T>> groupOrder(Collection<T> datas, Comparator<? super T> comparable) {
//        List<List<T>> list = new ArrayList<List<T>>();
//        for (T t : datas) {
//            boolean issameGroup = false;
//            for (int j = 0; j < list.size(); j++) {
//                if (comparable.compare(t, list.get(j).get(0)) == 0) {
//                    issameGroup = true;
//                    list.get(j).add(t);
//                    break;
//                }
//            }
//            if (!issameGroup) {
//                // 新建分组集合
//                List<T> listT = new ArrayList<T>();
//                listT.add(t);
//                list.add(listT);
//
//            }
//        }
//        return list;
//    }
//
//
//    private static void groupList(List<TrainingSchedule> scheduleList) {
//        Map<String, List<TrainingSchedule>> listMap = new HashMap<>();
//        for (TrainingSchedule trainingSchedule : scheduleList) {
//            List<TrainingSchedule> tempList = listMap.get(trainingSchedule.getTitle());
//            /**如果取不到数据,那么直接new一个空的ArrayList**/
//            if (tempList == null) {
//                tempList = new ArrayList<TrainingSchedule>();
//                tempList.add(trainingSchedule);
//                listMap.put(trainingSchedule.getTitle(), tempList);
//            } else {
//                /**某个trainingSchedule之前已经存放过了,则直接追加数据到原来的List里**/
//                tempList.add(trainingSchedule);
//            }
//        }
//        List<List<TrainingSchedule>> resultList=new ArrayList<List<TrainingSchedule>>();
//
//        for (Map.Entry<String, List<TrainingSchedule>> listEntry : listMap.entrySet()) {
//            String key = listEntry.getKey();
//            //System.out.println("listMap=:" + listMap.get(key));
//            List<TrainingSchedule> scheduleList1 = listMap.get(key);
//
//            resultList.add(scheduleList1);
//
//        }
//        print(resultList);
//
//    }
//
//
//
//    private static void print(List<List<TrainingSchedule>> resultList) {
//
//        if(resultList.size()!=0&& !resultList.isEmpty()) {
//
//            for (int i = 0; i < resultList.size(); i++) {
//                System.out.println("第"+i+"组");
//               for (int j=0;j<resultList.get(i).size();j++){
//                   TrainingSchedule trainingSchedule = resultList.get(i).get(j);
//                   System.out.println("trainingSchedule=:"+trainingSchedule.getId()+",Titile=:"+trainingSchedule.getTitle());
//               }
//            }
//        }
//    }
//
//    private static void sort(List<TrainingSchedule> list){
//        int size = list.size();
//        for (int i = 0; i < size; i++) {
//            for (int j = 0; j < size-1-i; j++) {
//
//
//            }
//
//        }
//    }
//
//
//    private static  Map<String, Integer> map = new HashMap<>();
//
//    static {
//        map.put("第一天",1);
//        map.put("第二天",2);
//        map.put("第三天",3);
//    }
//
//    public static void insertSort(List<TrainingSchedule> scheduleList){
//        TrainingSchedule temp;
//        int in,out,tempInt;
//        for (out=1; out<scheduleList.size();out++){
//            temp = scheduleList.get(out);
//            tempInt = map.get(temp.getTitle());
//            in = out;
//            while (in > 0 && map.get(scheduleList.get(in-1).getTitle())>tempInt){
//                scheduleList.set(in,scheduleList.get(in-1));
//                in--;
//            }
//            scheduleList.set(in,temp);
//        }
//    }
//
//}
