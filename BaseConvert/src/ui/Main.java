package ui;

import controller.BaseConverterController;
import utils.InputUtils;

public class Main {
    public static void main(String[] args) {
        BaseConverterController controller = new BaseConverterController();
        String menu = """
                WELCOME TO BASE CONVERTER
                1. Binary
                2. Decimal
                3. Hexadecimal
                4. Exit
                """;
        do {
            try {
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
                System.out.println("Converted Number: " + output);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        } while (InputUtils.pressYNToContinue());
    }
}
