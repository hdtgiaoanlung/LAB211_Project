package bo;

import model.Matrix;
import utils.InputUtils;

public class MatrixInputter {
    public MatrixInputter() {
    }

    public Matrix inputMatrix() throws Exception {
        int row = InputUtils.getInt("Enter rows: ", "Input number only", "Input must be in range of positive int!", 1, Integer.MAX_VALUE);
        int column = InputUtils.getInt("Enter rows: ", "Input number only", "Input must be in range of positive int!", 1, Integer.MAX_VALUE);
        Matrix matrix = new Matrix(row, column);
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                matrix.setFactorValue(i, j, InputUtils.getFactorValue(i, j));
            }
        }
        return matrix;
    }

    public static void main(String[] args) throws Exception {
        MatrixInputter matrixInputter = new MatrixInputter();
        Matrix matrix = matrixInputter.inputMatrix();
        System.out.println(matrix.displayMatrix());
    }
}
