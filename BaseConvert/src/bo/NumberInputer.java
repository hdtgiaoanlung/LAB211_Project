package bo;

import entity.BaseType;
import utils.InputUtils;

public class NumberInputer {
    public NumberInputer() {
    }

    public BaseType getBaseByChoice(int choice) {
        do {
            switch (choice) {
                case 1:
                    return BaseType.Bin;
                case 2:
                    return BaseType.Dec;
                case 3:
                    return BaseType.Hex;
                case 4:
                    System.exit(0);
                default:
                    throw new RuntimeException("Please enter a valid base type!");
            }
        } while (true);
    }
}
