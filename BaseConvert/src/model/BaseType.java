package model;

public enum BaseType {
    Hex, Dec, Bin;
    public int baseToInt(){
        switch (this){
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
