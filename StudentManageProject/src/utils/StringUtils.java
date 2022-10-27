/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import java.util.Scanner;

/**
 * @author dinht
 */
public class StringUtils {

    public static String removeAllBlank(String input) {
        return input.trim().replaceAll("\\s+", "");
    }

    public static String removeUnnecessaryBlank(String input) {
        return input.trim().replaceAll("\\s+", " ");
    }

    public static String normalFormName(String input) {
        input = removeUnnecessaryBlank(input);
        String[] temp = input.split(" ");
        StringBuilder inputBuilder = new StringBuilder();
        for (int i = 0; i < temp.length; i++) {
            inputBuilder.append(String.valueOf(temp[i].charAt(0)).toUpperCase()).append(temp[i].substring(1).toLowerCase());
            if (i < temp.length - 1) {
                inputBuilder.append(" ");
            }
        }
        input = inputBuilder.toString();
        return input;
    }

    public static String getStringByRegex(String mess, String error, String regex) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.print(mess);
            String output = sc.nextLine();
            if(removeAllBlank(output).isEmpty()) {
                System.err.println("Input cannot be empty!");
                continue;
            }
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

    public static boolean pressYNToContinue() {
        String ret = getStringByRegex("Do you want to continue? (Y/N) ", "Input Y/N only!", "[YNyn]");
        return ret.equalsIgnoreCase("y");
    }

    public static boolean chooseUpdateDelete() {
        String choice = StringUtils.getStringByRegex("Update or Delete (U/D)", "Enter U/D only", "[UDud]");
        return choice.equalsIgnoreCase("u");
    }
}
