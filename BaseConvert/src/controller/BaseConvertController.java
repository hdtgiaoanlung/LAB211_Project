package controller;

import bo.BaseConverter;
import utils.InputUtils;

public class BaseConvertController {

    BaseConverter baseConverter;
    public BaseConvertController() {

    }

    public String convertByChoice(String number, int choice) {
        int baseChoice = InputUtils.getInt("Enter your base to convert (1. Binary; 2. Decimal; 3. Hexadecimal)", "Input number only!", "Input must be in range of [1, 3]", 1, 3);
        if (baseChoice == choice) {
            return number.trim().toUpperCase();
        } else {
            switch (baseChoice) {
                case 1:

            }
        }
    }
}
