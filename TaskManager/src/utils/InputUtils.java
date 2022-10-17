package utils;

import java.util.Scanner;

public class InputUtils {
    public static String getStringByRegex(String mess, String formatError, String regex) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.print(mess);
            String ret = sc.nextLine();
            if (ret.matches(regex)) {
                return ret;
            } else {
                System.err.println(formatError);
            }
        }
    }

    public static int getInt(String mess, String formatError, String outOfRangeError, int min, int max) {
        while (true) {
            int ret = Integer.parseInt(getStringByRegex(mess, formatError, "[0-9 ]+"));
            if (ret < min || ret > max) {
                System.err.println(outOfRangeError);
            } else {
                return ret;
            }
        }
    }
}
