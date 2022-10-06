package bo;

import model.BaseType;

public class BaseInputter {
    public BaseInputter() {

    }

    public BaseType inputBase(int type){
        switch (type) {
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
}
