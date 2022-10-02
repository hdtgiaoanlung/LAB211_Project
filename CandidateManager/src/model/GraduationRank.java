package model;

public enum GraduationRank {
    Excellent, Good, Fair, Poor;

    public int getIntType(){
        switch (this){
            case Excellent:
                return 1;
            case Good:
                return 2;
            case Fair:
                return 3;
            case Poor:
                return 4;
            default:
                throw new AssertionError();
        }
    }

    public static GraduationRank getRankByInt(int type){
        switch (type){
            case 1:
                return Excellent;
            case 2:
                return Good;
            case 3:
                return Fair;
            case 4:
                return Poor;
            default:
                throw new AssertionError();
        }
    }
}
