package utils;

public class ArrayUtils {
    public static void display2DArray(int[][] array) {
        int col = array[0].length;
        for (int[] ints : array) {
            for (int j = 0; j < col; j++) {
                System.out.format("[" + ints[j] + "]");
            }
            System.out.println();
        }
    }
}
