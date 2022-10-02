package model;

public enum CandidateType {
    Experienced, Fresher, Intern;

    public int getCandidateType() {
        switch (this) {
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

    public static CandidateType candidateTypeToInt(int type) {
        switch (type){
            case 0:
                return Experienced;
            case 1:
                return Fresher;
            case 2:
                return Intern;
            default:
                throw new AssertionError();
        }
    }
}
