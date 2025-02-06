/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Week_2;

import java.util.Scanner;

/**
 *
 * @author Admin
 */
public class Matrix {

    private int[][] matrix;
    private int rows;
    private int cols;

    public Matrix(int rows, int cols) {
        this.rows = rows;
        this.cols = cols;
        this.matrix = new int[rows][cols];
    }

    public int[][] getMatrix() {
        return matrix;
    }

    public void setMatrix(int[][] matrix) {
        this.matrix = matrix;
    }

    public int getRows() {
        return rows;
    }

    public void setRows(int rows) {
        this.rows = rows;
    }

    public int getCols() {
        return cols;
    }

    public void setCols(int cols) {
        this.cols = cols;
    }

    public Scanner getScanner() {
        return scanner;
    }

    public void setScanner(Scanner scanner) {
        this.scanner = scanner;
    }
    

    Scanner scanner = new Scanner(System.in);

    public int checkInputInteger(int min, int max) {
        while (true) {
            try {
                int result = Integer.parseInt(scanner.nextLine().trim());
                if (result < min || result > max) {
                    throw new NumberFormatException();
                }
                return result;
            } catch (NumberFormatException e) {
                System.err.println("Invalid input. Please enter an integer between " + min + " and " + max + ": ");
                System.out.println("Enter again: ");
            }
        }
    }

    public boolean checkMatrix(Matrix Matrix2) {
        if (this.rows != Matrix2.rows || this.cols != Matrix2.cols) {
            System.err.println("Matrices must have the same dimensions to be multiplied.");
            return false;
        }
        return true;

    }
    public   Matrix[] inputTwoMatrices(Scanner scanner1) {
            System.out.print("Enter number of rows for Matrix 1: ");
            int rowsA = scanner.nextInt();
            System.out.print("Enter number of columns for Matrix 1: ");
            int colsA = scanner.nextInt();
            Matrix A = new Matrix(rowsA, colsA);
            A.inputMatrix();
        
            System.out.print("Enter number of rows for Matrix 2: ");
            int rowsB = scanner.nextInt();
            System.out.print("Enter number of columns for Matrix 2: ");
            int colsB = scanner.nextInt();
            Matrix B = new Matrix(rowsB, colsB);
            B.inputMatrix();
        
            return new Matrix[]{A, B};
        }
        public void inputMatrix() {
          
            System.out.println("Enter matrix elements:");
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    System.out.print("Enter element at [" + (i + 1) + "][" + (j + 1) + "]: ");
                    matrix[i][j] = checkInputInteger(Integer.MIN_VALUE, Integer.MAX_VALUE);
                }
            }
        }
    
        public Matrix additionMatrix(Matrix matrix2) {
            if (!checkMatrix(matrix2)) {
                return null;
            }
            Matrix result = new Matrix(rows, cols);
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    result.matrix[i][j] = matrix[i][j] + matrix2.matrix[i][j];
                }
            }
            return result;
        }
    
        public Matrix subtractionMatrix(Matrix matrix2) {
            if (!checkMatrix(matrix2)) {
                return null;
            }
            Matrix result = new Matrix(rows, cols);
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    result.matrix[i][j] = matrix[i][j] - matrix2.matrix[i][j];
                }
            }
            return result;
        }
    
        public Matrix multiplicationMatrix(Matrix matrix2) {
            if (!checkMatrix(matrix2)) {
                return null;
            }
            Matrix result = new Matrix(rows, matrix2.cols);
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < matrix2.cols; j++) {
                    for (int k = 0; k < cols; k++) {
                        result.matrix[i][j] += matrix[i][k] * matrix2.matrix[k][j];
                    }
                }
            }
            return result;
    
        }
    
        public void printMatrix() {
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    System.out.print(matrix[i][j] + " ");
                }
                System.out.println();
            }
        }
        public void Addition(Scanner scanner) {
            System.out.println("================= Addition ===================");
            Matrix[] matrices = inputTwoMatrices(scanner);
        Matrix A = matrices[0];
        Matrix B = matrices[1];

        Matrix result = A.additionMatrix(B);
        if (result != null) {
            System.out.println("=========Result=========");
            result.printMatrix();
        } else {
            System.out.println("Matrices must have the same dimensions for addition.");
        }
    }

    public  void Subtraction(Scanner scanner) {
        System.out.println("================= Subtraction ===================");
        Matrix[] matrices = inputTwoMatrices(scanner);
        Matrix A = matrices[0];
        Matrix B = matrices[1];

        Matrix result = A.subtractionMatrix(B);
        if (result != null) {
            System.out.println("=========Result=========");
            result.printMatrix();
        } else {
            System.out.println("Matrices must have the same dimensions for subtraction.");
        }
    }

    public void Multiplication(Scanner scanner) {
        System.out.println("================= Multiplication ===================");
        Matrix[] matrices = inputTwoMatrices(scanner);
        Matrix A = matrices[0];
        Matrix B = matrices[1];

        Matrix result = A.multiplicationMatrix(B);
        if (result != null) {
            System.out.println("=========Result=========");
            result.printMatrix();
        } else {
            System.out.println("Number of columns in Matrix 1 must be equal to number of rows in Matrix 2 for multiplication.");
        }
    }

}
