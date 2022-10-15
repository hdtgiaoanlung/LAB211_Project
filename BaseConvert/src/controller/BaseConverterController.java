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


    public String control(int originalChoice, int convertChoice, String numString) {
        BaseType originalBase = numberInputer.getBaseByChoice(originalChoice);
        BaseType convertBase  = numberInputer.getBaseByChoice(convertChoice);
        try {
            String test = baseConverter.getBitString().substring(0, originalBase.getBaseToInt());
            for (int i = 0; i < numString.length(); i++) {
                if (!test.contains(numString.toUpperCase().charAt(i) + "")) {
                    throw new Exception("Invalid input number. Does not match base type " + originalBase);
                }
            }
            if (originalBase == convertBase) {
                return numString.replaceAll("0+", "");
            }
            if (convertBase.equals(BaseType.Dec)) {
                return baseConverter.baseToDec(numString, originalBase);
            }
            switch (originalBase) {
                case Bin:
                    return baseConverter.binToHex(numString);
                case Dec:
                    return baseConverter.decToBase(numString, convertBase);
                case Hex:
                    return baseConverter.hexToBin(numString);
                default:
                    throw new AssertionError();
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        return null;
    }
}
