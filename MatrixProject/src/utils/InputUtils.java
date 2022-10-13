package utils;

import java.util.Scanner;

public class InputUtils {
    public static String getStringByRegex(String mess, String error, String regex) {
        Scanner sc = new Scanner(System.in);
        String output = null;
        while (true) {
            System.out.println(mess);
            output = sc.nextLine();
            if (output.matches(regex)) {
                return output;
            } else {
                System.err.println(error);
            }
        }
    }

    public static int getInt(String mess, String formatErrorString, String outOfRange, int min, int max) {
        while (true) {
            int ret = Integer.parseInt(getStringByRegex(mess, formatErrorString, "[0-9]+"));
            if (ret < min || ret > max) {
                System.err.println(outOfRange);
            } else {
                return ret;
            }
        }
    }

    public static boolean pressYNToContinue(){
        String ret = getStringByRegex("Do you want to continue? (Y/N) ", "Input Y/N only!", "[YNyn]");
        return ret.equalsIgnoreCase("y");
    }
}
