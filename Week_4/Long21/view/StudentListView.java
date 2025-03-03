package view;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import model.Student;
import model.StudentList;

public class StudentListView {

    StudentList studentList = new StudentList();
    Scanner scanner = new Scanner(System.in);
    public StudentListView(StudentList studentList) {
        this.studentList = studentList;
    }

    public void showAllStudents() {
        List<Student> students = studentList.getStudents();
        if (students.isEmpty()) {
            System.out.println("No students in the list.");
        } else {
            System.out.println("List of students:");
            for (Student student : students) {
                System.out.println(student);
            }
        }
    }
    

    public void addStudent() {
        System.out.print("Enter student ID: ");
        String id = scanner.nextLine();
        System.out.print("Enter student name: ");
        String name = scanner.nextLine();
        System.out.print("Enter semester: ");
        String semester = scanner.nextLine();
        System.out.print("Enter course name: ");
        String courseName = scanner.nextLine();

        Student student = new Student(id, name, semester, courseName);
        studentList.addStudent(student);
        System.out.println("Student added successfully.");
    }

    public void updateOrDeleteStudent() {
        System.out.print("Enter student ID: ");
        String id = scanner.nextLine();
        System.out.print("Do you want to update (U) or delete (D) student? ");
        String choice = scanner.nextLine();

        if (choice.equalsIgnoreCase("U")) {
            System.out.print("Enter new student name: ");
            String newName = scanner.nextLine();
            System.out.print("Enter new semester: ");
            String newSemester = scanner.nextLine();
            System.out.print("Enter new course name: ");
            String newCourseName = scanner.nextLine();

            boolean success = studentList.updateOrDeleteStudent(id, "U", newName, newSemester, newCourseName);
            if (success) {
                System.out.println("Student updated successfully.");
            } else {
                System.out.println("Student not found.");
            }
        } else if (choice.equalsIgnoreCase("D")) {
            boolean success = studentList.updateOrDeleteStudent(id, "D", "", "", "");
            if (success) {
                System.out.println("Student deleted successfully.");
            } else {
                System.out.println("Student not found.");
            }
        } else {
            System.out.println("Invalid choice.");
        }
    }
    public void showStudentReport() {
        Map<String, Integer> report = studentList.reportStudents();
        if (report.isEmpty()) {
            System.out.println("No student data available for reporting.");
        } else {
            System.out.println("===== Student Report =====");
            for (Map.Entry<String, Integer> entry : report.entrySet()) {
                System.out.println(entry.getKey() + " - " + entry.getValue() + " time(s)");
            }
        }
        
    }

}
