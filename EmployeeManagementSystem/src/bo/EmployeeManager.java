package bo;

import entity.Employee;

import java.util.ArrayList;
import java.util.Comparator;

public class EmployeeManager {
    private final ArrayList<Employee> empList;

    public EmployeeManager() {
        empList = new ArrayList<>();
    }

    public int searchById(int id) {
        for (int i = 0; i < empList.size(); i++) {
            if (empList.get(i).getId() == id) {
                return i;
            }
        }
        return -1;
    }

    public boolean addNewEmployee(Employee e) throws Exception{
        if (searchById(e.getId()) == -1) {
            return empList.add(e);
        }
        throw new Exception("ID is duplicated!");
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

    public Employee removeEmployee(int id) throws Exception {
        int index = searchById(id);
        if (index == -1) {
            throw new Exception("ID not found");
        }
        return empList.remove(index);
    }

    public Employee updateEmployee(int id, Employee e) throws Exception{
        int index = searchById(id);
        if (empList.get(index) == null) {
            throw new Exception("ID not found!");
        }
        return empList.set(index, e);
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
