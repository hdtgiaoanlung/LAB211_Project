package controller;

import bo.MatrixCalculator;
import bo.MatrixInputter;
import model.Matrix;

public class MatrixControllerSystem {
    private MatrixCalculator matrixCalculator;
    private MatrixInputter matrixInputter;

    private Matrix matrix1;
    private Matrix matrix2;
    public MatrixControllerSystem() {
        matrixInputter = new MatrixInputter();
    }

    public Matrix addition() throws Exception {
        matrix1 = matrixInputter.inputMatrix(matrix1);
        matrixInputter = new MatrixInputter();
        matrix2 = matrixInputter.inputMatrix(matrix2);

        return matrixCalculator.addTwoMatrix(matrix1, matrix2);
    }

    public Matrix subtraction() throws Exception {
        matrix1 = matrixInputter.inputMatrix(matrix1);
        matrix2 = matrixInputter.inputMatrix(matrix2);

        return matrixCalculator.subtractTwoMatrix(matrix1, matrix2);
    }

    public Matrix multiplication() throws Exception {
        matrix1 = matrixInputter.inputMatrix(matrix1);
        matrix2 = matrixInputter.inputMatrix(matrix2);

        return matrixCalculator.multiplyTwoMatrix(matrix1, matrix2);
    }

}