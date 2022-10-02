package model;

public class Fresher extends Candidate {
    private int graduationDate;
    private GraduationRank rank;
    private String education;

    public int getGraduationDate() {
        return graduationDate;
    }

    public GraduationRank getRank() {
        return rank;
    }

    public String getEducation() {
        return education;
    }

    public void setGraduationDate(int graduationDate) {
        this.graduationDate = graduationDate;
    }

    public void setRank(GraduationRank rank) {
        this.rank = rank;
    }

    public void setEducation(String education) {
        this.education = education;
    }


}
