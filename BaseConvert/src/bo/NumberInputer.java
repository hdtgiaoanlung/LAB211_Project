package bo;

import entity.BaseType;
import entity.Number;
import utils.InputUtils;

public class NumberInputer {
    private Number number;

    public NumberInputer() {
        number = new Number();
    }

    public Number getNumber() {
        return number;
    }

    public void inputBase(int choice){
        switch (choice) {
            case 1:
                number.setBase(BaseType.Bin);
                break;
            case 2:
                number.setBase(BaseType.Dec);
                break;
            case 3:
                number.setBase(BaseType.Hex);
                break;
            default:
                throw new AssertionError();
        }
    }
    public void inputBinaryNumber() {
        number.setNumString(InputUtils.getStringByRegex("Enter your binary number: ", "Input must be valid (0 or 1 only)!", "[01 +]"));
    }

    public void inputDecimalNumber() {
        number.setNumString(InputUtils.getStringByRegex("Enter your decimal number: ", "Input must be valid!", "[0-9 +]"));
    }

    public void inputHexNumber() {
        number.setNumString(InputUtils.getStringByRegex("Enter your hexadecimal number: ", "Input must be valid!", "[0-9A-Fa-f +]"));
    }

    public void inputNumberByChoice(int choice) {
        switch (choice) {
            case 1:
                inputBinaryNumber();
                break;
            case 2:
                inputDecimalNumber();
                break;
            case 3:
                inputHexNumber();
                break;
            default:
                throw new AssertionError();
        }
    }
}
