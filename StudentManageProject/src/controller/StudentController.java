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

    public Student addNewStudent() {
        studentInputter = new StudentInputter();
        Student s = studentInputter.inputInformation();
        if (studentManager.addStudent(s)) {
            return s;
        }
        return null;
    }

    public ArrayList<Student> getSearchStudentById(int id) {
        return studentManager.searchById(id);
    }

    public ArrayList<Student> findAndSortStudent(String name) {
        ArrayList<Student> foundStudent = studentManager.searchStudentByName(name);
        Collections.sort(foundStudent, new Comparator<Student>() {
            @Override
            public int compare(Student student, Student t1) {
                return student.getStudentName().compareTo(t1.getStudentName());
            }
        });
        return foundStudent;
    }

    public Student updateStudent(int index) {
        if (index != -1) {
            return studentManager.updateStudent(index, studentInputter.inputInformation());
        } else {
            return null;
        }
    }

    public Student deleteStudent(int index) {
        if (index != -1) {
            return studentManager.removeStudentById(index);
        } else {
            return null;
        }
    }

    public Student updateAndDeleteStudent(int id, boolean updateOrDelete) {
        if (updateOrDelete) {
            return updateStudent(id);
        } else {
            return deleteStudent(id);
        }
    }
}
