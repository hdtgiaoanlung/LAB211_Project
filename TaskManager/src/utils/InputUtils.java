package utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
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

    public static String removeAllBlank(String input) {
        return input.trim().replaceAll("\\s+", "");
    }

    public static String removeUnnecessaryBlank(String input) {
        return input.trim().replaceAll("\\s+", " ");
    }

    public static boolean pressYNToContinue(){
        String ret = getStringByRegex("Do you want to continue? (Y/N) ", "Input Y/N only!", "[YNyn]");
        return ret.equalsIgnoreCase("y");
    }

    public static String getNonEmptyString(String mess) {
        Scanner sc = new Scanner(System.in);
        String ret = "";
        while (true) {
            System.out.println(mess);
            ret = sc.nextLine();
            if(ret.equalsIgnoreCase("")){
                System.err.println("Please input a non empty string");
            } else {
                return ret;
            }
        }
    }

    public static Date inputDate(String mess){
        Scanner scan = new Scanner(System.in);
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-mm-yyyy");
        System.out.println(mess);
        String dateString = scan.nextLine();
        Date date = null;
        try {
            date = dateFormat.parse(dateString);
        } catch (ParseException e) {
            System.err.println("Date must match the format dd-mm-yyyy");
        }
        return date;
    }

    public static float getFloat(String mess, String formatError, String outOfRangeError, float min, float max){
        while (true) {
            float ret = Float.parseFloat(getStringByRegex(mess, formatError, "[0-9 ].+"));
            if (ret < min || ret > max) {
                System.err.println(outOfRangeError);
            } else {
                return ret;
            }
        }
    }
}
