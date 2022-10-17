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


    public String control(int originalChoice, int convertChoice, String numString) throws Exception {
        BaseType originalBase = numberInputer.getBaseByChoice(originalChoice);
        BaseType convertBase = numberInputer.getBaseByChoice(convertChoice);
        return baseConverter.convert(numString, originalBase, convertBase);
    }
}
