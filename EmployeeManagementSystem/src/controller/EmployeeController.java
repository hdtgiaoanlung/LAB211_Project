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

    public void add() throws Exception{
        employeeInput = new EmployeeInput();
        employeeManager.addNewEmployee(employeeInput.inputInformation());
    }

    public void update() throws Exception {
        int id = InputUtils.getInt("Enter Id of update employee: ", "Input number only!", "Input out of range", 1, Integer.MAX_VALUE);
        employeeInput = new EmployeeInput();
        int index = employeeManager.searchById(id);
        if (index == -1) {
            System.out.println("Id not found!");
        } else {
            employeeManager.updateEmployee(index, employeeInput.inputInformation());
        }
    }

    public void remove() throws Exception{
        int id = InputUtils.getInt("Enter Id of removed student: ", "Input number only!", "Input out of range", 1, Integer.MAX_VALUE);
        employeeManager.removeEmployee(id);
    }

    public void search() {
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
    }

    public void sort() {
        ArrayList<Employee> sortedList = employeeManager.sortBySalary();
        for (Employee e : sortedList) {
            System.out.println(e.toString());
        }
    }


}
