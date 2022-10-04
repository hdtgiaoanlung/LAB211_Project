/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import bo.StudentInputter;
import bo.StudentManager;
import model.Student;
import utils.StringUtils;

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

    private Student addNewStudent() {
        studentInputter = new StudentInputter();
        studentInputter.inputInformation();
        Student s = studentInputter.getStudent();
        studentManager.addStudent(s);
        return s;
    }

    public void addStudentByNumber(int numberStudent){
        ArrayList<Student> temp = new ArrayList<>();
        for (int i = 0; i < numberStudent; i++){
            Student s = addNewStudent();
            temp.add(s);
            if(studentManager.searchStudentByName(s.getStudentName()).size() == 0){
                studentManager.addStudent(s);
            }
        }
    }

    public void displayAllStudent(){
        System.out.println("List of Students: ");
        System.out.println(studentManager);
    }
    public void findAndSortStudent() {
        String name = StringUtils.getStringByRegex("Enter search name: ", "Input characters only please!", "[A-Za-z ]+");
        ArrayList<Student> ret = studentManager.searchStudentByName(name);
        if (ret.isEmpty()) {
            System.out.println("No Students found");
        } else {
            Collections.sort(ret, new Comparator<Student>() {
                @Override
                public int compare(Student student, Student t1) {
                    return student.getStudentName().compareTo(t1.getStudentName());
                }
            });
            System.out.println("The found student list: ");
            for(Student s : ret){
                System.out.println(s.toString());
            }
        }
    }
}
