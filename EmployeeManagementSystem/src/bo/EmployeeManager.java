package bo;

import entity.Employee;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class EmployeeManager {
    private ArrayList<Employee> empList;

    public EmployeeManager() {
        empList = new ArrayList<>();
    }

    public void addNewEmployee(Employee e) {
        if (checkExist(e.getId()) == -1) {
            empList.add(e);
        } else {
            System.err.println("The id already exists!");
        }
    }

    public ArrayList<Employee> searchByName(String name) {
        ArrayList<Employee> ret = new ArrayList<>();
        for (int i = 0; i < empList.size(); i++) {
            if (empList.get(i).getFirstName().toLowerCase().contains(name.toLowerCase()) || empList.get(i).getLastName().toLowerCase().contains(name.toLowerCase())) {
                ret.add(empList.get(i));
            }
        }
        return ret;
    }

    public void removeEmployee(int id) {
        int index = checkExist(id);
        if (index == -1) {
            System.out.println("Id not found!");
        } else {
            empList.remove(index);
        }
    }

    public void updateEmployee(int index, Employee e) {
        empList.set(index, e);
    }

    public int checkExist(int id) {
        for (int i = 0; i < empList.size(); i++) {
            if (empList.get(i).getId() == id) {
                return i;
            }
        }
        return -1;
    }

    public ArrayList<Employee> sortBySalary() {
        ArrayList<Employee> ret = empList;
        Collections.sort(ret, new Comparator<Employee>() {
            @Override
            public int compare(Employee employee, Employee t1) {
                return employee.getSalary() - t1.getSalary();
            }
        });
        return ret;
    }

    @Override
    public String toString() {
        String ret = "";
        for ( Employee e : empList) {
            ret += e.toString();
        }
        return ret;
    }
}
