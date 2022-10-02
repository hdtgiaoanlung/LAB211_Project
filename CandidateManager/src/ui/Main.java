package ui;

import controller.CandidateManagerController;

import java.time.YearMonth;
import java.util.Calendar;

public class Main {
    public static void main(String[] args) {
        CandidateManagerController cmc = new CandidateManagerController();
        System.out.println("CANDIDATE MANAGEMENT SYSTEM");
        String menu = "1. Experienced\n"
                + "2. Fresher\n"
                + "3. Intern\n"
                + "4. Searching\n"
                + "5. Exit\n\n"
                + "(Please choose 1 to Create Experienced Candidate, 2 to Create Fresher Candidate, 3 to Create Intern Candidate)\n"
                + "Your choice: ";
        int year = Calendar.getInstance().get(Calendar.YEAR);
        System.out.println(year);
    }
}
