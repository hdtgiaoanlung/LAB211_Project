package ui;

import controller.EmployeeController;
import entity.Employee;
import utils.InputUtils;

import java.util.ArrayList;

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
            try {
                switch (choice) {
                    case 1:
                        Employee add = employeeController.add();
                        if (add == null) {
                            System.err.println("Add fail");
                        } else {
                            System.err.println("Add Success");
                            System.err.println(add.getDisplayString());
                        }
                        break;
                    case 2:
                        int id = InputUtils.getInt("Enter Id of update employee: ", "Input number only!", "Input out of range", 1, Integer.MAX_VALUE);
                        Employee update = employeeController.update(id);
                        if (update == null) {
                            System.err.println("Update fail");
                        } else {
                            System.err.println("Update Success");
                            System.err.println(update.getDisplayString());
                        }
                        break;
                    case 3:
                        id = InputUtils.getInt("Enter Id of removed student: ", "Input number only!", "Input out of range", 1, Integer.MAX_VALUE);
                        Employee remove = employeeController.remove(id);
                        if (remove == null) {
                            System.err.println("Delete fail");
                        } else {
                            System.err.println("Remove Success");
                            System.err.println(remove.getDisplayString());
                        }
                        break;
                    case 4:
                        String name = InputUtils.getStringByRegex("Enter search name: ", "Input characters only!", "[A-Za-z ]+");
                        ArrayList<Employee> searchList = employeeController.search(name);
                        if (searchList.isEmpty()) {
                            System.err.println("No employees found!");
                        } else {
                            for (int i = 0; i < searchList.size(); i++) {
                                if (i == 0) {
                                    System.out.println(searchList.get(i).getDisplayString());
                                } else {
                                    System.out.println(searchList.get(i).toString());
                                }
                            }
                        }
                        break;
                    case 5:
                        ArrayList<Employee> sortedList = employeeController.sort();
                        if (sortedList.isEmpty()) {
                            System.err.println("No employees to display!");
                        } else {
                            for (int i = 0; i < sortedList.size(); i++) {
                                if (i == 0) {
                                    System.out.println(sortedList.get(i).getDisplayString());
                                } else {
                                    System.out.println(sortedList.get(i).toString());
                                }
                            }
                        }
                        break;
                    case 6:
                        return;
                    default:
                        throw new AssertionError();
                }
            } catch (Exception e) {
                System.err.println(e.getMessage());
            }
        } while (InputUtils.pressYNToContinue());
    }
}
