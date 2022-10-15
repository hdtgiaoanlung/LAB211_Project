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

    public Employee add() throws Exception {
        employeeInput = new EmployeeInput();
        Employee e = employeeInput.inputInformation();
        if (employeeManager.addNewEmployee(e)) {
            return e;
        }
        return null;
    }

    public Employee update(int id){
        int index = employeeManager.searchById(id);
        if (index != -1) {
            employeeInput = new EmployeeInput();
            Employee e = employeeInput.inputInformation();
            return employeeManager.updateEmployee(index, e);
        }
        return null;
    }

    public Employee remove(int id){
        int index = employeeManager.searchById(id);
        if (index != -1) {
            Employee e = employeeManager.removeEmployee(index);
            return e;
        }
        return null;
    }

    public ArrayList<Employee> search(String name) throws Exception {
        displayAllEmployee();
        return employeeManager.searchByName(name);
    }

    public ArrayList<Employee> sort() {
        return employeeManager.sortBySalary();
    }


}
