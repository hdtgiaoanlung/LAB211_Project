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
        String format = BaseConverter.BIT_STRING.substring(0, originalBase.getBaseToInt()) ;
        for(int i = 0; i < numString.length(); i++) {
            if (!format.contains(numString.charAt(i) + "")) {
                throw new Exception("Invalid input! Number must match type of " + originalBase);
            }
        }
        BaseType convertBase = numberInputer.getBaseByChoice(convertChoice);
        return baseConverter.convert(numString, originalBase, convertBase);
    }
}
