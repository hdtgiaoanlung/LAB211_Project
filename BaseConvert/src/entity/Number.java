package entity;

public class Number {
    private String numString;
    private BaseType base;

    public BaseType getBase() {
        return base;
    }

    public String getNumString() {
        return numString;
    }

    public void setNumString(String numString) {
        this.numString = numString;
    }

    public void setBase(BaseType base) {
        this.base = base;
    }

    public Number(){

    }
}
