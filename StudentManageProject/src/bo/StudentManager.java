/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bo;


import java.util.ArrayList;
import java.util.Comparator;
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

    public void checkStudent(Student s) throws Exception {
        ArrayList<Student> list = getStudentListById(s.getId());


        for (Student student : list) {
            if (!StringUtils.normalFormName(student.getStudentName())
                    .equalsIgnoreCase(StringUtils.normalFormName(s.getStudentName()))) {
                throw new Exception("Same ID cannot have different names!");
            }
            if (student.getSemester() == s.getSemester() && student.getCourseName().equals(s.getCourseName())) {
                throw new Exception("Information duplicated!");
            }
        }
    }

    public boolean addStudent(Student s) throws Exception {
        checkStudent(s);
        return studentList.add(s);
    }

    private ArrayList<Student> searchStudentByName(String name) {
        ArrayList<Student> ret = new ArrayList<>();
        for (Student student : studentList) {
            if (StringUtils.removeAllBlank(student.getStudentName().toLowerCase()).contains(StringUtils.removeAllBlank(name).toLowerCase())) {
                ret.add(student);
            }
        }
        return ret;
    }

    public ArrayList<Student> findAndSortByName(String name) {
        ArrayList<Student> ret = searchStudentByName(name);
        ret.sort(Comparator.comparing(Student::getStudentName));
        return ret;
    }

    public Student updateStudent(Student updateStudent, Student newStudent) throws Exception {
        if (newStudent == null) {
            throw new Exception("Student cannot be null!");
        }
        checkStudent(newStudent);
        return studentList.set(studentList.indexOf(updateStudent), newStudent);
    }

    public boolean removeStudent(Student s) {
        return studentList.remove(s);
    }

    public ArrayList<Student> getStudentList() {
        return studentList;
    }

    public HashMap<String, StudentReport> report() {
        HashMap<String, StudentReport> ret = new HashMap<>();
        for (Student s : studentList) {
            CourseName course = s.getCourseName();
            String key = s.getId() + "|" + course.courseNameToString();
            StudentReport sr = ret.get(key);
            if (sr == null) {
                sr = new StudentReport(s.getId(), s.getStudentName(), course.courseNameToString(), 0);
                ret.put(key, sr);
            }
            sr.setCount(sr.getCount() + 1);
        }
        return ret;
    }

    @Override
    public String toString() {
        StringBuilder ret = new StringBuilder();
        for (Student s : studentList) {
            ret.append(s.getDisplayStudentInfo());
        }
        return ret.toString();
    }


}
