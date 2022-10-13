package model;

public class Matrix {
    private int rows;
    private int columns;
    private int[][] matrixValue;

    public Matrix() {

    }

    public Matrix(int rows, int columns) {
        matrixValue = new int[rows][columns];
    }

    public int getRows() {
        return rows;
    }

    public int getColumns() {
        return columns;
    }

    public int[][] getMatrix() {
        return matrixValue;
    }

    public void setRows(int rows) {
        this.rows = rows;
    }

    public void setColumns(int columns) {
        this.columns = columns;
    }

    public void setMatrix(int[][] matrix) {
        this.matrixValue = matrix;
    }


}
