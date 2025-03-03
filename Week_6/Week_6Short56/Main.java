/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Week_6Short56;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Admin
 */
public class Main {
     public static void main(String[] args) {
        ArrayList<Worker> worker = new ArrayList<>();
        ArrayList<SalaryHistory> salary = new ArrayList<>();
        WorkerManagement mana = new WorkerManagement();
        Scanner scanner = new Scanner(System.in);
         while (true) {             
              System.out.println("======== Worker Management =========");
        System.out.println("1. Add Worker");
        System.out.println("2. Up salary");
        System.out.println("3. Down salary");
        System.out.println("4. Display Information salary");
        System.out.println("5. Exit");
        System.out.println("You choose");
        int choice = scanner.nextInt();
        
        switch(choice){
                case 1: mana.createWorker(worker); break;
                case 2: mana.increaseSalary(worker, salary); break;
                case 3: mana.decreaseSalary(worker, salary); break;
                case 4: mana.displaySalaryHistory(salary); break;
                case 5: return;
                
            }
         }
        
    }
            
}
