package model;

public class Matrix {
    private int rows;
    private int columns;
    private int[][] matrixValue;

    public Matrix() {

    }

    public Matrix(int rows, int columns) {
        this.rows = rows;
        this.columns = columns;
        this.matrixValue = new int[rows][columns];
        for (int i = 0; i < rows; i++) {
            for(int j = 0; j < columns; j++) {
                this.matrixValue[i][j] = 0;
            }
        }
    }

    public Matrix(int rows, int columns, int[][] matrixValue) {
        this.rows = rows;
        this.columns = columns;
        this.matrixValue = matrixValue;
    }

    public int getRows() {
        return rows;
    }

    public int getColumns() {
        return columns;
    }

    public int[][] getMatrixValue() {
        return matrixValue;
    }

    public void setMatrixValue(int[][] arr){
        this.matrixValue = arr;
    }

    public void setRows(int rows) {
        this.rows = rows;
    }

    public void setColumns(int columns) {
        this.columns = columns;
    }

}
