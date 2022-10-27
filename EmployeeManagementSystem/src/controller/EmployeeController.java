package controller;

import bo.EmployeeInput;
import bo.EmployeeManager;
import entity.Employee;

import java.util.ArrayList;

public class EmployeeController {
    private EmployeeInput employeeInput;
    private final EmployeeManager employeeManager;

    public EmployeeController() {
        employeeManager = new EmployeeManager();
        employeeInput = new EmployeeInput();
    }

    public void displayAllEmployee() {
        System.out.println("List of Employee: ");
        System.out.println(employeeManager);
    }

    public Employee add(){
        Employee e = employeeInput.inputInformation();
        if (employeeManager.addNewEmployee(e)) {
            return e;
        }
        return null;
    }

    public Employee update(int id) throws Exception {
        int index = employeeManager.searchById(id);
        if (index != -1) {
            employeeInput = new EmployeeInput();
            Employee e = employeeInput.inputInformation();
            return employeeManager.updateEmployee(index, e);
        }
        return null;
    }

    public Employee remove(int id) throws Exception {
        int index = employeeManager.searchById(id);
        if (index != -1) {
            return employeeManager.removeEmployee(index);
        }
        return null;
    }

    public ArrayList<Employee> search(String name) throws Exception {
        if (!name.isEmpty()) {
            return employeeManager.searchByName(name);
        }
        throw new Exception("Search name cannot be blank");
    }

    public ArrayList<Employee> sort() {
        return employeeManager.sortBySalary();
    }


}
