package bo;

import entity.BaseType;
import utils.InputUtils;

import java.util.HashMap;

public class BaseConverter {

    private static String bitString = "0123456789ABCDEF";

    public BaseConverter() {
    }

    private String decToBase(String input, BaseType type) {
        String ret = "";
        if (input.equals("0")) {
            return "0";
        } else {
            int number = Integer.parseInt(InputUtils.removeAllBlank(input));
            while (number != 0) {
                int remainder = number % type.getBaseToInt();
                ret = ret + remainder;
                number /= type.getBaseToInt();
            }
        }
        return ret;
    }

    private String baseToDec(String input, BaseType type) {
        int ret = 0;
        String str = input.toUpperCase();
        for (int i = 0; i < bitString.length(); i++) {
            ret += bitString.indexOf(str.charAt(i)) * Math.pow(type.getBaseToInt(), bitString.length() - 1 - i);
        }
        return ret + "";
    }

    private String binToDec(String input) {
        return baseToDec(input, BaseType.Bin);
    }

    private String hexToDec(String input) {
        return baseToDec(input, BaseType.Hex);
    }

    private String decToBin(String input) {
        return decToBase(input, BaseType.Bin);
    }

    private String decToHex(String input) {
        return decToBase(input, BaseType.Hex);
    }

    private String hexToBin(String input){
        return decToBin(hexToDec(input));
    }

    private String binToHex(String input) {
        return decToHex(binToDec(input));
    }

    private BaseType getConvertBaseByChoice(int choice) {
        switch (choice) {
            case 1:
                return BaseType.Bin;
            case 2:
                return BaseType.Dec;
            case 3:
                return BaseType.Hex;
            default:
                throw new AssertionError();
        }
    }

    public String convertNumberByChoice(String input, int originalChoice, int choice) {
//        BaseType type = getConvertBaseByChoice(originalChoice);
//        BaseType convertBase = getConvertBaseByChoice(choice);
//        if (type == convertBase) {
//            return InputUtils.removeAllBlank(input);
//        } else if (type == BaseType.Dec) {
//            return InputUtils.removeAllBlank(decToBase(input, convertBase));
//        } else if (convertBase == BaseType.Dec) {
//            return InputUtils.removeAllBlank(baseToDec(input, type));
//        } else if (convertBase == BaseType.Bin) {
//            return InputUtils.removeAllBlank(hexToBin(input));
//        } else {
//            return InputUtils.removeAllBlank(binToHex(input));
//        }

    }


}
