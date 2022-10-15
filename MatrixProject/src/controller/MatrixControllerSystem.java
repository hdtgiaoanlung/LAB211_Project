package controller;

import bo.MatrixCalculator;
import bo.MatrixInputter;
import model.Matrix;

public class MatrixControllerSystem {
    MatrixCalculator matrixCalculator;
    MatrixInputter matrixInputter;


    private Matrix matrix1;
    private Matrix matrix2;
    public MatrixControllerSystem() {
        matrixInputter = new MatrixInputter();
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

    public void displayResult() {

    }
}
