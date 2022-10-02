package controller;

import bo.CandidateInputter;
import bo.CandidateManager;
import model.*;

public class CandidateManagerController {
    private CandidateInputter candidateInputter;
    private CandidateManager candidateManager;

    public Experienced addExperiencedCandidate(){
        candidateInputter = new CandidateInputter(CandidateType.Experienced);
        candidateInputter.inputCandidateInformation();
        Experienced c = (Experienced) candidateInputter.getC();
        candidateManager.addCandidate(c);
        return c;
    }

    public Fresher addFresherCandidate(){
        candidateInputter = new CandidateInputter(CandidateType.Fresher);
        candidateInputter.inputCandidateInformation();
        Fresher c = (Fresher) candidateInputter.getC();
        candidateManager.addCandidate(c);
        return c;
    }

    public Intern addInternCandidate(){
        candidateInputter = new CandidateInputter(CandidateType.Intern);
        candidateInputter.inputCandidateInformation();
        Intern c = (Intern) candidateInputter.getC();
        candidateManager.addCandidate(c);
        return c;
    }
}
