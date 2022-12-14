/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import java.text.SimpleDateFormat;
import java.time.ZonedDateTime;
import java.util.Date;
import java.util.Scanner;

/**
 *
 * @author Trung.Hoang
 */
public class Utils {

    public static String getString(String str) {
        String result = "";
        boolean check = true;
        do {
            System.out.print(str);
            Scanner sc = new Scanner(System.in);
            String tmp = sc.nextLine();
            if (!tmp.isEmpty()) {
                result = tmp;
                check = false;
            }
        } while (check);
        return result;
    }

    public static int getInt(String str) {
        int number;
        while (true) {
            try {
                System.out.print(str);
                Scanner sc = new Scanner(System.in);
                number = Integer.parseInt(sc.nextLine());
                return number;
            } catch (NumberFormatException e) {
                System.out.println("Error, please input number! ");
            }
        }
    }

    public static boolean getBoolean(String message) {
        boolean result = false;
        boolean check = true;
        do {
            System.out.println(message);
            Scanner sc = new Scanner(System.in);
            String tmp = sc.nextLine();
            try {
                result = Boolean.parseBoolean(tmp);
                check = false;
            } catch (NumberFormatException E) {
            }
        } while (check);
        return result;
    }

    public static String updateString(String oldValue, String str) {
        String result = oldValue;
        System.out.print(str);
        Scanner sc = new Scanner(System.in);
        String tmp = sc.nextLine();
        if (!tmp.isEmpty()) {
            result = tmp;
        }
        return result;
    }

    public static int updateInt(int oldValue, String str) {
        int result = oldValue;
        boolean check = true;
        try {
            do {
                System.out.print(str);
                Scanner sc = new Scanner(System.in);
                result = Integer.parseInt(sc.nextLine());
                check = false;
            } while (check);
        } catch (Exception e) {
            System.out.print("Input number: ");
        }
        return result;
    }

    public static boolean updateBoolean(boolean oldValue, String message) {
        boolean result = oldValue;
        System.out.println(message);
        Scanner sc = new Scanner(System.in);
        String tmp = sc.nextLine();
        try {
            if (!tmp.isEmpty()) {
                result = Boolean.parseBoolean(tmp);
            }
        } catch (NumberFormatException E) {
        }

        return result;
    }

    public static int getYear(String str) {
        int number;
        ZonedDateTime zonedDateTime = ZonedDateTime.now();
        int yearCurrent = zonedDateTime.getYear();
        while (true) {
            try {
                System.out.print(str);
                Scanner sc = new Scanner(System.in);
                number = Integer.parseInt(sc.nextLine());
                if (number < yearCurrent) {
                    return number;
                } else {
                    System.out.println("The number of years cannot be greater than the year of manufacture, please re-enter!");
                }
            } catch (NumberFormatException e) {
                System.out.println("Error, please input number! ");
            }
        }
    }

    public static int updateYear(int oldValue, String str) {
        int result = oldValue;
        ZonedDateTime zonedDateTime = ZonedDateTime.now();
        int yearCurrent = zonedDateTime.getYear();
        boolean check = true;
        try {
            do {
                System.out.print(str);
                Scanner sc = new Scanner(System.in);
                result = Integer.parseInt(sc.nextLine());
                if (result < yearCurrent) {
                    check = false;
                } else {
                    System.out.println("The number of years cannot be greater than the year of manufacture, please re-enter!");
                }
            } while (check);
        } catch (Exception e) {
            System.out.print("Input number: ");
        }
        return result;
    }

    public static int getGreaterThan0(String str) {
        int number;
        while (true) {
            try {
                System.out.print(str);
                Scanner sc = new Scanner(System.in);
                number = Integer.parseInt(sc.nextLine());
                if (number > 0) {
                    return number;
                } else {
                    System.out.println("Invalid price, please re-enter number > 0!");
                }
            } catch (NumberFormatException e) {
                System.out.println("Error, please input number! ");
            }
        }
    }

