package ui;

import bo.BaseConverter;
import bo.BaseInputter;
import controller.BaseConvertController;
import utils.InputUtils;

public class Main {
    public static void main(String[] args) {
        BaseConvertController baseConvertController = new BaseConvertController();

        String menu = "WELCOME TO BASE CONVERT SYSTEM\n"
                + "1. Binary\n"
                + "2. Decimal\n"
                + "3. Hexadecimal\n"
                + "4. Exit\n";
        do {
            System.out.println(menu);
            int choice = InputUtils.getInt("Enter your choice: ", "Input numbers only!", "Input must be in range of [1, 4]", 1, 4);
            switch (choice) {
                case 1:
                    String number = InputUtils.getStringByRegex("Enter your binary number: ", "Binary number contains only 0 or 1!", "[01 ]+");
                    baseConvertController.convertByChoice(number, choice);
                    break;
                case 2:
                    number = InputUtils.getStringByRegex("Enter your decimal number: ", "Enter number only!", "[0-9 ]+");
                    baseConvertController.convertByChoice(number, choice);
                    break;
                case 3:
                    number = InputUtils.getStringByRegex("Enter your hexadecimal number: ", "String is not valid!", "[0-9A-Fa-f ]+");
                    baseConvertController.convertByChoice(number, choice);
                    break;
                default:
                    return;
            }
        } while (InputUtils.pressYNToContinue());
    }
}