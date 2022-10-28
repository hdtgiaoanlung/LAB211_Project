package utils;

import java.util.Scanner;

public class InputUtils {
    public static String getStringByRegex(String mess, String error, String regex) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.print(mess);
            String output = sc.nextLine();
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

    public static int[][] input2DArray(int rows, int column) throws Exception {
        if (rows < 1 || column < 1) {
            throw new Exception("Cannot initialize array!");
        } else {
            int[][] array = new int[rows][column];
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < column; j++) {
                    array[i][j] = getInt("Enter matrix [" + (i + 1) + "][" + (j + 1) + "]", "Input number only!", "Input must be in range of Integer", Integer.MIN_VALUE, Integer.MAX_VALUE);
                }
            }
            return array;
        }
    }

}
