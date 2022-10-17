package bo;

import model.Matrix;
import utils.InputUtils;

public class MatrixInputter {
    public MatrixInputter() {
    }

    public Matrix inputMatrix() {
        Matrix matrix1 = new Matrix();
        int rows = InputUtils.getInt("Enter number of rows: ", "Input number only!", "Input must be in range from 1", 1, Integer.MAX_VALUE);
        int columns = InputUtils.getInt("Enter number of columns: ", "Input number only!", "Input must be in range from 1", 1, Integer.MAX_VALUE);
        matrix1.setRows(rows);
        matrix1.setColumns(columns);
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                matrix1.setFactorValue(i, j, InputUtils.getFactorValue(i, j));
            }
        }
        return matrix1;
    }

}
