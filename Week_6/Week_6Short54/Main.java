package Week_6Short54;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner (System.in);
     
        ContactManagement mana = new ContactManagement();
        while (true) {             
              System.out.println("========= Contact program =========");
        System.out.println("1. Add a Contact");
        System.out.println("2. Display all Contact");
        System.out.println("3. Delete a Contact");
        System.out.println("4. Exit");
        System.out.print("You choose: ");
        int choice = scanner.nextInt();
        
        switch(choice){
                case 1: mana.addContact(); break;
                case 2: mana.printAllContact(); break;
                case 3: mana.deleteContact(); break;
                case 4: return;
                
            }
}
    }
    
}

