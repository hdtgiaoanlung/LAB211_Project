package model;

import java.util.ArrayList;

public class Student {

    public static String FORMAT_OUTPUT = "%-5s | %-20s | %-10s | %-10s ";
    public static String HEADER_OUTPUT = String.format(FORMAT_OUTPUT, "Id", "Student Name", "Semester", "Course Name");
    private int id;
    private String studentName;
    private int semester;

    private final ArrayList<courseName> courseList;

    public Student() {
        courseList = new ArrayList<>();
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
        this.studentName = studentName;
    }

    public void setSemester(int semester) {
        this.semester = semester;
    }

    public ArrayList<courseName> getCourseList() {
        return courseList;
    }

    public String displayStudentInfo() {
        String ret = "";
        if (courseList.contains(courseName.Java)) {
            ret += String.format(FORMAT_OUTPUT, id, studentName, semester, courseName.Java) + "\n";
        }
        if (courseList.contains(courseName.Net)) {
            ret += String.format(FORMAT_OUTPUT, id, studentName, semester, courseName.Net) + "\n";
        }
        if (courseList.contains(courseName.Cpp)) {
            ret += String.format(FORMAT_OUTPUT, id, studentName, semester, courseName.Cpp) + "\n";
        }
        return ret;
    }
}
