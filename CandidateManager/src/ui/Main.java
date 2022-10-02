package ui;

import bo.CandidateManager;
import controller.CandidateManagerController;
import utils.StringUtils;

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
                + "(Please choose 1 to Create Experienced Candidate, 2 to Create Fresher Candidate, 3 to Create Intern Candidate)\n";
        System.out.println(menu);
        while (true) {
            int choice = StringUtils.getInt("Enter your choice: ", "Enter number only", "Out or range [1, 5]", 1, 5);
            switch (choice) {
                case 1:
                case 2:
                case 3:
                    cmc.addCandidateByChoice(choice);
                    break;
                case 4:
                    cmc.searchingByName();

                    break;
                case 5:
                    return;
                default:
                    throw new AssertionError();
            }
        }
    }
}
