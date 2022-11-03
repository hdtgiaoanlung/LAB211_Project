/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bo;

import model.*;
import utils.StringUtils;

/**
 * @author dinht
 */
public class StudentInput {
    private Student s;

    public StudentInput() {
        s = new Student();
    }

    public Student inputInformation(){
        s = new Student();
        s.setId(StringUtils.getInt("Enter student id: ", "Input number only!", "Input must be in range of [1, " + Integer.MAX_VALUE + "]", 1, Integer.MAX_VALUE));
        s.setStudentName(StringUtils.normalFormName(StringUtils.getStringByRegex("Enter student name: ", "Characters only!", "[A-Za-z ]+")));
        s.setSemester(StringUtils.getInt("Enter semester: ", "Input number only!", "Input must in range of [1; 50]", 1, 50));
        s.getCourseList().add(CourseName.intToCourseName(StringUtils.getInt("Enter course name: (1: Java; 2:.Net; 3: C/C++)", "Input number only", "Input must be in range of [1, 3]", 1, 3)));
        return s;
    }
}
