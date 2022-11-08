package controller;

import bo.CandidateInputter;
import bo.CandidateManager;
import model.*;
import utils.StringUtils;

import java.util.ArrayList;

public class CandidateManagerController {
    private CandidateInputter candidateInputter;
    private CandidateManager candidateManager;

    public CandidateManagerController() {
        candidateManager = new CandidateManager();
    }


    private Candidate addCandidate(CandidateType type) {
        candidateInputter = new CandidateInputter(type);
        candidateInputter.inputCandidateInformation();
        Candidate c = candidateInputter.getC();
        candidateManager.addCandidate(c);
        return c;
    }

    private Experienced addExperiencedCandidate() {
        Experienced c = (Experienced) addCandidate(CandidateType.Experienced);
        return c;
    }

    private Fresher addFresherCandidate() {
        Fresher c = (Fresher) addCandidate(CandidateType.Fresher);
        return c;
    }

    private Intern addInternCandidate() {
        Intern c = (Intern) addCandidate(CandidateType.Intern);
        return c;
    }

    public void addCandidateByChoice(int choice) {
        ArrayList<Candidate> ret = new ArrayList<>();
        do {
            switch (choice) {
                case 1:
                    ret.add(addExperiencedCandidate());
                    break;
                case 2:
                    ret.add(addFresherCandidate());
                    break;
                case 3:
                    ret.add(addInternCandidate());
                    break;
            }
        } while (StringUtils.pressYNToContinue("Do you want to continue (Y/N)"));
        System.out.println("List of added Candidate: \n");
        for (Candidate c : ret) {
            System.out.println(c.getFullName());
        }
    }

    public void displayAllCandidate() {
        System.out.println("List of Candidates: ");
        System.out.println(candidateManager);
    }

    public void searchingByName(){
        displayAllCandidate();
        String name
                = StringUtils.getStringByRegex("Enter search name: ", "Enter characters only!", "[A-Za-z ]+");
        int type = StringUtils.getInt("Enter type of candidate: (0: Experienced; 1: Fresher; 2: Intern)", "Enter number only!", "Out of range!", 0, 2);
        ArrayList<Candidate> listFound = candidateManager.searchByNameAndType(name, CandidateType.candidateTypeToInt(type));
        if(listFound.isEmpty()){
            System.out.println("No Candidates found!");
        } else {
            System.out.println("The candidate found: ");
            for(Candidate c : listFound){
                System.out.println(c.toString());
            }
        }
    }
}
