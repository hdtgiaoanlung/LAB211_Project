package bo;

import model.Matrix;
import utils.InputUtils;

public class MatrixInputter {
    private Matrix matrix;
    public MatrixInputter() {
        matrix = new Matrix();
    }

    public Matrix inputMatrix() {
        int rows = InputUtils.getInt("Enter number of rows: ", "Input number only!", "Input must be in range from 1", 1, Integer.MAX_VALUE);
        int columns = InputUtils.getInt("Enter number of columns: ", "Input number only!", "Input must be in range from 1", 1, Integer.MAX_VALUE);
        matrix = new Matrix(rows, columns);

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                matrix.setFactorValue(i, j, InputUtils.getFactorValue(i, j));
            }
        }
        return matrix;
    }

}
