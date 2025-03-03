package Week_6Short56;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Scanner;

/**
 *
 * @author Admin
 */
public class WorkerManagement {
    Scanner scanner = new Scanner (System.in);
    public  String checkInputString() {
        while (true) {
            String result = scanner.nextLine().trim();
            if (result.isEmpty()) {
                System.err.println("Not empty");
                System.out.print("Enter again: ");
            } else {
                return result;
            }
        }
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
   public void createWorker(ArrayList<Worker> w){
       System.out.println("Enter id: ");
       int id = checkInputInteger();
       System.out.println("Enter name: ");
       String name = checkInputString();
       System.out.println("Enter age: ");
       int age = checkInputInteger();
       System.out.println("Enter salary: ");
       int salary = checkInputInteger();
       System.out.println("Enter work location: ");
       String workLocation = checkInputString();
       w.add(new Worker(id, name, age, salary, workLocation));
       System.out.print("Added successful");
               
        
   }
   
   public void increaseSalary(ArrayList<Worker> w, ArrayList<SalaryHistory> s){
       System.out.println("Enter code(ID): ");
       int code = checkInputInteger();
       Worker worker = checkWorker(w, code);
       if(w != null){
            System.out.println("Enter salary: ");
            int salary = checkInputInteger();
            if(salary > 0){
                int salaryCurrent = worker.getSalary();
                int total = salaryCurrent + salary;
                s.add(new SalaryHistory(worker.getId(), worker.getName(), worker.getAge(), salary, worker.getWorkLocation(), "UP", currentDate()));
                worker.setSalary(total);
            }else{
                System.out.println("Must greater than 0!");
            }
       }else{
           System.err.println("Not found!");
       }
      
   }
   public void decreaseSalary(ArrayList<Worker> w, ArrayList<SalaryHistory> s){
       System.out.println("Enter code(ID): ");
       int code = checkInputInteger();
       Worker worker = checkWorker(w, code);
       if(w != null){
            System.out.println("Enter salary: ");
            int salary = checkInputInteger();
            if(salary > 0){
                int salaryCurrent = worker.getSalary();
                if(salaryCurrent > salary){
                int total = salaryCurrent - salary;
                s.add(new SalaryHistory(worker.getId(), worker.getName(), worker.getAge(), salary, worker.getWorkLocation(), "UP", currentDate()));
                worker.setSalary(total);
            }else{
                System.out.println("Must greater than current salary!");
            }
       }else{
           System.err.println("Not found!");
       }
      
   }
   }
   public void displaySalaryHistory(ArrayList<SalaryHistory> s){
       if(s.isEmpty()){
           System.err.println("The list is empty");
       }else{
           for(SalaryHistory salary : s){
               System.out.println(salary.toString());
           }
       }
   }
   private Worker checkWorker(ArrayList<Worker> w, int code){
       for (Worker worker : w){
           if(code == worker.getId()){
               return worker;
           }
       }
       return null;
   }
   public String currentDate(){
       SimpleDateFormat date = new SimpleDateFormat("dd/MM/yyyy HH:mm");
       Calendar calendar = Calendar.getInstance();
       return date.format(calendar.getTime());
   }
}
