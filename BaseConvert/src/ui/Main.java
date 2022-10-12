package ui;

import bo.BaseConverter;
import bo.NumberInputer;
import controller.BaseConverterController;
import entity.BaseType;
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
            String output = controller.control();
            System.out.println("Converted String: " + output);
        } while(InputUtils.pressYNToContinue());
    }
}
