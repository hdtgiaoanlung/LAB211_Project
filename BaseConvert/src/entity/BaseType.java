package entity;

public enum BaseType {
    Bin, Dec, Hex;
    public  int getBaseToInt(){
        switch (this) {
            case Bin:
                return 2;
            case Dec:
                return 10;
            case Hex:
                return 16;
            default:
                throw new AssertionError();
        }
    }
}
