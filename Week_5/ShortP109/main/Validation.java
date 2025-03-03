package ShortP109.main;

import ShortP109.model.Course;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Validation {

    private Scanner scanner = new Scanner(System.in);

    public String inputString() {
        String input;
        do {
            input = scanner.nextLine().trim();
            
        } while (input.isEmpty());
        return input;
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

    public int inputCredits() {
        while (true) {

            int credits = scanner.nextInt();
            if (credits > 0) {
                return credits;
            } else {
                System.out.println("Credits must be greater than 0");
                System.out.println("Credits: ");
            }

        }

    }

        public  boolean checkIdExist(List<? extends Course> courses, String id) {
        for (Course course : courses) {
            if (id.equalsIgnoreCase(course.getId())) {
                return true;
            }
        }
        return false;
    }


    
    public Date dateValidation() {
    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    sdf.setLenient(false); 
    
    while (true) {                
        String in = inputString().trim();
        
        if (in.isEmpty()) { 
            System.out.println("Input must not be empty. Enter again:");
            continue;
        }  

        try {
            return sdf.parse(in); 
        } catch (ParseException e) {
            System.out.println("Invalid date! Enter again (dd/MM/yyyy): ");
        }
    }
}

}
