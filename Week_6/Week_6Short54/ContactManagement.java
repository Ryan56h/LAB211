package Week_6Short54;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ContactManagement {
    Scanner scanner = new Scanner (System.in);
    ArrayList<Contact> c = new ArrayList<>();
    public String checkInputString() {
        String result;
        do {
            result = scanner.nextLine().trim();
            if (result.isEmpty()) {
                System.err.println("Not empty");
                System.out.print("Enter again: ");
            }
        } while (result.isEmpty());
        return result;
    }


    public int checkInputInteger() {
        while (true) {
            try {
                int result = Integer.parseInt(checkInputString());
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
    
    public String checkInputPhone() {
        while (true) {
            System.out.print("Enter phone: ");
            String result = checkInputString();
            if (result.matches("^(\\d{10}|\\d{3}[-. ]\\d{3}[-. ]\\d{4}"
                    + "|\\d{3}-\\d{3}-\\d{4} (x|ext)\\d+)$")) {
                return result;
            }
            System.err.println("Please input Phone flow\n"
                    + "• 1234567890\n"
                    + "• 123-456-7890\n"
                    + "• 123-456-7890 x1234\n"
                    + "• 123-456-7890 ext1234\n"
                    + "• 123.456.7890\n"
                    + "• 123 456 7890");

        }
    }
    public  boolean checkIdExist(List<? extends Contact> c, int id) {
        for (Contact contact : c) {
            if (contact.getId() == id) {
                return true;
            }
        }
        return false;
    }
    public void addContact(){
        System.out.println("-------- Add a Contact --------");
        System.out.print("Enter id contact: ");
        int id = checkInputInteger();
        if (checkIdExist(c, id)){
            System.out.println("ID already exist!");
            return;
        }
        System.out.print("Enter First Name: ");
        String firstName = checkInputString();
        System.out.print("Enter Last Name: ");
        String lastName = checkInputString();
        System.out.print("Enter Group: ");
        String group = checkInputString();
        System.out.print("Enter Address: ");
        String address = checkInputString();
        String phone = checkInputPhone();
        c.add(new Contact(id, firstName + " " + lastName, group, address, phone, lastName, firstName ));

        System.out.println("Added successful!");
    }
    public void printAllContact(){
        for (Contact contact : c) {
            System.out.println(contact.toString());
        }
    }
    public void deleteContact(){
        System.out.print("Enter id to delete:");
        int delete = checkInputInteger();
        Contact contact = checkContact(delete);
        if(contact == null){
            System.out.println("Not found!");
        }else{
            c.remove(contact);
            System.out.println("Delete successfull!");
        }
        
    }
    private Contact checkContact(int delete){
       for (Contact contact : c){
           if( contact.getId() == delete ){
               return contact;
           }
       }
       return null;
   }
    
}
