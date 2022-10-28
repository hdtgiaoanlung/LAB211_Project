/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import bo.StudentInputter;
import bo.StudentManager;
import model.*;

import java.util.ArrayList;
import java.util.Comparator;

/**
 * @author dinht
 */
public class StudentController {
    private final StudentManager studentManager;
    private final StudentInputter studentInputter;

    public StudentController() {
        studentManager = new StudentManager();
        studentInputter = new StudentInputter();
    }

    public StudentManager getStudentManager() {
        return studentManager;
    }

    public Student addNewStudent() throws Exception {
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
        foundStudent.sort(Comparator.comparing(Student::getStudentName));
        return foundStudent;
    }

    private Student updateStudent(Student s) throws Exception{
        Student student = studentInputter.inputInformation();
        int index = studentManager.getStudentList().indexOf(s);
        if (studentManager.checkStudent(s)) {
            return studentManager.updateStudent(index, student);
        }
        return null;
    }

    private Student deleteStudent(Student s) {
        if (studentManager.removeStudent(s)) {
            return s;
        }
        return null;
    }

    public Student updateAndDeleteStudent(Student s, boolean chooseUpdateDelete) throws Exception{
        if (chooseUpdateDelete) {
            return updateStudent(s);
        }
        return deleteStudent(s);
    }
}
