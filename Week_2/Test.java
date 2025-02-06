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
public class Test {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // Develop program
//        DevelopTheProgram program = new DevelopTheProgram();
//        while (true) {
//            System.out.println("======== Calculator Program ======");
//            System.out.println("1. Normal Calculator");
//            System.out.println("2. BMI Calculator");
//            System.out.println("3. Exit");
//            System.out.println("Please choice one option: ");
//            int choice = program.checkInputInteger(1, 3);
//
//            if (choice == 3) {
//                System.out.println("Exiting...");
//                break;
//            }
//            switch (choice) {
//                case 1:
//                    System.out.println("====== Normal Calculator ====== ");
//                    program.calculateNumber();
//                    break;
//                case 2:
//                    System.out.println("====== BMI Calculator ======");
//                    program.BMICalculator();
//             
//                    break;
//                case 3:
//                    return;
//                default:
//                    System.out.println("Invalid option!");
//                    break;
//            }
//
//        }
        // Calculate perimeter and area 
        //   Test test = new Test();
        //   Rectangle rectangle = test.inputRectangle();
        //   Circle circle = test.inputCircle();
        //   Triangle triangle = test.inputTriangle();

        //   rectangle.printResult();
        //   circle.printResult();
        //   triangle.printResult();
        // }
        // public double checkInputDouble() {
        //     while (true) {
        //         try {
        //             double result = Double.parseDouble(scanner.nextLine().trim());
        //             return result;
        //         } catch (NumberFormatException e) {
        //             System.err.println("Invalid input. Please enter a double number! ");
        //             System.out.println("Enter again: ");
        //         }
        //     }
        // }
        //  public Rectangle inputRectangle(){
        //     while (true) { 
        //         System.out.println("Please input side width of Rectangle:");
        //         double width = checkInputDouble();
        //         System.out.println("Please input side length of Rectangle:");
        //         double length = checkInputDouble();
        //         if(width <= 0 || length <= 0){
        //             System.err.println("Side length and width must be greater than 0!");
        //         }else{
        //             return  new Rectangle(width, length);
        //         }
        //     }
        // }
        //     public Triangle inputTriangle(){
        //         while (true) {
        //             System.out.println("Please input side a of Triangle:");
        //             double sideA = checkInputDouble();
        //             System.out.println("Please input side b of Triangle:");
        //             double sideB = checkInputDouble();
        //             System.out.println("Please input side c of Triangle:");
        //             double sideC = checkInputDouble();
        //             if(sideA <= 0 || sideB <= 0 || sideC <= 0 || (sideA + sideB <= sideC) || (sideA + sideC <= sideB) || (sideB + sideC <= sideA)){
        //                 System.err.println("Side length must be greater than 0 and satisfy triangle inequality!");
        //             }else{
        //                 return new Triangle(sideA, sideB, sideC);
        //             }
        //         }
        // }
        // public Circle inputCircle(){
        //     while (true) {
        //         System.out.println("Please input radius of Circle:");
        //         double radius = checkInputDouble();
        //         if(radius <= 0){
        //             System.err.println("Radius must be greater than 0!");
        //         }else{
        //             return new Circle(radius);
        //         }
        //     }
        // Matrix calculator program
            Matrix matrix = new Matrix(0, 0);
            while (true) {
                System.out.println("======== Matrix Calculator ======");
                System.out.println("1. Add two matrices");
                System.out.println("2. Subtract two matrices");
                System.out.println("3. Multiply two matrices");
                System.out.println("4. Exit");
                System.out.println("Please choose one option: ");

                int choice = matrix.checkInputInteger(1, 4);

                switch (choice) {
                    case 1 -> {
                       matrix.Addition(scanner);
                }
                    case 2 -> {
                        matrix.Subtraction(scanner);
                    }
                    case 3 -> {
                        matrix.Multiplication(scanner);
                    }
                    case 4 -> {
                        System.out.println("Exiting the program...");
                        scanner.close();
                        return;
                }
                    default -> System.out.println("Invalid choice. Please try again.");
                }
            }
        }

}
