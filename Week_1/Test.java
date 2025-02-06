package Week_1;

import java.util.Scanner;

public class Test {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
// Linear Search:
        //     System.out.println("Enter size of the array:");
        //     int size = scanner.nextInt();

        //     LinearSearch demo = new LinearSearch(size);
        //     demo.generateRandom();
        //     System.out.print("Generated array: ");
        //     demo.displayArray();
        //     System.out.println("\nEnter value to search:");
        //     int searchValue = scanner.nextInt();
        //     int result = demo.linearSearch(searchValue);
        //     if (result != -1) {
        //         System.out.println("Value " + searchValue + " found at index " + result);
        //     } else {
        //         System.out.println("Value " + searchValue + " not found in the array.");
        //     }
// Count word, char
        //     CountWC counter = new CountWC();
        //     System.out.println("Enter content: ");
        //     String content = scanner.nextLine();
        //     counter.analyze(content);
        //     counter.display();
// Change base number system (16, 10, 2) program
//        while (true) {
//         System.out.println("1. Binary to Decimal ");
//            System.out.println("2. Binary to Hexadecimal");
//            System.out.println("3. Decimal to Binary");
//            System.out.println("4. Decimal to Hexadecimal");
//            System.out.println("5. Hexadecimal to Binary ");
//            System.out.println("6. Hexadecimal to Decimal ");
//            System.out.println("Choose a conversion type:");
//            int choice = scanner.nextInt();
//            scanner.nextLine();
//            if (choice > 6) {
//                System.out.println("Exiting...");
//                return;
//            }
//            System.out.println("Enter the value: ");
//             String input = scanner.nextLine();
//            ChangeBaseNumber convert = new ChangeBaseNumber(input);
//            switch (choice) {
//                case 1:
//                    convert.binaryToDec();
//                    break;
//                case 2:
//                    convert.binaryToHex();
//                    break;
//                case 3:
//                    convert.decimalToBinary();
//                    break;
//                case 4:
//                    convert.decimalToHex();
//                    break;
//                case 5:
//                    convert.hexToBinary();
//                    break;
//                case 6:
//                    convert.hexToDec();
//                    break;
//                default:
//                    System.out.println("Invalid option!");
//                    break;
//            }
//            convert.display();
//        }
// Solving the equation
        SolvingEquation equation = new SolvingEquation();

        while (true) {
            System.out.println("======= Equation Program ========");
            System.out.println("1. Calculate Superlative Equation");
            System.out.println("2. Calculate Quadratic Equation");
            System.out.println("3. Exit");
            System.out.println("Enter your choice: ");
            int choice = equation.checkInputInteger(1, 3);
            
            if (choice == 3) {
                System.out.println("Exiting...");
                break;
            }
            System.out.println("Enter the coefficient a: ");
            float a = equation.checkFloat();
            

            System.out.println("Enter the coefficient b: ");
            float b = equation.checkFloat();

            if (choice == 1) {
                equation.calculateSuperlativeEquation(a, b);
                equation.checkNumber(a);
                equation.checkNumber(b);
            } else if (choice == 2) {
                System.out.println("Enter coefficient c: ");
                float c = scanner.nextFloat();
                equation.calculateQuadraticEquation(a, b, c);
                equation.checkNumber(a);
                equation.checkNumber(b);
                equation.checkNumber(c);
            }

        }
        scanner.close();
    }
}
