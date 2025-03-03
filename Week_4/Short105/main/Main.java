package Week_4.Short105;


import Week_4.Short105.main.Validation;
import java.util.*;

public class Main {
    private static List<Teacher> teachers = new ArrayList<>();
    private static List<Student> students = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);
    private static Validation validate = new Validation();
    public  static void main(String[] args) {
        
        while (true) {
            System.out.println("*** Information Management ***");
            System.out.println("1. Teacher");
            System.out.println("2. Student");
            System.out.println("3. Person");
            System.out.println("4. Exit");
            System.out.print("You choose: ");
            int choice = validate.inputPositiveInteger();

            switch (choice) {
                case 1: manageTeachers(); break;
                case 2: manageStudents(); break;
                case 3: managePersons(); break;
                case 4: System.out.println("Exitting..."); return;
                default: System.out.println("Invalid choice!");
            }
        }
    }

    private static void manageTeachers() {
        while (true) {
            System.out.println("*** Teacher Management ***");
            System.out.println("1. Input");
            System.out.println("2. Print");
            System.out.println("3. Exit");
            System.out.print("You choose: ");
            int choice = validate.inputPositiveInteger();

            switch (choice) {
                case 1:
                    Teacher t = new Teacher();
                    System.out.print("ID: ");
                    String id = validate.inputID();
                    System.out.print("Full Name: ");
                    String name = validate.inputString();
                    System.out.print("Phone Number: ");
                    int phone = validate.inputPositiveInteger();
                    System.out.print("Year of Birth: ");
                    int birthYear = validate.inputValidYear(1900, java.time.Year.now().getValue() - 18);
                    System.out.print("Major: ");
                    String major = validate.inputString();
                    System.out.print("Year in the Profession: ");
                    int year = validate.inputValidYear(0, java.time.Year.now().getValue() - birthYear);
                    System.out.print("Contract Type (Long/Short): ");
                    String contractType = validate.inputContractType();
                    System.out.print("Salary Coefficient: ");
                    double salary = validate.inputPositiveDouble();

                    t.inputAll(year, contractType, salary, id, name, phone, birthYear, major);
                    teachers.add(t);
                    break;

                case 2:
                    
                    teachers.forEach(Teacher::display);
                    break;
                case 3: return;
                default: System.out.println("Invalid choice!");
            }
        }
    }

    private static void manageStudents() {
        while (true) {
            System.out.println("*** Student Management ***");
            System.out.println("1. Input");
            System.out.println("2. Print");
            System.out.println("3. Exit");
            System.out.print("You choose: ");
            int choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1:
                    Student s = new Student();
                    System.out.print("ID: ");
                    String id = validate.inputID();
                    System.out.print("Full Name: ");
                    String name = validate.inputString();
                    System.out.print("Phone Number: ");
                    int phone = validate.inputPositiveInteger();
                    System.out.print("Year of Birth: ");
                    int birthYear = validate.inputValidYear(1900, java.time.Year.now().getValue() - 18);
                    System.out.print("Major: ");
                    String major = validate.inputString();
                    System.out.print("Year of Admission: ");
                    int admissionYear = validate.inputValidYear(birthYear, java.time.Year.now().getValue());
                    System.out.print("Entrance English Score: ");
                    int englishScore = validate.inputScore();

                    s.inputAll(admissionYear, englishScore, id, name, phone, birthYear, major);
                    students.add(s);
                    break;
                case 2:
                  
                    students.forEach(Student::display);
                    break;
                case 3: return;
                default: System.out.println("Invalid choice!");
            }
        }
    }

    private static void managePersons() {
        System.out.print("Name: ");
        String name = scanner.nextLine();
        boolean found = false;
        for (Person p : teachers) {
            if (p.getFullName().contains(name)) {
                p.display();
                found = true;
            }
        }
        for (Person p : students) {
            if (p.getFullName().contains(name)) {
                p.display();
                found = true;
            }
        }
        if (!found) System.out.println("Result: not found");
    }
}

