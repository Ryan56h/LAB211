
package Week_5.ShortP109.main;

import ShortP109.main.CourseManagement;
import ShortP109.main.Validation;

  
public class Test {
    
      public static void main(String[] args) {
          CourseManagement cm = new CourseManagement();
          Validation validate = new Validation();
        while (true) {
            System.out.println("*** Course Management ***");
            System.out.println("1. Add online course/ offline course");
            System.out.println("2. Update course");
            System.out.println("3. Delete course");
            System.out.println("4. Print all / online course / offline course");
            System.out.println("5. Search information base on course name");
            System.out.println("6. Exit");
            System.out.println("You choose: ");
            int choice = validate.inputPositiveInteger();
            
            switch(choice){
                case 1: cm.addCourse(); break;
                case 2: cm.updateCourse(); break;
                case 3: cm.deleteCourse(); break;
                case 4: cm.printAllCourses(); break;
                case 5: cm.searchCourse(); break;
                case 6: return;
            }
        }
    }
}
