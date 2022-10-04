package model;

public enum courseName {
    Java, Net, Cpp;

    public String getCourseName() {
        switch (this) {
            case Java:
                return "Java";
            case Net:
                return ".Net";
            case Cpp:
                return "C/C++";
            default:
                throw new AssertionError();
        }
    }

    public static courseName intToCourseName(int type){
        switch (type){
            case 1:
                return Java;
            case 2:
                return Net;
            case 3:
                return Cpp;
            default:
                throw new AssertionError();
        }
    }
}