    public static int updateGreaterThan0(int oldValue, String str) {
        int result = oldValue;
        boolean check = true;
        try {
            do {
                System.out.print(str);
                Scanner sc = new Scanner(System.in);
                result = Integer.parseInt(sc.nextLine());
                if (result > 0) {
                    check = false;
                } else {
                    System.out.println("Invalid price, please re-enter number > 0!");
                }
            } while (check);
        } catch (Exception e) {
            System.out.print("Error, please input number!");
        }
        return result;
    }

    public static String getYesNo(String str) {
        String result = "";
        boolean check = true;
        do {
            System.out.print(str);
            Scanner sc = new Scanner(System.in);
            String tmp = sc.nextLine();
            if (!tmp.isEmpty() && (tmp.equalsIgnoreCase("Yes") || tmp.equalsIgnoreCase("No"))) {
                result = tmp;
                check = false;
            } else {
                System.out.println("Enter the wrong type, please re-enter (Yes/No)!");
            }

        } while (check);
        return result;
    }

    public static String updateYesNo(String oldValue, String str) {
        String result = oldValue;
        boolean check = true;
        do {
            System.out.print(str);
            Scanner sc = new Scanner(System.in);
            String tmp = sc.nextLine();
            if (!tmp.isEmpty() && (tmp.equalsIgnoreCase("Yes") || tmp.equalsIgnoreCase("No") || tmp.equalsIgnoreCase(" "))) {
                result = tmp;
                check = false;
            } else {
                System.out.println("Enter the wrong type, please re-enter (Yes/No)!");
            }
        } while (check);
        return result;
    }

    public static double getDouble(String str) {
        double number;
        boolean check = true;
        while (true) {
            try {
                do {
                    System.out.print(str);
                    Scanner sc = new Scanner(System.in);
                    number = Double.parseDouble(sc.nextLine());
                    if (number > 0) {
                        check = false;
                        return number;
                    } else {
                        System.out.println("Invalid price, please re-enter number > 0!");
                    }
                } while (check);
            } catch (NumberFormatException e) {
                System.out.println("Error, please input number! ");
            }
        }
    }

    public static double updateDouble(double oldValue, String str) {
        double result = oldValue;
        boolean check = true;
        try {
            do {
                System.out.print(str);
                Scanner sc = new Scanner(System.in);
                result = Double.parseDouble(sc.nextLine());
                check = false;
                if (result > 0) {
                    check = false;
                } else {
                    System.out.println("Invalid price, please re-enter number > 0!");
                }
            } while (check);
        } catch (Exception e) {
            System.out.print("Error, please input number! ");
        }
        return result;
    }

    public static String getDate(String str) {
        String result = null;
        SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        try {
            System.out.print(str);
            Scanner sc = new Scanner(System.in);
            Date date = df.parse(sc.nextLine());
            result = df.format(date);
        } catch (Exception e) {
        }
        return result;
    }

    public static void printMenuForManager() {
        System.out.println("        TABLE MENU       ");
        System.out.println("1. Search Asset By Name");
        System.out.println("2. Create New Asset");
        System.out.println("3. Update Asset's Information");
        System.out.println("4. Approve the request of employee");
        System.out.println("5. Show List Of Borrow Asset");
        System.out.println("6. Back to Login");
        System.out.println("Other. Quit");
        System.out.println("");
    }

    public static void printMenuForEmployee() {
        System.out.println("        TABLE MENU       ");
        System.out.println("1. Search Asset By Name");
        System.out.println("2. Borrow The Assets (LAB 3)");
        System.out.println("3. Cancel Request (LAB 3)");
        System.out.println("4. Return Request (LAB 3)");
        System.out.println("5. Back to Login");
        System.out.println("Other. Quit");
        System.out.println("");
    }

    public static void printMenuLogin() {
        System.out.println("------------ LOGIN ------------");
        System.out.println("|    1. Login for Manager     |");
        System.out.println("|    2. Login for Employee    |");
        System.out.println("|         Other. Quit         |");
        System.out.println("-------------------------------\n");
    }
}
