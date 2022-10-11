package controller;

import bo.EmployeeInput;
import bo.EmployeeManager;
import entity.Employee;
import utils.InputUtils;

import java.util.ArrayList;

public class EmployeeController {
    private EmployeeInput employeeInput;
    private EmployeeManager employeeManager;

    public EmployeeController() {
        employeeManager = new EmployeeManager();
    }

    public void displayAllEmployee() {
        System.out.println("List of Employee: ");
        System.out.println(employeeManager);
    }

    public void execByChoice(int choice) {
        switch (choice) {
            case 1:
                employeeInput = new EmployeeInput();
                employeeManager.addNewEmployee(employeeInput.inputInformation());
                break;
            case 2:
                int id = InputUtils.getInt("Enter Id of update student: ", "Input number only!", "Input out of range", 1, Integer.MAX_VALUE);
                employeeInput = new EmployeeInput();
                int index = employeeManager.checkExist(id);
                if(index == -1) {
                    System.out.println("Id not found!");
                } else {
                    employeeManager.updateEmployee(index, employeeInput.inputInformation());
                }
                break;
            case 3:
                id = InputUtils.getInt("Enter Id of removed student: ", "Input number only!", "Input out of range", 1, Integer.MAX_VALUE);
                employeeManager.removeEmployee(id);
                break;
            case 4:
                displayAllEmployee();
                String name = InputUtils.getStringByRegex("Enter search name: ", "Input characters only!", "[A-Za-z ]+");
                ArrayList<Employee> searchList = employeeManager.searchByName(name);
                if (searchList.isEmpty()) {
                    System.out.println("No employee found!");
                } else {
                    for (Employee e : searchList) {
                        System.out.println(e.toString());
                    }
                }
            case 5:
                ArrayList<Employee> sortedList = employeeManager.sortBySalary();
                for (Employee e : sortedList) {
                    System.out.println(e.toString());
                }
                break;
            case 6:
                return;
            default:
                throw new AssertionError();
        }
    }

}
