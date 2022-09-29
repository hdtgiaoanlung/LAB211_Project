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

    private String id;
    private String studentName;
    private int semester;
    
    private enum courseName {
        Java, Net, Cpp;

        public String getCourseName() {
            switch (this) {
                case Java:
                    return "Java";
                case Net:
                    return ".Net";
                case Cpp:
                    return "C/C++";
                default:
                    throw new AssertionError();
            }
        }
    }

    public Student() {

    }

    public Student(String id, String studentName, int semester) {
        this.id = id;
        this.studentName = studentName;
        this.semester = semester;
    }


    public String getId() {
        return id;
    }

    public String getStudentName() {
        return studentName;
    }

    public int getSemester() {
        return semester;
    }

    public void setId(String id) {
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
