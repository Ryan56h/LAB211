package view;

import java.util.ArrayList;
import java.util.Scanner;

public abstract class Menu<M> {
    protected String title;
    protected ArrayList<M> choice;

    public Menu() {
    }

    public Menu(String title, String[] Options) {
        this.title = title;
        this.choice = new ArrayList<>();
        for (String s : Options){
            choice.add((M) s);
        }
    }
    public  void display(){
        System.out.println(title);
        System.out.println("----------------------------------------");
        for (int i = 0; i < choice.size(); i++ ){
            System.out.println((i+1) + "." + choice.get(i));
        }  
        System.out.println("Enter another option to exit the menu");
        System.out.println("----------------------------------------");
        
    
    }
    public int getSelected(){
        display();
        Scanner input = new Scanner(System.in);
        int result;
        System.out.println("Enter selection: ");
        while(true){
            try {
                result = Integer.parseInt(input.nextLine());
                return result;
            } catch (NumberFormatException e) {
                System.out.println("Enter agian!");
                System.out.println("Enter integer number.");
            }
        }
    }
    public abstract void execute(int n);
    
    public void run(){
        while (true){
            int n = getSelected();
            if (n <= choice.size()){
                execute(n); 
            }else{
                break;
            }
        }
    }
    
}
