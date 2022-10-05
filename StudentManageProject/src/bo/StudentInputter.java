/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bo;

import model.Student;
import model.courseName;
import utils.StringUtils;

/**
 * @author dinht
 */
public class StudentInputter {

    private Student s;

    public StudentInputter() {
        s = new Student();
    }

    public void inputInformation() {
        s.setStudentName(StringUtils.getStringByRegex("Enter student name: ", "Characters only!", "[A-Za-z ]+"));
        s.setSemester(StringUtils.getInt("Enter semester: ", "Input number only!", "Input must in range of [1; 50]", 1, 50));
        s.setCourseName(courseName.intToCourseName(StringUtils.getInt("Enter course name: (1: Java; 2:.Net; 3: C/C++)", "Input number only", "Input must be in range of [1, 3]", 1, 3)));
    }


    public Student getStudent() {
        return s;
    }
}
