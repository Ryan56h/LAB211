
package Week_4.Short105.main;

import java.util.Scanner;


public class Validation {
    private Scanner input = new Scanner(System.in);

  
    public String inputString() {
        while (true) {
            String result = input.nextLine().trim();
            if (!result.isEmpty()) {
                return result;
            } else {
                System.out.println("Input must not be empty. Enter again: ");
            }
        }
    }


    public int inputPositiveInteger() {
        while (true) {
            try {
                int result = Integer.parseInt(inputString());
                if (result > 0) {
                    return result;
                } else {
                    System.out.println("Input must be a positive integer. Please enter again: ");
                }
            } catch (NumberFormatException e) {
                System.out.println("Input must be an integer. Enter again: ");
            }
        }
    }

 
    public double inputPositiveDouble() {
        while (true) {
            try {
                double result = Double.parseDouble(inputString());
                if (result >= 0) {
                    return result;
                } else {
                    System.out.println("Input must be a positive number. Please enter again: ");
                }
            } catch (NumberFormatException e) {
                System.out.println("Input must be a number. Enter again: ");
            }
        }
    }

    
    public String inputPhoneNumber() {
        while (true) {
            String phone = inputString();
            if (phone.matches("\\d{12}")) {
                return phone;
            } else {
                System.out.println("Phone number must be 12 digits. Enter again: ");
            }
        }
    }

    
    public String inputID() {
        while (true) {
            String id = inputString();
            if (id.matches("\\d{6}")) {
                return id;
            } else {
                System.out.println("ID must be exactly 6 digits. Enter again: ");
            }
        }
    }

   
    public int inputValidYear(int minYear, int maxYear) {
        while (true) {
            int year = inputPositiveInteger();
            if (year >= minYear && year <= maxYear) {
                return year;
            } else {
                System.out.printf("Year must be between %d and %d. Enter again: %n", minYear, maxYear);
            }
        }
    }

    
    public String inputContractType() {
        while (true) {
            String contract = inputString();
            if (contract.equalsIgnoreCase("Long") || contract.equalsIgnoreCase("Short")) {
                return contract;
            } else {
                System.out.println("Contract type must be 'Long' or 'Short'. Enter again: ");
            }
        }
    }

    
    public int inputScore() {
        while (true) {
            int score = inputPositiveInteger();
            if (score >= 0 && score <= 100) {
                return score;
            } else {
                System.out.println("Score must be between 0 and 100. Enter again: ");
            }
        }
    }
}

