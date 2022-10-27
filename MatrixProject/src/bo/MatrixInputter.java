package bo;

import model.Matrix;
import utils.ArrayUtils;
import utils.InputUtils;

public class MatrixInputter {
    public MatrixInputter() {
    }

    public Matrix inputMatrix() throws Exception {
        int row = InputUtils.getInt("Enter rows: ", "Input number only", "Input must be in range of positive int!", 1, Integer.MAX_VALUE);
        int column = InputUtils.getInt("Enter columns: ", "Input number only", "Input must be in range of positive int!", 1, Integer.MAX_VALUE);
        int[][] matrixValue = InputUtils.input2DArray(row, column);
        return new Matrix(row, column, matrixValue);
    }
}
