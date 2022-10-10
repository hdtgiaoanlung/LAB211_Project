package bo;

import entity.BaseType;
import jdk.internal.util.xml.impl.Input;
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

    public String binToDec(String input) {
        return baseToDec(input, BaseType.Bin);
    }

    public String hexToDec(String input) {
        return baseToDec(input, BaseType.Hex);
    }

    public String decToBin(String input) {
        return decToBase(input, BaseType.Bin);
    }

    public String decToHex(String input) {
        return decToBase(input, BaseType.Hex);
    }

    public String hexToBin(String input){
        return decToBin(hexToDec(input));
    }

    public String binToHex(String input) {
        return decToHex(binToDec(input));
    }
}
