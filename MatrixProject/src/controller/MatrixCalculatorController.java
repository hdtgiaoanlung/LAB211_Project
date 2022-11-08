package controller;

import model.Matrix;

public class MatrixCalculatorController {
    private Matrix matrix1;
    private Matrix matrix2;

    public MatrixCalculatorController() {
        matrix1 = new Matrix();
        matrix2 = new Matrix();
    }

    private Matrix addOrSubtractMatrix(boolean isAdd) throws Exception {
        matrix1 = Matrix.inputMatrix(1);
        matrix2 = Matrix.inputMatrix(2);
        return isAdd ? matrix1.add(matrix2) : matrix1.subtract(matrix2);
    }

    public Matrix addMatrix() throws Exception {
        return addOrSubtractMatrix(true);
    }

    public Matrix subtractMatrix() throws Exception {
        return addOrSubtractMatrix(false);
    }

    public Matrix multiplyMatrix() throws Exception {
        matrix1 = Matrix.inputMatrix(1);
        matrix2 = Matrix.inputMatrix(2);
        return matrix1.multiply(matrix2);
    }

    public Matrix getMatrix1() {
        return matrix1;
    }

    public Matrix getMatrix2() {
        return matrix2;
    }
}
