package com.pxy.mybatis.pojo;

public class Student {
    private int id;
    private String studentname;
    private char gender;
    private int age;

    public Student() {
    }

    public Student(int id, String studentname, char gender, int age) {
        this.id = id;
        this.studentname = studentname;
        this.gender = gender;
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStudentname() {
        return studentname;
    }

    public void setStudentname(String studentname) {
        this.studentname = studentname;
    }

    public char getGender() {
        return gender;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", studentname='" + studentname + '\'' +
                ", gender=" + gender +
                ", age=" + age +
                '}';
    }
}
