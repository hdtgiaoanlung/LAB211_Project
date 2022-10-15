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

    public void setFactorValue(int rows, int columns, int value) {
        matrixValue[rows][columns] = value;
    }

    public int getFactorValue(int rows, int columns) {
        return matrixValue[rows][columns];
    }


    public String displayMatrix() {
        String ret = "";
        for (int i = 0; i < rows; i++) {
            for (int j = 0 ; j < columns; j++) {
                ret += "[" + getFactorValue(i, j) + "]";
            }
            System.out.println();
        }
        return ret;
    }
}
