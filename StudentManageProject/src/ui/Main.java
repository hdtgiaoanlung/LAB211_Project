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
    public static void main(String[] args) throws Exception {
        StudentController controller = new StudentController();
        String menu = "\nWELCOME TO STUDENT MANAGEMENT\n"
                + "1. Create\n"
                + "2. Find and Sort\n"
                + "3. Update/Delete\n"
                + "4. Report\n"
                + "5. Exit\n"
                + "(Please choose 1 to Create, 2 to Find and Sort, 3 to Update/Delete, 4 to Report and 5 to Exit program)";

        do {
            System.out.println(menu);
            int choice = StringUtils.getInt("Enter your choice: ", "Input number only!", "Input must be in range of [1, 5]", 1, 5);
            try {
                switch (choice) {
                    case 1:
                        controller.addNewStudent();
                        break;
                    case 2:
                        String searchName = StringUtils.getStringByRegex("Enter search name: ", "Input character only!", "[A-Za-z ]+");
                        controller.findAndSortStudent(searchName);
                        break;
                    case 3:
                        controller.updateAndDeleteStudent();
                        break;
                    case 4:
                        controller.displayAllStudent();
                        break;
                    case 5:
                        return;
                    default:
                        throw new AssertionError();
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        } while (StringUtils.pressYNToContinue());

    }

}
