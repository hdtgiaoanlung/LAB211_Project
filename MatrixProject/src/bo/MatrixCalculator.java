package bo;

import model.Matrix;
import utils.InputUtils;

public class MatrixCalculator {

    public MatrixCalculator() {
    }

    private int[][] addOrSubtract(int[][] arr1, int[][] arr2, boolean isAdding){
        int[][] array = arr1;
        for(int i = 0; i < arr1.length; i++) {
            for(int j = 0; j < arr1[i].length; j++){
                array[i][j] = isAdding ? (arr1[i][j] + arr2[i][j]) : (arr1[i][j] - arr2[i][j]);
            }
        }
        return array;
    }

    private int[][] multiply(int[][] arr1, int[][] arr2) {
        int[][] array = arr1;
        for (int i = 0; i < arr1.length; i++) {
            for (int j = 0; j < arr2[0].length; j++) {
                for (int k = 0; k < arr2.length; k++) {
                    array[i][j] += arr1[i][k] * arr2[k][j];
                }
            }
        }
        return array;
    }

    public Matrix addTwoMatrix(Matrix m1, Matrix m2) throws Exception {
        if (m1 == null || m2 == null) {
            throw new Exception("Cannot calculate with null matrix!");
        }
        if (m1.getColumns() == m2.getColumns() && m1.getRows() == m2.getRows()) {
            Matrix ret = new Matrix(m1.getRows(), m1.getColumns());
            ret.setMatrixValue(addOrSubtract(m1.getMatrixValue(), m2.getMatrixValue(), true));
            return ret;
        }
        throw new Exception("Cannot add two matrix with two different size!");
    }

    public Matrix subtractTwoMatrix(Matrix m1, Matrix m2) throws Exception {
        if (m1 == null || m2 == null) {
            throw new Exception("Cannot calculate with null matrix!");
        }
        if (m1.getColumns() == m2.getColumns() && m1.getRows() == m2.getRows()) {
            Matrix ret = new Matrix(m1.getRows(), m1.getRows());
            ret.setMatrixValue(addOrSubtract(m1.getMatrixValue(), m2.getMatrixValue(), false));
            return ret;
        }
        throw new Exception("Cannot subtract two matrix with two different size!");
    }

    public Matrix multiplyTwoMatrix(Matrix m1, Matrix m2) throws Exception {
        if (m1 == null || m2 == null) {
            throw new Exception("Cannot calculate with null matrix!");
        }
        if (m1.getColumns() == m2.getRows()) {
            Matrix ret = new Matrix(m1.getRows(), m2.getColumns());
            ret.setMatrixValue(multiply(m1.getMatrixValue(), m2.getMatrixValue()));
            return ret;
        }
        throw new Exception("Cannot multiply these two matrices!");
    }

}
