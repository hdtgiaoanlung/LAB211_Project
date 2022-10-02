package bo;

import model.*;
import utils.StringUtils;

import java.time.YearMonth;

public class CandidateInputter {
    private Candidate c;

    public Candidate getC() {
        return c;
    }

    public CandidateInputter(CandidateType type) {
        switch (type) {
            case Experienced:
                c = new Experienced();
                break;
            case Fresher:
                c = new Fresher();
                break;
            case Intern:
                c = new Intern();
                break;
        }
        c.setType(type);
    }

    public void inputFirstName() {
        String firstName = StringUtils.
                getStringByRegex("Enter first name: ", "Please enter character only", "[A-Za-z ]+");
        c.setFirstName(firstName);
    }

    public void inputLastName() {
        String lastName = StringUtils.
                getStringByRegex("Enter last name: ", "Please enter character only", "[A-Za-z ]+");
        c.setLastName(lastName);
    }

    private void inputInformation() {
        c.setFirstName(StringUtils.
                getStringByRegex("Enter first name: ", "Please enter character only", "[A-Za-z ]+"));
        c.setLastName(StringUtils.
                getStringByRegex("Enter last name: ", "Please enter character only", "[A-Za-z ]+"));
        try {
            c.setYob(StringUtils.
                    getInt("Enter birthday: ", "Please enter number only!", "Birthday is not valid", 1900, 2022));
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
        }
        c.setAddress(StringUtils.getNonEmptyString("Enter address: "));
        c.setPhone(StringUtils.getPhone(10, "Enter phone number: "));
        c.setEmail(StringUtils.getEmail("Enter email: "));
    }

    public void inputFresherInformation() {
        inputInformation();
        try {
            ((Fresher) c).setGraduationDate(StringUtils.getInt("Enter graduation time: ", "Number only!", "Out of range", 1900, YearMonth.now().getYear()));
        } catch (Exception ex) {
            ex.getMessage();
        }
        int rank = StringUtils.getInt("Enter graduation tank (1-Excellent; 2-Good; 3-Fair; 4-Poor)", "Enter number only!", "Input must be in range of 1-4", 1, 4);
        ((Fresher) c).setRank(GraduationRank.getRankByInt(rank));
        ((Fresher) c).setEducation(StringUtils.getNonEmptyString("Enter graduated University: "));
    }

    public void inputExperiencedInformation() {
        inputInformation();
        while (true) {
            try {
                ((Experienced) c).setExpInYear(StringUtils.getInt("Enter years of experience: ", "Number only!", "Out of range!", Integer.MIN_VALUE, Integer.MAX_VALUE));
                break;
            } catch (Exception e) {
                System.err.println(e.getMessage());
            }
        }
        ((Experienced) c).setProSkill(StringUtils.getNonEmptyString("Enter Pro Skill: "));
    }

    public void inputInternInformation() {
        inputInformation();
        ((Intern) c).setMajor(StringUtils.getNonEmptyString("Enter Major: "));
        ((Intern) c).setSemester(StringUtils.getInt("Enter Semester", "Input number only!", "Out of range", 1, 100));
        ((Intern) c).setUniversityName(StringUtils.getNonEmptyString("Enter university name: "));
    }

    public Candidate inputCandidateInformation() {
        switch (c.getType()) {
            case Experienced:
                inputExperiencedInformation();
                break;
            case Fresher:
                inputFresherInformation();
                break;
            case Intern:
                inputInternInformation();
                break;
        }
        return c;
    }
}
