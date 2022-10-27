/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bo;


import java.util.ArrayList;

import model.Student;
import utils.StringUtils;

/**
 * @author dinht
 */
public class StudentManager {

    private final ArrayList<Student> studentList;

    public StudentManager() {
        studentList = new ArrayList<>();
    }

    public ArrayList<Student> getStudentList() {
        return studentList;
    }

    public ArrayList<Student> searchById(int id) {
        ArrayList<Student> ret = new ArrayList<>();
        for (Student s : studentList) {
            if (s.getId() == id) {
                ret.add(s);
            }
        }
        return ret;
    }

    private int searchStudent(Student s) {
        ArrayList<Student> list = searchById(s.getId());
        if(list.isEmpty()) {
            return -1;
        }
        if (!StringUtils.removeAllBlank(list.get(0).getStudentName()).equalsIgnoreCase(StringUtils.removeAllBlank(s.getStudentName()))) {
            return -2;
        }
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getSemester() == s.getSemester()) {
                return i;
            }
        }
        return -1;
    }


    public boolean addStudent(Student s) {
        int index = searchStudent(s);
        if (index == -1) {
            return studentList.add(s);
        }
        if (index == -2) {
            return false;
        }
        return studentList.get(index).getCourseList().add(s.getCourseList().get(0));
    }

    public ArrayList<Student> searchStudentByName(String name) {
        ArrayList<Student> ret = new ArrayList<>();
        for (Student student : studentList) {
            if (StringUtils.removeAllBlank(student.getStudentName()).contains(StringUtils.removeAllBlank(name))) {
                ret.add(student);
            }
        }
        return ret;
    }

    public Student updateStudent(int index, Student s) {
        return studentList.set(index, s);
    }

    public Student removeStudentById(int index) {
        return studentList.remove(index);
    }

    @Override
    public String toString() {
        StringBuilder ret = new StringBuilder();
        for (Student s : studentList) {
            ret.append(s.displayStudentInfo());
        }
        return ret.toString();
    }

}
