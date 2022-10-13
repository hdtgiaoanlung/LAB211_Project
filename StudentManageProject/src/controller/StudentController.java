/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import bo.StudentInputter;
import bo.StudentManager;
import utils.StringUtils;
import model.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * @author dinht
 */
public class StudentController {
    StudentManager studentManager;
    StudentInputter studentInputter;

    public StudentController() {
        studentManager = new StudentManager();
    }

    public Student addNewStudent() throws Exception {
        studentInputter = new StudentInputter();
        Student s = studentInputter.inputInformation();
        studentManager.addStudent(s);
        return s;
    }

    public void displayAllStudent(){
        System.out.println("List of Students: ");
        System.out.println(studentManager);
    }

    public void findAndSortStudent(String name){
        ArrayList<Student> foundStudent = studentManager.searchStudentByName(name);
        if (foundStudent.size() == 0) {
            System.out.println("No students found!");
        } else {
            Collections.sort(foundStudent, new Comparator<Student>() {
                @Override
                public int compare(Student student, Student t1) {
                    return student.getStudentName().compareTo(t1.getStudentName());
                }
            });
            for (Student s : foundStudent) {
                System.out.println(s.toString());
            }
        }
    }

    public Student updateStudent(int id) throws Exception{
        int index = studentManager.searchStudentById(id);
        return studentManager.updateStudent(index, studentInputter.inputInformation());
    }

    public Student deleteStudent(int id) throws Exception {
        int index = studentManager.searchStudentById(id);
        return studentManager.removeStudentById(index);
    }

    public Student updateAndDeleteStudent() throws Exception{
        int id = StringUtils.getInt("Enter student ID to update: ", "Input number only!", "Input must be in range", 1, Integer.MAX_VALUE);
        if (StringUtils.chooseUpdateDelete()) {
            return updateStudent(id);
        } else {
            return deleteStudent(id);
        }
    }
}
