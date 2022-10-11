package controller;

import bo.BaseConverter;
import bo.NumberInputer;
import entity.BaseType;

import java.util.ArrayList;

public class BaseConverterController {

    private BaseConverter baseConverter;
    private NumberInputer numberInputer;

    public BaseConverterController() {
        numberInputer = new NumberInputer();
    }

    public String generateNumberByChoice(int choice) {
        return numberInputer.inputNumberByChoice(choice);
    }

    public String convertByChoice(String input, ){

    }
}
