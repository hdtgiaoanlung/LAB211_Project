package ui;

import controller.MatrixControllerSystem;
import model.Matrix;
import utils.InputUtils;

public class Main {
    public static void main(String[] args) {
        MatrixControllerSystem matrixControllerSystem = new MatrixControllerSystem();
        String menu = "=========Calculator program==========\n"
                + "1. Addition Matrix\n"
                + "2. Subtraction Matrix\n"
                + "3. Multiplication Matrix\n"
                + "4. Quit\n";
        do {
            try {
                System.out.println(menu);
                int choice = InputUtils.getInt("Enter your choice: ", "Input number only!", "Input must be in range of [1, 4]", 1, 4);
                switch (choice) {
                    case 1:
                        Matrix res = matrixControllerSystem.addition();
                        System.out.println(res.displayMatrix());
                        break;
                    case 2:
                        res = matrixControllerSystem.subtraction();
                        System.out.println(res.displayMatrix());
                        break;
                    case 3:
                        res = matrixControllerSystem.multiplication();
                        System.out.println(res.displayMatrix());
                        break;
                    case 4:
                        return;
                    default:
                        throw new AssertionError();
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        } while(InputUtils.pressYNToContinue());
    }
}
