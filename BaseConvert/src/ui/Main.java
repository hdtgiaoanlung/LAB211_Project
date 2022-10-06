package ui;

import bo.BaseConverter;
import bo.BaseInputter;
import controller.BaseConvertController;
import utils.InputUtils;

public class Main {
    public static void main(String[] args) {
        BaseConvertController baseConvertController;

        String menu = "WELCOME TO BASE CONVERT SYSTEM\n"
                + "1. Binary\n"
                + "2. Decimal\n"
                + "3. Hexadecimal\n";
        do {
            System.out.println(menu);

        } while (InputUtils.pressYNToContinue());
    }
}