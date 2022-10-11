package bo;

import entity.Employee;
import utils.InputUtils;

import java.time.YearMonth;
import java.util.Calendar;

public class EmployeeInput {
    private Employee employee;

    public EmployeeInput() {
        employee = new Employee();
    }

    public Employee inputInformation() {
        employee.setFirstName(InputUtils.getStringByRegex("Enter first name: ", "Input character only!", "[A-Za-z ]+"));
        employee.setLastName(InputUtils.getStringByRegex("Enter first name: ", "Input character only!", "[A-Za-z ]+"));
        employee.setPhone(InputUtils.getStringByRegex("Enter phone number: ", "Input number only!", "[0-9 ]+"));
        employee.setEmail(InputUtils.getEmail("Enter email: "));
        employee.setAddress(InputUtils.getStringByRegex("Enter first name: ", "Input character only!", "[A-Za-z ]+"));
        employee.setDob(InputUtils.getInt("Enter birth year: ", "Input number only", "Input must be in range from 1900 to present!", 1900, YearMonth.now().getYear()));
        employee.setSex(InputUtils.getGender("Enter gender: "));
        employee.setSalary(InputUtils.);
        return employee;
    }
}
