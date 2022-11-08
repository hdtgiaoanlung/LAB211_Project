package model;

import utils.InputUtils;

public class Matrix {
    private int rows;
    private int column;
    private int[][] matrix;

    public Matrix() {

    }

    public Matrix(int rows, int column, int[][] matrix) {
        this.rows = rows;
        this.column = column;
        this.matrix = matrix;
    }

    public int getRows() {
        return rows;
    }

    public int getColumn() {
        return column;
    }

    public int[][] getMatrix() {
        return matrix;
    }

    public void setRows(int rows) {
        this.rows = rows;
    }

    public void setColumn(int column) {
        this.column = column;
    }

    public void setMatrix(int[][] matrix) {
        this.matrix = matrix;
    }

    private boolean checkAddSubtract(Matrix matrix1) {
        return matrix1.getRows() == this.rows && matrix1.getColumn() == this.column;
    }

    private boolean checkMultiply(Matrix matrix1) {
        return this.column == matrix1.getRows();
    }

    private Matrix addAndSubtract(Matrix matrix, boolean isAdding) throws Exception {
        if (!checkAddSubtract(matrix)) {
            throw new Exception("Cannot add 2 different size matrix!");
        }
        int rows = this.getRows();
        int columns = this.getColumn();
        Matrix ret = new Matrix(rows, columns, new int[rows][columns]);
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                ret.getMatrix()[i][j] = isAdding ? this.getMatrix()[i][j]
                        + matrix.getMatrix()[i][j] : this.getMatrix()[i][j] - matrix.getMatrix()[i][j];
            }
        }
        return ret;
    }

    public Matrix add(Matrix m) throws Exception {
        return addAndSubtract(m, true);
    }

    public Matrix subtract(Matrix m) throws Exception {
        return addAndSubtract(m, false);
    }

    public Matrix multiply(Matrix m) throws Exception {
        if (!checkMultiply(m)) {
            throw new Exception("Unable to multiply!");
        }
        int rowM1 = this.getRows();
        int rowM2 = m.getRows();
        int colM2 = m.getColumn();
        Matrix ret = new Matrix(rowM1, colM2, new int[rowM1][colM2]);
        for (int i = 0; i < rowM1; i++) {
            for (int j = 0; j < colM2; j++) {
                for (int k = 0; k < rowM2; k++) {
                    ret.getMatrix()[i][j] += this.getMatrix()[i][k] * m.getMatrix()[k][j];
                }
            }

        }
        return ret;
    }

    public static Matrix inputMatrix(int order) throws Exception {
        System.out.println("========== INPUT MATRIX " + order + " ==========");
        int row = InputUtils.getInt("Enter number of rows: ", "Input number only!", "Input must be positive!", 1, Integer.MAX_VALUE);
        int column = InputUtils.getInt("Enter number of columns: ", "Input number only!", "Input must be positive!", 1, Integer.MAX_VALUE);
        int[][] matrix = InputUtils.input2DArray(row, column);
        return new Matrix(row, column, matrix);
    }
}
