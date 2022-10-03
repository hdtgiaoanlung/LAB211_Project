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

    public static courseName stringToCourseName(String type){
        type = type.toLowerCase();
        switch (type){
            case "java":
                return Java;
            case ".net":
                return Net;
            case "c/c++":
                return Cpp;
            default:
                throw new AssertionError();
        }
    }
}
