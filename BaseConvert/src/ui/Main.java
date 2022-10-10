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
            baseConverterController = new BaseConverterController();
            System.out.println(menu);
            int choice = InputUtils.getInt("Enter your choice", "Input numbers only!", "Input must be in range", 1, 4);
        } while(InputUtils.pressYNToContinue());
    }
}
