/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 * @author dinht
 */
public class Student {

    private int id;
    private String studentName;
    private int semester;

    private model.courseName courseName;

    private int totalCourse;

    public int getTotalCourse() {
        return totalCourse;
    }

    public void setTotalCourse(int totalCourse) {
        this.totalCourse = totalCourse;
    }

    public model.courseName getCourseName() {
        return courseName;
    }

    public void setCourseName(model.courseName courseName) {
        this.courseName = courseName;
    }

    public Student() {
        totalCourse = 0;
    }
    public int getId() {
        return id;
    }

    public String getStudentName() {
        return studentName;
    }

    public int getSemester() {
        return semester;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setStudentName(String studentName) {
        try {
            this.studentName = studentName;
            if (studentName.length() == 0) throw new IllegalArgumentException("Name cannot be blank");
        } catch (Exception e) {
            System.out.println("Invalid Input");
        }
    }

    public void setSemester(int semester) {
        try {
            this.semester = semester;
            if (semester < 0 || semester > 9) throw new ArithmeticException("Semester must be in range of [1, 9]");
        } catch (Exception e) {
            System.out.println("Invalid semester");
        }
    }

}
