package bo;

import entity.Employee;

import java.util.ArrayList;
import java.util.Comparator;

public class EmployeeManager {
    private final ArrayList<Employee> empList;

    public EmployeeManager() {
        empList = new ArrayList<>();
    }


    private boolean checkExist(int id) {
        return searchById(id) != -1;
    }

    public boolean addNewEmployee(Employee e){
        if (!checkExist(e.getId())) {
            return empList.add(e);
        }
        return false;
    }

    public ArrayList<Employee> searchByName(String name) throws Exception {
        if (!name.isBlank()) {
            ArrayList<Employee> ret = new ArrayList<>();
            for (Employee employee : empList) {
                String fullName = employee.getFirstName() + employee.getLastName();
                if (fullName.toLowerCase().contains(name)) {
                    ret.add(employee);
                }
            }
            return ret;
        }
        throw new Exception("Search name cannot be blank!");
    }

    public Employee removeEmployee(int index) throws Exception {
        if (index != -1) {
            return empList.remove(index);
        }
        throw new Exception("Employee not found!");
    }

    public Employee updateEmployee(int index, Employee e) throws Exception {
        if (index != -1) {
            return empList.set(index, e);
        }
        throw new Exception("Employee not found!");
    }

    public int searchById(int id) {
        for (int i = 0; i < empList.size(); i++) {
            if (empList.get(i).getId() == id) {
                return i;
            }
        }
        return -1;
    }

    public ArrayList<Employee> sortBySalary() {
        ArrayList<Employee> ret = empList;
        ret.sort(Comparator.comparingInt(Employee::getSalary));
        return ret;
    }

    @Override
    public String toString() {
        StringBuilder ret = new StringBuilder();
        for (Employee e : empList) {
            ret.append(e.toString());
        }
        return ret.toString();
    }
}
