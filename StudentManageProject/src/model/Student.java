/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author dinht
 */
public class Student {

    private String id;
    private String studentName;
    private String semester;
    private enum courseName{
        Java, Net, Cpp;
        public String getCourseName(){
            switch(this){
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
    };

    public Student() {

    }

    public Student(String id, String studentName, String semester) {
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

    public String getSemester() {
        return semester;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public void setSemester(String semester) {
        this.semester = semester;
    }

}
