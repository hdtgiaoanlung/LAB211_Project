package bo;

public class BaseConverter {
    public BaseConverter() {

    }

    public String decToBin(int number) {
        String ret = "";
        int cloneNumber = number;
        while (cloneNumber != 0) {
            int remainder = cloneNumber % 2;
            cloneNumber = cloneNumber / 2;
            ret += remainder + "";
        }
        return ret;
    }
}
