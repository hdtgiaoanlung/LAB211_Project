package entity;

public enum BaseType {
    Bin, Dec, Hex;

    public int getBaseToInt() {
        return switch (this) {
            case Bin -> 2;
            case Dec -> 10;
            case Hex -> 16;
        };
    }
}
