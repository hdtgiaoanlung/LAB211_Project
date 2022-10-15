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
    public StudentManager studentManager;
    public StudentInputter studentInputter;

    public StudentController() {
        studentManager = new StudentManager();
    }

    public Student addNewStudent(){
        studentInputter = new StudentInputter();
        Student s = studentInputter.inputInformation();
        if (studentManager.addStudent(s)){
            return s;
        }
        return null;
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
                System.out.println(s.displayStudentInfo());
            }
        }
    }

    public Student updateStudent(int id){
        int index = studentManager.searchStudentById(id);
        if (index != -1) {
            return studentManager.updateStudent(index, studentInputter.inputInformation());
        } else {
            return null;
        }
    }

    public Student deleteStudent(int id){
        int index = studentManager.searchStudentById(id);
        if (index != -1) {
            return studentManager.removeStudentById(index);
        } else {
            return null;
        }
    }

    public Student updateAndDeleteStudent(int id, boolean updateOrDelete){
        if (updateOrDelete) {
            return updateStudent(id);
        } else {
            return deleteStudent(id);
        }
    }
}
