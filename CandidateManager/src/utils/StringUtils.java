package utils;

import java.util.Scanner;

public class StringUtils {

    public static String removeUnnecessaryBlank(String input){
        return input.trim().replaceAll("\\s+", " ");
    }
    public static String getStringByRegex(String mess, String error, String regex) {
        Scanner scan = new Scanner(System.in);
        String ret = null;
        while (true) {
            System.out.println(mess);
            ret = scan.nextLine();
            if (ret.matches(regex)) {
                return ret;
            } else {
                System.err.println(error);
            }
        }
    }

    public static int getInt(String mess, String errorNumberFormat, String errorOutOfRange, int min, int max) {
        while (true) {
            int ret = Integer.parseInt(getStringByRegex(mess, errorNumberFormat, "[0-9]+"));
            if (ret < min || ret > max) {
                System.err.println(errorOutOfRange);
            } else {
                return ret;
            }
        }
    }

    public static String getNonEmptyString(String mess) {
        Scanner sc = new Scanner(System.in);
        String ret = "";
        while (true) {
            System.out.println(mess);
            ret = sc.nextLine();
            if (ret.equalsIgnoreCase("")) {
                System.err.println("Please input a non-empty String!!!");
                continue;
            } else {
                return ret;
            }
        }
    }

    public static String getPhone(int minLength, String mess) {
        String regex = "[0-9 ]+";
        String ret = "";
        while (true) {
            ret = getStringByRegex(mess, "Please input numbers only!!!", regex);
            if (ret.length() < minLength) {
                System.err.println("Phone must contain at least 10 characters");
            } else {
                return ret;
            }
        }
    }

    public static String getEmail(String mess){
        String regex = "^[A-Za-z](.*)([@]{1})(.{2,})(\\.)(.{2,})";
        String email = getStringByRegex(mess, "Please enter email with format <account name>@<domain>", regex);
        return email;
    }
}
