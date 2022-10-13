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
        employee.setId(InputUtils.getInt("Enter employee id: ", "Input number only!", "Input must be in range of [1, 9999]", 1, 9999));
        employee.setFirstName(InputUtils.getStringByRegex("Enter first name: ", "Input character only!", "[A-Za-z ]+"));
        employee.setLastName(InputUtils.getStringByRegex("Enter last name: ", "Input character only!", "[A-Za-z ]+"));
        employee.setPhone(InputUtils.getStringByRegex("Enter phone number: ", "Input number only!", "[0-9 ]+"));
        employee.setEmail(InputUtils.getEmail("Enter email: "));
        employee.setAddress(InputUtils.getNonEmptyString("Enter address: "));
        employee.setDob(InputUtils.getInt("Enter birth year: ", "Input number only", "Input must be in range from 1900 to present!", 1900, YearMonth.now().getYear()));
        employee.setSex(InputUtils.getGender("Enter gender: "));
        employee.setSalary(InputUtils.getInt("Enter salary: ", "Input number only!", "Input must be in range of [100, 999999000]", 100, 999999000));
        employee.setAgency(InputUtils.getNonEmptyString("Enter agency: "));
        return employee;
    }

}
