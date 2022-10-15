/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bo;


import java.util.ArrayList;

import model.Student;
import model.courseName;
import utils.StringUtils;

/**
 * @author dinht
 */
public class StudentManager {

    private ArrayList<Student> studentList;

    public StudentManager() {
        studentList = new ArrayList<>();
    }

    public int searchStudentByIdAndSemester(int id, int semester) {
        for (int i = 0; i < studentList.size(); i++) {
            if(studentList.get(i).getId() == id && studentList.get(i).getSemester() == semester) {
                return i;
            }
        }
        return -1;
    }
    private int searchStudent(Student s) {
        int index = searchStudentByIdAndSemester(s.getId(), s.getSemester());
        if (index == -1)
            return -1;
        else {
            if (!StringUtils.removeAllBlank(studentList.get(index).getStudentName()).equalsIgnoreCase(StringUtils.removeAllBlank(s.getStudentName()))) {
                return -2;
            } else {
                if (studentList.get(index).getSemester() == s.getSemester()) {
                    return index;
                } else {
                    return -1;
                }
            }
        }
    }


    public boolean addStudent(Student s){
        int index = searchStudent(s);
        if (index == -1) {
            return studentList.add(s);
        }
        if (index == -2) {
            return false;
        } else {
            return studentList.get(index).getCourseList().add(s.getCourseList().get(0));
        }
    }

    public ArrayList<Student> searchStudentByName(String name) {
        ArrayList<Student> ret = new ArrayList<>();
        for (int i = 0; i < studentList.size(); i++) {
            if (StringUtils.removeAllBlank(studentList.get(i).getStudentName()).contains(StringUtils.removeAllBlank(name))) {
                ret.add(studentList.get(i));
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
        String ret = "";
        for (Student s : studentList) {
            ret += s.displayStudentInfo();
        }
        return ret;
    }

}
