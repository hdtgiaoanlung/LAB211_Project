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

    public boolean checkStudent(Student s) {
        ArrayList<Student> list = searchById(s.getId());
        if (!list.isEmpty()) {
            if (!StringUtils.removeAllBlank(list.get(0).getStudentName()).equalsIgnoreCase(StringUtils.removeAllBlank(s.getStudentName()))) {
                return false;
            }
            for (Student student : list) {
                if (student.getSemester() == s.getSemester() && student.getCourseList().contains(s.getCourseList().get(0))) {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean addStudent(Student s) throws Exception {
        if (checkStudent(s)) {
            return studentList.add(s);
        }
        throw new Exception("Cannot add student!");
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

    public Student updateStudent(int index, Student s) throws Exception {
        if (index != -1) {
            return studentList.set(index, s);
        }
        throw new Exception("Update failed!");
    }

    public boolean removeStudent(Student s) {
        return studentList.remove(s);
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
