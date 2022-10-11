package ui;

import controller.BaseConverterController;
import utils.InputUtils;

public class Main {
    public static void main(String[] args) {

        BaseConverterController baseConverterController;

        String menu = "WELCOME TO BASE CONVERTER\n" +
                "1. Binary\n" +
                "2. Decimal\n" +
                "3. Hexadecimal\n" +
                "4. Exit\n";
        do {
            String number = "";
            baseConverterController = new BaseConverterController();
            System.out.println(menu);
            int choice = InputUtils.getInt("Enter the base of your number: ", "Input number only!", "Input must be in range of [1, 4]", 1, 4);
            switch (choice){
                case 1:
                case 2:
                case 3:
                    number = baseConverterController.generateNumberByChoice(choice);
                    break;
                case 4:
                    return;
                default:
                    throw new AssertionError();
            }
            int convertChoice = InputUtils.getInt("Which base do you want to convert? (1. Binary / 2. Decimal / 3. Hexadecimal) ", "Input number only!", "Input must be in range of [1, 4]", 1, 4);

        } while(InputUtils.pressYNToContinue());
    }
}
