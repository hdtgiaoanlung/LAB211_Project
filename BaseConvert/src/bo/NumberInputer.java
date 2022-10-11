package bo;

import entity.Number;
import utils.InputUtils;

public class NumberInputer {

    private Number number;
    public NumberInputer() {
        number = new Number();
    }

    public Number getNumber(){
        return number;
    }

    public String inputNumberByChoice(int choice) {
        String regex = "";
        switch (choice) {
            case 1:
                regex = "[0-1 ]+";
                break;
            case 2:
                regex = "[0-9 ]+";
                break;
            case 3:
                regex = "[0-9A-Fa-f ]+";
                break;
            case 4:
                return "";
            default:
                throw new AssertionError();
        }
        String ret = InputUtils.getStringByRegex("Enter your value: ", "Input must match your regex: " + regex, regex).toUpperCase();
        number.setNumString(ret);
        return ret;
    }
}
