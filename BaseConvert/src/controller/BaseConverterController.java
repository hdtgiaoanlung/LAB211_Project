package controller;

import bo.BaseConverter;
import bo.NumberInputer;
import entity.BaseType;

public class BaseConverterController {
    BaseConverter baseConverter;
    NumberInputer numberInputer;

    public BaseConverterController() {
        baseConverter = new BaseConverter();
        numberInputer = new NumberInputer();
    }

    public String control(){
        BaseType originalBase = numberInputer.inputOriginalBase();
        BaseType convertBase = numberInputer.getBaseByChoice("Enter base of converted number: ", originalBase);

        String numString = numberInputer.inputNumberByChoice(originalBase);
        String convertedString = baseConverter.convertNumberByChoice(numString, originalBase, convertBase);

        return convertedString;
    }
}
