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


    private boolean checkExist(int id) {
        return searchById(id) != -1;
    }

    public boolean addNewEmployee(Employee e) throws Exception {
        if (!checkExist(e.getId())) {
            return empList.add(e);
        }
        throw new Exception("Id is already exists!");
    }

    public ArrayList<Employee> searchByName(String name) {
        ArrayList<Employee> ret = new ArrayList<>();
        for (int i = 0; i < empList.size(); i++) {
            if (empList.get(i).getFirstName().toLowerCase().contains(name.toLowerCase())
                    || empList.get(i).getLastName().toLowerCase().contains(name.toLowerCase())) {
                ret.add(empList.get(i));
            }
        }
        return ret;
    }

    public Employee removeEmployee(int index){
        return empList.remove(index);
    }

    public Employee updateEmployee(int index, Employee e) {
        return empList.set(index, e);
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
        for (Employee e : empList) {
            ret += e.toString();
        }
        return ret;
    }
}
