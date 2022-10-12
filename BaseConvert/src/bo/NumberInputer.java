package bo;

import entity.BaseType;
import utils.InputUtils;

public class NumberInputer {
    public NumberInputer() {
    }

    public String inputNumberByChoice(BaseType type) {
        String regex = "";
        switch (type) {
            case Bin:
                regex = "[0-1 ]+";
                break;
            case Dec:
                regex = "[0-9 ]+";
                break;
            case Hex:
                regex = "[0-9A-Fa-f ]+";
                break;
            default:
                System.exit(0);
        }
        String ret = InputUtils.getStringByRegex("Enter your " + type + " value: ", "Input must match your regex: " + regex, regex).toUpperCase();
        return ret;
    }
    public BaseType getBaseByChoice(String mess, BaseType originalBase) {
        BaseType base = null;
        do {
            int choice = InputUtils.getInt(mess, "Input number only!", "Input must be in range of [1, 4]", 1, 4);
            switch (choice) {
                case 1:
                    base = BaseType.Bin;
                    break;
                case 2:
                    base = BaseType.Dec;
                    break;
                case 3:
                    base = BaseType.Hex;
                    break;
                case 4:
                    System.exit(0);
                    break;
            }

            if (base.equals(originalBase)) {
                System.out.println("Base cannot be the same with original one! Try again!");
            } else {
                return base;
            }
        } while (true);
    }

    public BaseType inputOriginalBase(){
        return getBaseByChoice("Enter original base: ", null);
    }
}
