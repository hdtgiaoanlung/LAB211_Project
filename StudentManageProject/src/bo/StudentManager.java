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

    public StudentManager(ArrayList<Student> listStudent) {
        this.studentList = listStudent;
    }

    public ArrayList<Student> getStudentList() {
        return studentList;
    }

    public ArrayList<courseName> noMoreDuplicatedCourse(Student s, Student e) {
        ArrayList<courseName> ret = e.getCourseList();
        for (courseName n : s.getCourseList()) {
            if (!ret.contains(n)){
                ret.add(n);
            }
        }
        return ret;
    }

    public boolean checkExist(Student s) {
        for (Student e : studentList) {
            if (s.getId() == e.getId() &&
                    !StringUtils.removeAllBlank(s.getStudentName()).equalsIgnoreCase(StringUtils.removeAllBlank(e.getStudentName()))) {
                return false;
            }
            if (StringUtils.removeAllBlank(s.getStudentName()).equalsIgnoreCase(StringUtils.removeAllBlank(e.getStudentName()))
                    && s.getSemester() == e.getSemester()
                    && s.getId() == e.getId()) {
                e.setCourseList(noMoreDuplicatedCourse(s, e));
                return false;
            }
        }
        return true;
    }

    public Student addStudent(Student s) throws Exception {
        if (checkExist(s)) {
            studentList.add(s);
            return s;
        }
        throw new Exception("Student is duplicated!");
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

    public int searchStudentById(int Id) throws Exception {
        for (int i = 0; i < studentList.size(); i++) {
            if (studentList.get(i).getId() == Id) {
                return i;
            }
        }
        throw new Exception("ID not found!");
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
            ret += s.toString();
        }
        return ret;
    }

}
