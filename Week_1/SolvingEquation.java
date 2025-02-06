package Week_1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SolvingEquation {

    private List<Float> solutions = new ArrayList<>();
    Scanner scanner = new Scanner(System.in);

    public List<Float> calculateSuperlativeEquation(float a, float b) {
        solutions.clear();
        if (a == 0) {
            if (b == 0) {
                System.out.println("The equation has infinitely many solutions.");
            } else {
                System.out.println("The equation has no solution");
            }

        } else {
            float x = -b / a;
            System.out.println("The equation is linear with the solution: x = " + x);
            solutions.add(x);
        }
        return solutions;
    }

    public List<Float> calculateQuadraticEquation(float a, float b, float c) {
        solutions.clear();
        if (a == 0) {
            return calculateSuperlativeEquation(b, c);
        } else {
            float delta = b * b - 4 * a * c;
            if (delta < 0) {
                System.out.println("The equation has no solution");
            } else if (delta == 0) {
                float x = -b / (2 * a);
                solutions.add(x);
                System.out.println("The equation has one real solution: x = " + x);
            } else {
                float x1 = (-b + (float) Math.sqrt(delta)) / (2 * a);
                solutions.add(x1);
                float x2 = (-b - (float) Math.sqrt(delta)) / (2 * a);
                solutions.add(x2);
                System.out.println("The equation has two real solutions: x1 = " + x1 + ", x2 = " + x2);
            }

        }
        return solutions;
    }
public int checkInputInteger(int min, int max) {
    while (true) { 
        try {
            int result = Integer.parseInt(scanner.nextLine().trim());
            if (result < min || result > max){
                throw new NumberFormatException();
            }
            return result;
        } catch (NumberFormatException e) {
            System.err.println("Invalid input. Please enter an integer between " + min + " and " + max + ": ");
            System.out.println("Enter again: ");
        }
    }
}
public float checkFloat(){
    while (true) { 
        try {
            float result = Float.parseFloat(scanner.nextLine().trim());
            return result;
        } catch (NumberFormatException e) {
            System.err.println("Invalid input. Please enter a float number! ");
            System.out.println("Enter again: ");
        }
    }
}
public float checkNumber(float number) {
    if (number % 2 == 0) {
        System.out.println("Number is Even: " + number);
    } else {
        System.out.println("Number is Odd: " + number);

    }
    if (isPerfectSquare(number)) {
        System.out.println("Number is perfect square: " + number);
    }

    return number;
}

    private boolean isPerfectSquare(float number) {
        if (number < 0) {
            return false;
        }
        int sqrt = (int) Math.sqrt(number);
        return sqrt * sqrt == number;
    }
}
