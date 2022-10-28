package bo;

import model.Matrix;
import utils.InputUtils;

public class MatrixInput {
    public Matrix inputMatrix(int order) throws Exception {
        System.out.println("========== INPUT MATRIX " + order + " ==========");
        int row = InputUtils.getInt("Enter number of rows: ", "Input number only!", "Input must be positive!", 1, Integer.MAX_VALUE);
        int column = InputUtils.getInt("Enter number of columns: ", "Input number only!", "Input must be positive!", 1, Integer.MAX_VALUE);
        int[][] matrix = InputUtils.input2DArray(row, column);
        return new Matrix(row, column, matrix);
    }
}
