package ui;

import controller.EmployeeController;
import utils.InputUtils;

public class Main {
    public static void main(String[] args){
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
            try {
                switch (choice) {
                    case 1:
                        employeeController.add();
                        break;
                    case 2:
                        employeeController.update();
                        break;
                    case 3:
                        employeeController.remove();
                        break;
                    case 4:
                        employeeController.search();
                        break;
                    case 5:
                        employeeController.sort();
                        break;
                    case 6:
                        return;
                    default:
                        throw new AssertionError();
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        } while (InputUtils.pressYNToContinue());
    }
}
