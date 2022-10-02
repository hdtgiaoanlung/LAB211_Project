package model;

public class Candidate {
    private int Id;
    private String firstName;
    private String lastName;
    private int yob;
    private String Address;
    private String phone;
    private String email;
    private CandidateType type;

    public Candidate() {
    }

    public int getId() {
        return Id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getYob() {
        return yob;
    }

    public String getAddress() {
        return Address;
    }

    public String getPhone() {
        return phone;
    }

    public String getEmail() {
        return email;
    }

    public CandidateType getType() {
        return type;
    }

    public void setId(int id) {
        Id = id;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setYob(int yob) {
        this.yob = yob;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setType(CandidateType type) {
        this.type = type;
    }

    public String getFullName() {
        return firstName + " " + lastName;
    }

    @Override
    public String toString() {
        String ret = String.format("%-5s | %-20s %-20s | %-4s | %-30s | %-20s | %-100s | %-1s", firstName, lastName, yob + "", Address, phone, email, type.getCandidateType() + "");
        return ret;
    }
}
