/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import controller.StudentController;
import model.Student;
import utils.StringUtils;

import java.util.ArrayList;

/**
 * @author dinht
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        StudentController controller = new StudentController();
        String menu = """
                WELCOME TO STUDENT MANAGEMENT
                1. Create
                2. Find and Sort
                3. Update/Delete
                4. Report
                5. Exit
                (Please choose 1 to Create, 2 to Find and Sort, 3 to Update/Delete, 4 to Report and 5 to Exit program)""";

        do {
            System.out.println(menu);
            int choice = StringUtils.getInt("Enter your choice: ", "Input number only!", "Input must be in range of [1, 5]", 1, 5);
            try {
                switch (choice) {
                    case 1:
                        Student add = controller.addNewStudent();
                        if (add == null) {
                            System.err.println("Add failed!");
                        } else {
                            System.err.println("Add Success");
                            System.err.println(Student.HEADER_OUTPUT);
                            System.err.println(add.getDisplayStudentInfo());
                        }
                        break;
                    case 2:
                        String searchName = StringUtils.getStringByRegex("Enter search name: ", "Input character only!", "[A-Za-z ]+");
                        ArrayList<Student> foundStudent = controller.findAndSortStudent(searchName);
                        if (foundStudent.isEmpty()) {
                            System.err.println("No Students found!");
                        } else {
                            System.out.println(Student.HEADER_OUTPUT);
                            for (Student s : foundStudent) {
                                System.out.println(s.getDisplayStudentInfo());
                            }
                        }
                        break;
                    case 3:
                        if (controller.displayAllStudent() == null) {
                            System.err.println("List empty!");
                        } else {
                            int id = StringUtils.getInt("Enter student ID to update/delete: ", "Input number only!", "Input must be in range", 1, Integer.MAX_VALUE);
                            ArrayList<Student> searchList = controller.getSearchStudentById(id);
                            if (searchList.isEmpty()) {
                                System.err.println("No Students found!");
                            } else {
                                for (int i = 0; i < searchList.size(); i++) {
                                    System.out.println("No." + (i + 1));
                                    System.out.println(searchList.get(i).getDisplayStudentInfo());
                                }
                                int index = StringUtils.getInt("Enter No. of student to update/delete: ", "Input number only!", "Input must be in range", 1, searchList.size());
                                Student updateStudent = searchList.get(index - 1);
                                boolean chooseUpdateDelete = StringUtils.chooseUpdateDelete();
                                Student s = controller.updateAndDeleteStudent(updateStudent, chooseUpdateDelete);
                                if (s == null) {
                                    System.err.println("Update/Delete fail!");
                                } else {
                                    if (chooseUpdateDelete) {
                                        System.err.println("Update Success");
                                    } else {
                                        System.err.println("Delete Success");
                                    }
                                    System.err.println(s.getDisplayStudentInfo());
                                }
                            }
                        }
                        break;
                    case 4:
                        String report = controller.report();
                        if (report.isBlank()) {
                            System.err.println("No students to report!");
                        } else {
                            System.out.println(report);
                        }
                        break;
                    case 5:
                        return;
                    default:
                        throw new AssertionError();
                }
            } catch (Exception e) {
                System.err.println(e.getMessage());
            }
        } while (StringUtils.pressYNToContinue());

    }
}
