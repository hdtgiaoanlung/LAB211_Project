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
            System.out.println(mess);
            ret = sc.nextLine();
            if(ret.equalsIgnoreCase("")){
                System.err.println("Please input a non empty string");
            } else {
                return ret;
            }
        }
    }

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
