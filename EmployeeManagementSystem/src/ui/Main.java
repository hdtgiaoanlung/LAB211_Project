package ui;

import controller.EmployeeController;
import entity.Employee;
import utils.InputUtils;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        EmployeeController employeeController = new EmployeeController();
        String menu = """
                WELCOME TO EMPLOYEE MANAGER SYSTEM
                1. Add employees
                2. Update employees
                3. Remove employees (by id)
                4. Search employees (by name)
                5. Sort employees by salary
                6. Exit
                """;
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
                            System.err.println(Employee.HEADER_OUTPUT);
                            System.err.println(add);
                        }
                        break;
                    case 2:
                        System.out.println("List of Employee: ");
                        System.out.println(employeeController.getEmployeeManager());
                        int id = InputUtils.getInt("Enter Id of update employee: ", "Input number only!", "Input out of range", 1, Integer.MAX_VALUE);
                        Employee update = employeeController.update(id);
                        if (update == null) {
                            System.err.println("Update fail");
                        } else {
                            System.err.println("Update Success");
                            System.err.println(Employee.HEADER_OUTPUT);
                            System.err.println(update);
                        }
                        break;
                    case 3:
                        System.out.println("List of Employee: ");
                        System.out.println(employeeController.getEmployeeManager());
                        id = InputUtils.getInt("Enter Id of removed employee: ", "Input number only!", "Input out of range", 1, Integer.MAX_VALUE);
                        Employee remove = employeeController.remove(id);
                        if (remove == null) {
                            System.err.println("Delete fail");
                        } else {
                            System.err.println("Remove Success");
                            System.err.println(Employee.HEADER_OUTPUT);
                            System.err.println(remove);
                        }
                        break;
                    case 4:
                        System.out.println("List of Employee: ");
                        System.out.println(employeeController.getEmployeeManager());
                        String name = InputUtils.getStringByRegex("Enter search name: ", "Input characters only!", "[A-Za-z ]+");
                        ArrayList<Employee> searchList = employeeController.search(name);
                        if (searchList.size() == 0) {
                            System.err.println("No employees found!");
                        } else {
                            System.err.println(Employee.HEADER_OUTPUT);
                            for (Employee e : searchList) {
                                System.err.println(e.toString());
                            }
                        }
                        break;
                    case 5:
                        ArrayList<Employee> sortedList = employeeController.sort();
                        if (sortedList.isEmpty()) {
                            System.err.println("No employees to display!");
                        } else {
                            System.err.println(Employee.HEADER_OUTPUT);
                            for (Employee e : sortedList) {
                                System.err.println(e.toString());
                            }
                        }
                        break;
                    case 6:
                        return;
                    default:
                        throw new RuntimeException("Please input a valid number!");
                }
            } catch (Exception e) {
                System.err.println(e.getMessage());
            }
        } while (InputUtils.pressYNToContinue());
    }
}
