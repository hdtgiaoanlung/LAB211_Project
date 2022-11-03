/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bo;


import java.util.ArrayList;
import java.util.HashMap;

import model.Student;
import model.StudentReport;
import model.CourseName;
import utils.StringUtils;

/**
 * @author dinht
 */
public class StudentManager {

    private final ArrayList<Student> studentList;

    public StudentManager() {
        studentList = new ArrayList<>();
    }


    public ArrayList<Student> getStudentListById(int id) {
        ArrayList<Student> ret = new ArrayList<>();
        for (Student s : studentList) {
            if (s.getId() == id) {
                ret.add(s);
            }
        }
        return ret;
    }

    public int searchById(int id) {
        for (int i = 0; i < studentList.size(); i++) {
            if (studentList.get(i).getId() == id) {
                return i;
            }
        }
        return -1;
    }

    public boolean checkStudent(Student s) throws Exception {
        ArrayList<Student> list = getStudentListById(s.getId());
        if (!list.isEmpty()) {
            if (!StringUtils.removeAllBlank(list.get(0).getStudentName()).equalsIgnoreCase(StringUtils.removeAllBlank(s.getStudentName()))) {
                throw new Exception("Same ID cannot have different names!");
            }
            for (Student student : list) {
                if (student.getSemester() == s.getSemester() && student.getCourseList().contains(s.getCourseList())) {
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
            if (StringUtils.removeAllBlank(student.getStudentName().toLowerCase()).contains(StringUtils.removeAllBlank(name).toLowerCase())) {
                ret.add(student);
            }
        }
        return ret;
    }

    public Student updateStudent(int id, Student s) throws Exception {
        if (s == null) {
            throw new Exception("Student cannot bu null!");
        }
        int index = searchById(id);
        if (index != -1) {
            return studentList.set(index, s);
        }
        throw new Exception("Student not found!");
    }

    public boolean removeStudent(Student s) {
        return studentList.remove(s);
    }

    public ArrayList<Student> getStudentList() throws Exception {
        if (studentList.isEmpty()) {
            throw new Exception("List empty!");
        }
        return studentList;
    }

    public HashMap<String, StudentReport> report() {
        HashMap<String, StudentReport> ret = new HashMap<>();
        for (Student s : studentList) {
            ArrayList<CourseName> courseName = s.getCourseList();
            for (CourseName course : courseName) {
                String key = s.getId() + "|" + course;
                StudentReport sr = ret.get(key);
                if (sr == null) {
                    sr = new StudentReport(s.getId(), s.getStudentName(), course.toString(), 0);
                    ret.put(key, sr);
                }
                sr.setCount(sr.getCount() + 1);
            }
        }
        return ret;
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
