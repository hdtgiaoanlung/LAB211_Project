package bo;

import entity.BaseType;
import utils.InputUtils;

public class NumberInputer {
    public NumberInputer() {
    }

    public BaseType getBaseByChoice(int choice) {
        BaseType base = null;
        do {
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
            return base;
        } while (true);
    }

}
