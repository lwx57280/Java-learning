package com;
import com.domain.ClassTeacher;
import com.domain.TrainingClassDTO;

import java.util.ArrayList;
import java.util.List;

public class Welcome {
    public static void main(String[] args) {
        String[] greeting = new String[3];
        greeting[0] = "Welcome to Core Java";
        greeting[1] = "by Cay Horstman";
        greeting[2] = "and Gary Cornell";
        /*这是注释*/
        for (String temp : greeting) {
            System.out.println(temp);
        }
        printListDemo();
    }

    private static void printListDemo() {
        List<TrainingClassDTO> trainingClassDTOList = new ArrayList<TrainingClassDTO>();

        TrainingClassDTO trainingClassDTO1 = new TrainingClassDTO();
        trainingClassDTO1.setId("001");
        trainingClassDTO1.setName("培训班1");

        TrainingClassDTO trainingClassDTO2 = new TrainingClassDTO();
        trainingClassDTO2.setId("002");
        trainingClassDTO2.setName("培训班2");

        List<ClassTeacher> teacherList1 = new ArrayList<ClassTeacher>();
        ClassTeacher teacher1 = new ClassTeacher();
        teacher1.setEmpNo("101");
        teacher1.setName("小张");

        ClassTeacher teachar2 = new ClassTeacher();
        teachar2.setEmpNo("102");
        teachar2.setName("刘莉");

        List<ClassTeacher> teacherList2 = new ArrayList<ClassTeacher>();
        ClassTeacher teachar3 = new ClassTeacher();
        teachar3.setEmpNo("103");
        teachar3.setName("王五");

        ClassTeacher teachar4 = new ClassTeacher();
        teachar4.setEmpNo("104");
        teachar4.setName("张三");

        teacherList1.add(teacher1);
        teacherList1.add(teachar2);

        teacherList2.add(teachar3);
        teacherList2.add(teachar4);

        trainingClassDTOList.add(trainingClassDTO1);
        trainingClassDTOList.add(trainingClassDTO2);

        trainingClassDTO1.setClassTeachers(teacherList1);
        trainingClassDTO2.setClassTeachers(teacherList2);


        // 培训项目编码，培训项目名称，班主任（empNo）
        for (TrainingClassDTO trainingClassDTO : trainingClassDTOList) {
            System.out.println(trainingClassDTO.getId() + "," + trainingClassDTO.getName()
                    + getTeachers(trainingClassDTO.getClassTeachers()));
        }
    }

    private static String getTeachers(List<ClassTeacher> list) {
        String temp = ",";
        if (list != null && list.size() > 0) {
            for (ClassTeacher teacher : list) {
                temp += (teacher.getName() + "(" + teacher.getEmpNo() + "),");
            }
//            System.out.println("temp.length()1=:" + temp.length());
            temp = temp.substring(0, temp.length() - 1);
        }
        //System.out.println("temp.length()2=:" + temp.length());
        return temp;
    }
}
