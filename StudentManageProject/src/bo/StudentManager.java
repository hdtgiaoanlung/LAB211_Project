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
    private int lastId;

    public StudentManager() {
        studentList = new ArrayList<>();
        lastId = 0;
    }

    public StudentManager(ArrayList<Student> listStudent) {
        this.studentList = listStudent;
    }


    public void addStudent(Student s) {
        s.setId(++lastId);
        studentList.add(s);
    }

    private boolean checkExist(String name, int type){
        for(Student s : studentList){
            if(StringUtils.removeAllBlank(s.getStudentName()).equalsIgnoreCase(StringUtils.removeAllBlank(name))){
                if(courseName.intToCourseName(type) == s.getCourseName()){
                    return true;
                } else {
                    s.setTotalCourse(s.getTotalCourse() + 1);
                }
            }
        }
        return false;
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
        throw new Exception("Id not found!");
    }

    public Student updateStudent(int Id, Student s) throws Exception {
        int index = searchStudentById(Id);
        if (index != -1) {
            return studentList.set(index, s);
        }
        throw new Exception("Student not found!");
    }

    public Student removeStudentById(int Id) throws Exception {
        int index = searchStudentById(Id);
        if (index != -1) {
            return studentList.remove(index);
        }
        throw new Exception("Student not found!");
    }

    @Override
    public String toString() {
        String ret = "";
        for (Student s : studentList) {
            ret += StringUtils.normalFormName(s.getId() + " | " +s.getStudentName()) + " | " + s.getCourseName() + " | " + s.getTotalCourse() + "\n";
        }
        return ret;
    }

}
