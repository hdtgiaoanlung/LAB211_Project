package ui;

import controller.BaseConverterController;
import utils.InputUtils;

public class Main {
    public static void main(String[] args) {
        BaseConverterController controller = new BaseConverterController();
        String menu = "WELCOME TO BASE CONVERTER\n" +
                "1. Binary\n" +
                "2. Decimal\n" +
                "3. Hexadecimal\n" +
                "4. Exit\n";
        do {
            System.out.println(menu);
            int originalChoice = InputUtils.getInt("Enter original base: ", "Input number only!", "Input must be in range of [1, 4]", 1, 4);
            if (originalChoice == 4) {
                return;
            }
            int convertChoice = InputUtils.getInt("Enter convert base: ", "Input number only!", "Input must be in range of [1, 4]", 1, 4);
            if (convertChoice == 4) {
                return;
            }
            String numString = InputUtils.getNonEmptyString("Enter your original number: ");
            String output = controller.control(originalChoice, convertChoice, numString);
            System.out.println("Converted String: " + output);
        } while (InputUtils.pressYNToContinue());
    }
}
