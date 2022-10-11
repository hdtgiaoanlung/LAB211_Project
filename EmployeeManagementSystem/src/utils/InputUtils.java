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

    public static String getEmail(String mess){
        String regex = "^[A-Za-z](.*)([@]{1})(.{2,})(\\.)(.{2,})";
        String email = getStringByRegex(mess, "Please enter email with format <account name>@<domain>", regex);
        return email;
    }

    public static String getGender(String mess){
        String regex = "male|female|Male|Female";
        String gender = getStringByRegex(mess, "Please enter valid gender!", regex);
        return gender;
    }

    public static boolean pressYNToContinue(){
        String ret = getStringByRegex("Do you want to continue? (Y/N)", "Input Y/N only!", "[YNyn]");
        return ret.equalsIgnoreCase("y");
    }

    public static String removeUnnecessaryBlank(String input) {
        return input.trim().replaceAll("\\s+", " ");
    }



    public static String normalFormName(String input) {
        input = removeUnnecessaryBlank(input);
        String temp[] = input.split(" ");
        input = "";
        for (int i = 0; i < temp.length; i++) {
            input += String.valueOf(temp[i].charAt(0)).toUpperCase() + temp[i].substring(1);
            if (i < temp.length - 1) {
                input += " ";
            }
        }
        return input;
    }

    public static String getNonEmptyString(String mess) {
        Scanner sc = new Scanner(System.in);
        String ret = "";
        while (true) {
            System.out.print(mess);
            ret = sc.nextLine();
            if (ret.equalsIgnoreCase("")) {
                System.err.println("Please input a non-empty String!!!");
                continue;
            } else {
                return ret;
            }
        }
    }
}
