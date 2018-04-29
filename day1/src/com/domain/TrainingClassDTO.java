package com.domain;

import java.util.List;

/**
 * 培训项目
 */
public class TrainingClassDTO {

    private String id;

    private String name;

    List<ClassTeacher>   classTeachers;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<ClassTeacher> getClassTeachers() {
        return classTeachers;
    }

    public void setClassTeachers(List<ClassTeacher> classTeachers) {
        this.classTeachers = classTeachers;
    }
}
