package ui;

import controller.MatrixCalculatorController;
import model.Matrix;
import utils.ArrayUtils;
import utils.InputUtils;

public class Main {
    public static String ADDITION_BANNER = "==============Addition==============";
    public static String SUBTRACTION_BANNER = "==============Subtraction==============";
    public static String MULTIPLY_BANNER = "==============Multiplication==============";

    public static void displayResult(int choice, Matrix result, Matrix matrix1, Matrix matrix2) {
        System.out.println("==============Result==============");
        ArrayUtils.display2DArray(matrix1.getMatrix());
        switch (choice) {
            case 1 -> System.out.println("+");
            case 2 -> System.out.println("-");
            case 3 -> System.out.println("x");
        }
        ArrayUtils.display2DArray(matrix2.getMatrix());
        System.out.println("=");
        ArrayUtils.display2DArray(result.getMatrix());
    }

    public static void main(String[] args) {

        System.out.println("Welcome to my Calculator Project!");
        String menu = """
                1.Addition Matrix
                2.Subtraction Matrix
                3.Multiplication Matrix
                """;

        MatrixCalculatorController matrixCalculatorController = new MatrixCalculatorController();
        do {
            System.out.println(menu);
            int choice = InputUtils.getInt("Enter your choice: ", "Input number only!", "Input must be in range [1, 3]", 1, 3);
            try {
                switch (choice) {
                    case 1:
                        System.out.println(ADDITION_BANNER);
                        Matrix result = matrixCalculatorController.addMatrix();
                        displayResult(choice, result, matrixCalculatorController.getMatrix1(), matrixCalculatorController.getMatrix2());
                        break;
                    case 2:
                        System.out.println(SUBTRACTION_BANNER);
                        result = matrixCalculatorController.subtractMatrix();
                        displayResult(choice, result, matrixCalculatorController.getMatrix1(), matrixCalculatorController.getMatrix2());
                        break;
                    case 3:
                        System.out.println(MULTIPLY_BANNER);
                        result = matrixCalculatorController.multiplyMatrix();
                        displayResult(choice, result, matrixCalculatorController.getMatrix1(), matrixCalculatorController.getMatrix2());
                        break;
                }
            } catch (Exception e) {
                System.err.println(e.getMessage());
            }

        } while (InputUtils.pressYNToContinue());
    }


}
