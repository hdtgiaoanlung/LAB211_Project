/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;

import model.Student;

import static java.util.Objects.compare;

/**
 * @author dinht
 */
public class StudentManager {

    private ArrayList<Student> studentList;
    private int lastId;

    public StudentManager() {
        studentList = new ArrayList<>();
        lastId = 0;
    }

    public StudentManager(ArrayList<Student> listStudent) {
        this.studentList = listStudent;
    }

    public void createStudent(Student s) {
        s.setId(++lastId);
        studentList.add(s);
    }

    public ArrayList<Student> searchStudentByName(String name) {
        ArrayList<Student> temp = new ArrayList<>();
        for (int i = 0; i < studentList.size(); i++) {
            if (studentList.get(i).getStudentName() == name) {
                temp.add(studentList.get(i));
            }
        }
        return temp;
    }

    public int searchStudentById(int Id) throws Exception{
        for(int i = 0; i <studentList.size(); i++){
            if(studentList.get(i).getId() == Id){
                return i;
            }
        }
        throw new Exception("Id not found!");
    }

    public void updateStudent() {

    }

    public Student removeStudent(int Id) {

    }

    public void report() {

    }

}
