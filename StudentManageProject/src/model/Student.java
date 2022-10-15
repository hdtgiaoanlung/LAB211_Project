package model;

import java.util.ArrayList;
import java.util.Collections;

import model.courseName;
import utils.StringUtils;

public class Student {

    public static String FORMAT_OUTPUT = "%-5s | %-20s | %-10s | %-10s | %-3s \n";
    public static String HEADER_OUTPUT = String.format(FORMAT_OUTPUT, "id", "student name", "semester", "course name", "total course");
    private int id;
    private String studentName;
    private int semester;

    private ArrayList<courseName> courseList;

    public Student() {
        courseList = new ArrayList<>();
    }

    public Student(int id, String studentName, int semester, ArrayList<courseName> courseList) {
        this.id = id;
        this.studentName = studentName;
        this.semester = semester;
        this.courseList = courseList;
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

    @Override
    public String toString() {
        return String.format(FORMAT_OUTPUT, id, studentName, semester, courseList.get(0), "");
    }

    private int countCourse(courseName name) {
        int count = 0;
        for (courseName c : courseList) {
            if (c.equals(name)) {
                count++;
            }
        }
        return count;
    }

    public String displayStudentInfo() {
        String ret = "";
        int javaCount = countCourse(courseName.Java);
        int netCount = countCourse(courseName.Net);
        int cppCount = countCourse(courseName.Cpp);
        if (javaCount > 0) {
            ret += String.format(FORMAT_OUTPUT, id, studentName, semester, courseName.Java, javaCount + "\n");
        }
        if (netCount > 0) {
            ret += String.format(FORMAT_OUTPUT, id, studentName, semester, courseName.Net, netCount + "\n");
        }
        if (cppCount > 0) {
            ret += String.format(FORMAT_OUTPUT, id, studentName, semester, courseName.Cpp, cppCount + "\n");
        }
        return ret;
    }
}
