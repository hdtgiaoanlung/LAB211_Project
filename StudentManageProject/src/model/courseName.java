package model;

public enum courseName {
    Java, Net, Cpp;

    public static courseName intToCourseName(int type){
        return switch (type) {
            case 1 -> Java;
            case 2 -> Net;
            case 3 -> Cpp;
            default -> throw new AssertionError();
        };
    }

}
