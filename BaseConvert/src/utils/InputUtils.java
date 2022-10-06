package utils;

import java.util.Scanner;

public class InputUtils {

    public static String getStringByRegex(String mess, String error, String regex) {
        Scanner scan = new Scanner(System.in);
        while (true) {
            System.out.print(mess);
            String ret = scan.nextLine();
            if (ret.matches(regex)) {
                return ret;
            } else {
                System.err.println(error);
            }
        }
    }

    public static int getInt(String mess, String errorFormat, String outOfRangeError, int min, int max) {
        while (true) {
            int ret = Integer.parseInt(getStringByRegex(mess, errorFormat, "[0-9]+"));
            if (ret < min || ret > max) {
                System.err.println(outOfRangeError);
            } else {
                return ret;
            }
        }
    }
}
