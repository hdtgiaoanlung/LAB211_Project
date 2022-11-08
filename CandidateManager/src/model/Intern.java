package model;

public class Intern extends Candidate {
    private String major;
    private int semester;
    private String universityName;

    public void setMajor(String major) {
        this.major = major;
    }

    public void setSemester(int semester) {
        this.semester = semester;
    }

    public void setUniversityName(String universityName) {
        this.universityName = universityName;
    }

    public String getMajor() {
        return major;
    }

    public int getSemester() {
        return semester;
    }

    public String getUniversityName() {
        return universityName;
    }
}
