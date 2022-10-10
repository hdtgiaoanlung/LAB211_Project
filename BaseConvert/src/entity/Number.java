package entity;

import java.util.HashMap;

public class Number {
    private String numString;
    private BaseType base;

    public Number() {

    }

    public Number(String numString, BaseType base) {
        this.numString = numString;
        this.base = base;
    }

    public String getNumString() {
        return numString;
    }

    public BaseType getBase() {
        return base;
    }

    public void setNumString(String numString) {
        this.numString = numString;
    }

    public void setBase(BaseType base) {
        this.base = base;
    }

}
