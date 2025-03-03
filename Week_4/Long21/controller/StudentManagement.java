package controller;
import model.StudentList;
import view.Menu;
import view.StudentListView;

public class StudentManagement {
    public static void main(String[] args) {
        StudentList sl = new StudentList();
        StudentListView slv = new StudentListView(sl);

        String[] options = {
            "Add a new student",
            "Display all students",
            "Update or delete students",
            "Generate student report",
            "Exit"
        };

        Menu menu = new Menu("Student Management System", options) {
            @Override
            public void execute(int n) {
                switch (n) {
                    case 1:
                       slv.addStudent();
                        break;
                    case 2:
                        slv.showAllStudents();
                        break;
                    case 3:
                        slv.updateOrDeleteStudent();
                        break;
                    case 4:
                        slv.showStudentReport();
                        break;
                    case 5:
                        System.exit(0);
                }
            }
        };
        menu.run();
    }
}
