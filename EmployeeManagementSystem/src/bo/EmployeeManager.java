package bo;

import entity.Employee;
import utils.InputUtils;

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

    public boolean addNewEmployee(Employee e) throws Exception {
        if (searchById(e.getId()) == -1) {
            return empList.add(e);
        }
        throw new Exception("ID is duplicated!");
    }


    public Employee removeEmployee(int id) throws Exception {
        int index = searchById(id);
        if (index == -1) {
            throw new Exception("ID not found");
        }
        return empList.remove(index);
    }

    public Employee updateEmployee(int id, Employee e) throws Exception {
        int index = searchById(id);
        if (searchById(e.getId()) != -1 && e.getId() != empList.get(index).getId()) {
            throw new Exception("Update ID duplicated!");
        }
        if (empList.get(index) == null) {
            throw new Exception("ID not found!");
        }
        return empList.set(index, e);
    }

    public ArrayList<Employee> searchByName(String name) throws Exception {
        if (!name.isBlank()) {
            ArrayList<Employee> ret = new ArrayList<>();
            for (Employee employee : empList) {
                String fullName = employee.getLastName() + employee.getFirstName();
                if (InputUtils.removeAllBlank(fullName).toLowerCase().contains(name.toLowerCase())) {
                    ret.add(employee);
                }
            }
            return ret;
        }
        throw new Exception("Search name cannot be blank!");
    }

    public ArrayList<Employee> sortBySalary() {
        ArrayList<Employee> ret = new ArrayList<>(empList);
        ret.sort(new Comparator<>() {
            @Override
            public int compare(Employee o1, Employee o2) {
                if (o1.getSalary() == o2.getSalary()) {
                    return o1.getId() - o2.getId();
                }
                return o1.getSalary() - o2.getSalary();
            }
        });
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

    public ArrayList<Employee> getEmpList() {
        return empList;
    }
}
