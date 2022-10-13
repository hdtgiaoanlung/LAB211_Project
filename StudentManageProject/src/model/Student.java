package model;

import java.util.ArrayList;
import model.courseName;
import utils.StringUtils;

public class Student {

    private int id;
    private String studentName;
    private int semester;

    private ArrayList<courseName> courseList;

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

    @Override
    public String toString() {
        return id + " | " + StringUtils.normalFormName(studentName) + " | " + semester + " | " + courseList.get(0).getCourseName() + " | " + courseList.size();
    }

    public ArrayList<courseName> getCourseList() {
        return courseList;
    }

    public void updateCourseList(courseName name) throws Exception{
        courseList.add(name);
    }

    public void setCourseList(ArrayList<courseName> courseList) {
        this.courseList = courseList;
    }
}
