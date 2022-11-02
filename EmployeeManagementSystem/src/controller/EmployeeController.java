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

    public EmployeeManager getEmployeeManager() {
        return employeeManager;
    }

    public Employee add() throws Exception {
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
            return employeeManager.updateEmployee(id, e);
        }
        return null;
    }

    public Employee remove(int id) throws Exception {
        if (id != -1) {
            return employeeManager.removeEmployee(id);
        }
        return null;
    }

    public ArrayList<Employee> search(String name) throws Exception {
        if (!name.isBlank()) {
            return employeeManager.searchByName(name);
        }
        throw new Exception("Search name cannot be blank");
    }

    public ArrayList<Employee> sort() {
        return employeeManager.sortBySalary();
    }


}
