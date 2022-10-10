package utils;

public class InputUtils {
    public static String removeAllBlank(String input) {
        return input.trim().replaceAll("\\s+","");
    }


}
