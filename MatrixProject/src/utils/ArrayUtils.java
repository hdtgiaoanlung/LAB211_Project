package utils;

import model.Matrix;

public class ArrayUtils {
    public static void display2DArray(int[][] array) {
        int row = array.length;
        int col = array[0].length;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                System.out.format("[" + array[i][j] + "]");
            }
            System.out.println();
        }
    }
}
