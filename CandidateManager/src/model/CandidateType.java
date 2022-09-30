package model;

public enum CandidateType {
    Experienced, Fresher, Intern;
    public int getCandidateType(){
        switch (this){
            case Experienced:
                return 0;
            case Fresher:
                return 1;
            case Intern:
                return 2;
            default:
                throw new AssertionError();
        }
    }
}
