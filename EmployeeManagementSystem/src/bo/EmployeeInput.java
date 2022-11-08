package bo;

import entity.Employee;
import utils.InputUtils;

import java.time.YearMonth;

public class EmployeeInput {
    private Employee employee;

    public EmployeeInput() {
        employee = new Employee();
    }

    public Employee inputInformation() {
        employee = new Employee();
        employee.setId(InputUtils.getInt("Enter employee id: ", "Input number only!", "Input must be in range of [1, 9999]", 1, 9999));
        employee.setFirstName(InputUtils.normalFormName(InputUtils.getStringByRegex("Enter first name: ", "Input character only!", "[A-Za-z ]+")));
        employee.setLastName(InputUtils.normalFormName(InputUtils.getStringByRegex("Enter last name: ", "Input character only!", "[A-Za-z ]+")));
        employee.setPhone(InputUtils.getStringByRegex("Enter phone number: ", "Input number only!", "[0-9 ]+"));
        employee.setEmail(InputUtils.getEmail("Enter email: "));
        employee.setAddress(InputUtils.getNonEmptyString("Enter address: "));
        employee.setDob(InputUtils.getInt("Enter birth year: ", "Input number only", "Input must be in range from 1900 to present!", 1900, YearMonth.now().getYear()));
        employee.setSex(InputUtils.getGender("Enter gender: "));
        employee.setAgency(InputUtils.getNonEmptyString("Enter agency: "));
        employee.setSalary(InputUtils.getInt("Enter salary: ", "Input number only!", "Input must be in range of [100, " + Integer.MAX_VALUE + "]!", 100, Integer.MAX_VALUE));
        return employee;
    }

}
