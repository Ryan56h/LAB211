package view;

import java.util.Scanner;

public class Validation {
    public static String inputString(){
        Scanner input = new Scanner(System.in);
        while(true){
            String result = input.nextLine();
            if (!result.isEmpty()){
                return result;
            }else{
                System.out.println("Input must not be empty");
                System.out.println("Enter agian: ");
            }
        }
    }
    public static int inputPositiveInteger(){
        while(true){
            try {
                int result = Integer.parseInt(inputString());
                if (result > 0){
                    return  result;
                }else {
                    System.out.println("Input must be a positive integer");
                    System.out.println("Please input agian: ");
                }
            } catch (NumberFormatException e) {
                System.out.println("Input must be a integer");
                System.out.println("Enter agian: ");
            }
        }
    }
}
