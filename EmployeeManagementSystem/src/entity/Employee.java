package entity;

import utils.InputUtils;

public class Employee {
    public static String FORMAT_OUTPUT = "%-5s | %-20s | %-20s | %-10s | %-4s | %-20s | %-30s | %-30s | %-20s | %-10s";
    public static String HEADER_OUTPUT = String.format(FORMAT_OUTPUT, "id", "firstName", "lastName", "sex", "dob", "phone", "email", "address", "agency", "salary");

    private int id;
    private String firstName;
    private String lastName;
    private String phone;
    private String email;
    private String address;
    private int dob;
    private String sex;
    private int salary;
    private String agency;

    public Employee() {

    }

    public int getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPhone() {
        return phone;
    }

    public String getEmail() {
        return email;
    }

    public String getAddress() {
        return address;
    }

    public int getDob() {
        return dob;
    }

    public String getSex() {
        return sex;
    }

    public int getSalary() {
        return salary;
    }

    public String getAgency() {
        return agency;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setDob(int dob) {
        this.dob = dob;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public void setAgency(String agency) {
        this.agency = agency;
    }

    @Override
    public String toString() {
        return String.format(FORMAT_OUTPUT, id + "", firstName, lastName, sex, dob + "", phone, email, address, agency, salary + "");
    }

}
