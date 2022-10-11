package ui;

import controller.EmployeeController;
import utils.InputUtils;

public class Main {
    public static void main(String[] args) {
        EmployeeController employeeController = new EmployeeController();
        String menu = "WELCOME TO EMPLOYEE MANAGER SYSTEM\n"
                + "1. Add employees\n"
                + "2. Update employees\n"
                + "3. Remove employees (by id)\n"
                + "4. Search employees (by name)\n"
                + "5. Sort employees by salary\n"
                + "6. Exit\n";
        do {
            System.out.println(menu);
            int choice = InputUtils.getInt("Enter your choice: ", "Input number only!", "Input must be in range of [1, 6]", 1, 6);
            employeeController.execByChoice(choice);
        } while (InputUtils.pressYNToContinue());
    }
}
