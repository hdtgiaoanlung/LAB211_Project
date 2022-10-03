/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bo;

import model.Student;
import utils.StringUtils;

/**
 * @author dinht
 */
public class StudentInputter {

    private Student s;
    public StudentInputter() {

    }

    public void inputInformation() {
        s.setStudentName(StringUtils.getStringByRegex("Enter student name: ", "Characters only!", "[A-Za-z ]+"));
        s.setSemester(StringUtils.getInt("Enter semester: ", "Input number only!", "Input must in range of [1; 50]", 1, 50));

    }
}
