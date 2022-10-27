package controller;

import bo.MatrixCalculator;
import bo.MatrixInputter;
import model.Matrix;
import utils.InputUtils;

public class MatrixControllerSystem {
    private MatrixCalculator matrixCalculator;
    private MatrixInputter matrixInputter;
    private Matrix matrix1;
    private Matrix matrix2;
    public MatrixControllerSystem() {
        matrixCalculator = new MatrixCalculator();
        matrixInputter = new MatrixInputter();
        matrix1 = new Matrix();
        matrix2 = new Matrix();
    }

    public Matrix addition() throws Exception {
        matrix1 = matrixInputter.inputMatrix();
        matrix2 = matrixInputter.inputMatrix();

        return matrixCalculator.addTwoMatrix(matrix1, matrix2);
    }

    public Matrix subtraction() throws Exception {
        matrix1 = matrixInputter.inputMatrix();
        matrix2 = matrixInputter.inputMatrix();
        return matrixCalculator.subtractTwoMatrix(matrix1, matrix2);
    }

    public Matrix multiplication() throws Exception {
        matrix1 = matrixInputter.inputMatrix();
        matrix2 = matrixInputter.inputMatrix();

        return matrixCalculator.multiplyTwoMatrix(matrix1, matrix2);
    }

}
