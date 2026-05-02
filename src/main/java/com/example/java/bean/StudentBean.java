package com.example.java.bean;

import java.io.Serializable;

public class StudentBean implements Serializable {
    private String studentName;
    private int rollNumber;

    public StudentBean() {
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public int getRollNumber() {
        return rollNumber;
    }

    public void setRollNumber(int rollNumber) {
        this.rollNumber = rollNumber;
    }

    public static void main(String[] args) {
        StudentBean student = new StudentBean();
        student.setStudentName("John Doe");
        student.setRollNumber(101);

        System.out.println("Student Name: " + student.getStudentName());
        System.out.println("Roll Number: " + student.getRollNumber());
    }
}

