package model;

import java.util.ArrayList;

public class Student {

    public static String FORMAT_OUTPUT = "%-5s | %-20s | %-10s | %-10s | %-3s";
    public static String HEADER_OUTPUT = String.format(FORMAT_OUTPUT, "Id", "Student Name", "Semester", "Course Name", "Total Course");
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
            ret += String.format(FORMAT_OUTPUT, id, studentName, semester, courseName.Java, javaCount);
        }
        if (netCount > 0) {
            ret += String.format(FORMAT_OUTPUT, id, studentName, semester, courseName.Net, netCount);
        }
        if (cppCount > 0) {
            ret += String.format(FORMAT_OUTPUT, id, studentName, semester, courseName.Cpp, cppCount);
        }
        return ret;
    }
}
