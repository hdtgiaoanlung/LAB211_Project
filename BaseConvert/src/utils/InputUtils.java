package utils;

import java.util.Scanner;

public class InputUtils {
    public static String removeAllBlank(String input) {
        return input.trim().replaceAll("\\s+", "");
    }

    public static String getStringByRegex(String mess, String formatError, String regex) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.print(mess);
            String input = sc.nextLine();
            if (input.matches(regex)) {
                return input;
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

    public static boolean pressYNToContinue() {
        String ret = getStringByRegex("Do you want to continue? (Y/N)", "Only input Y/N please!", "[YNyn]");
        return ret.equalsIgnoreCase("y");
    }

    public static String getNonEmptyString(String mess) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.print(mess);
            String ret = sc.nextLine();
            if (removeAllBlank(ret).isEmpty()) {
                System.err.println("Please input a non-empty String!!!");
            } else {
                return ret;
            }
        }
    }
}
