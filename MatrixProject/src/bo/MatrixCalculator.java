package bo;

import model.Matrix;
import utils.InputUtils;

public class MatrixCalculator {
    public MatrixCalculator() {

    }
    public Matrix addTwoMatrix(Matrix m1, Matrix m2) throws Exception{
        if (m1.getColumns() == m2.getColumns() && m1.getRows() == m2.getRows()) {
            Matrix ret = new Matrix(m1.getRows(), m1.getColumns());
            for (int i = 0; i < ret.getRows(); i++) {
                for (int j = 0 ; j < ret.getColumns(); j++) {
                    ret.setFactorValue(i, j, (m1.getFactorValue(i, j) + m2.getFactorValue(i, j)));
                }
            }
            return ret;
        }
        throw new Exception("Cannot add two matrix with two different size!");
    }

    public Matrix subtractTwoMatrix(Matrix m1, Matrix m2) throws Exception {
        if (m1.getColumns() == m2.getColumns() && m1.getRows() == m2.getRows()) {
            Matrix ret = new Matrix(m1.getRows(), m1.getRows());
            for (int i = 0; i < m1.getRows(); i++) {
                for (int j = 0 ; j < m1.getColumns(); j++) {
                    ret.setFactorValue(i, j, m1.getFactorValue(i, j) - m2.getFactorValue(i, j));
                }
            }
            return ret;
        }
        throw new Exception("Cannot subtract two matrix with two different size!");
    }

    public Matrix multiplyTwoMatrix(Matrix m1, Matrix m2) throws Exception {
        if (m1.getColumns() == m2.getRows()) {
            Matrix ret = new Matrix(m1.getRows(), m2.getColumns());
            for (int i = 0; i < m1.getRows(); i++) {
                for (int j = 0; j < m2.getColumns(); j++) {
                    ret.setFactorValue(i, j, 0);
                    for (int k = 0; k < m2.getRows(); k++) {
                        ret.setFactorValue(i, j, m1.getFactorValue(i, k) * m2.getFactorValue(k, j));
                    }
                }
            }
            return ret;
        }
        throw new Exception("Cannot multiply these two matrices!");
    }
}
