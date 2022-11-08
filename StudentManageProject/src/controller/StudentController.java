/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import bo.StudentInput;
import bo.StudentManager;
import model.Student;
import model.StudentReport;

import java.util.ArrayList;
import java.util.Map;

/**
 * @author dinht
 */
public class StudentController {
    private final StudentManager studentManager;
    private final StudentInput studentInput;

    public StudentController() {
        studentManager = new StudentManager();
        studentInput = new StudentInput();
    }

    public String displayAllStudent() {
        StringBuilder ret = new StringBuilder();
        if (studentManager.getStudentList().isEmpty()) {
            return null;
        }
        for (Student s : studentManager.getStudentList()) {
            ret.append(s.getDisplayStudentInfo()).append("\n");
        }
        return ret.toString();
    }

    public Student addNewStudent() throws Exception {
        Student s = studentInput.inputInformation();
        if (studentManager.addStudent(s)) {
            return s;
        }
        return null;
    }

    public ArrayList<Student> getSearchStudentById(int id) {
        return studentManager.getStudentListById(id);
    }

    public ArrayList<Student> findAndSortStudent(String name) {
        return studentManager.findAndSortByName(name);
    }

    private Student updateStudent(Student updateStudent) throws Exception {
        Student newStudent = studentInput.inputInformation();
        return studentManager.updateStudent(updateStudent, newStudent);
    }

    private Student deleteStudent(Student s) {
        if (studentManager.removeStudent(s)) {
            return s;
        }
        return null;
    }

    public Student updateAndDeleteStudent(Student s, boolean chooseUpdateDelete) throws Exception {
        if (chooseUpdateDelete) {
            return updateStudent(s);
        }
        return deleteStudent(s);
    }

    public String report() {
        StringBuilder ret = new StringBuilder();
        Map<String, StudentReport> map = studentManager.report();
        for (StudentReport studentReport : map.values()) {
            ret.append(studentReport);
        }
        return ret.toString();
    }

}
