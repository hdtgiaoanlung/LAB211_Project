/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import controller.StudentController;
import utils.StringUtils;

/**
 * @author dinht
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        StudentController sc = new StudentController();
        String menu = "\nWELCOME TO STUDENT MANAGEMENT\n"
                + "1. Create\n"
                + "2. Find and Sort\n"
                + "3. Update/Delete\n"
                + "4. Report\n"
                + "5. Exit\n"
                + "(Please choose 1 to Create, 2 to Find and Sort, 3 to Update/Delete, 4 to Report and 5 to Exit program)\n\n";

        do {
            System.out.println(menu);
            int choice = StringUtils.getInt("Enter your choice: ", "Input number only!", "Input must be in range of [1, 5]", 1, 5);
            switch (choice) {
                case 1:
                    sc.addStudentByNumber(StringUtils.getInt("Enter number of student: ", "Enter number only!", "Input must be in range of [10, 500]", 10, 500));
                    break;
                case 2:
                    sc.findAndSortStudent();
                    break;
                case 3:
                    
                case 4:
                    sc.displayAllStudent();
                    break;
                default:
                    return;
            }
        } while (StringUtils.pressYNToContinue());

    }

}
