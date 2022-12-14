package bo;

import entity.BaseType;
import utils.InputUtils;

public class BaseConverter {

    public static String BIT_STRING = "0123456789ABCDEF";

    public BaseConverter() {
    }

    private String decToBase(String input, BaseType type) {
        StringBuilder ret = new StringBuilder();
        int number = Integer.parseInt(InputUtils.removeAllBlank(input));
        while (number != 0) {
            int remainder = number % type.getBaseToInt();
            ret.insert(0, BIT_STRING.charAt(remainder));
            number /= type.getBaseToInt();
        }
        return ret.toString();
    }

    private String baseToDec(String input, BaseType type) {
        int ret = 0;
        String str = input.toUpperCase();
        for (int i = 0; i < input.length(); i++) {
            ret += BIT_STRING.indexOf(str.charAt(i)) * Math.pow(type.getBaseToInt(), str.length() - 1 - i);
        }
        return ret + "";
    }

    public String convert(String input, BaseType from, BaseType to) throws Exception {
        input = InputUtils.removeAllBlank(input).toUpperCase();
        String ret = input.replaceAll("^0+", "");
        if (ret.isEmpty()) {
            return "0";
        }
        String format = BIT_STRING.substring(0, from.getBaseToInt());
        for (int i = 0; i < input.length(); i++) {
            if (!format.contains(input.charAt(i) + "")) {
                throw new Exception("Invalid Input! Must match type of " + from);
            }
        }
        String dec = baseToDec(ret, from);
        return decToBase(dec, to);
    }
}
