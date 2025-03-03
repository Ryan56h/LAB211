package ShortP109.main;

import ShortP109.model.Course;
import ShortP109.model.OfflineCourse;
import ShortP109.model.OnlineCourse;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class CourseManagement {

    private  List<OnlineCourse> online = new ArrayList();
    private  List<OfflineCourse> offline = new ArrayList();
    private  Scanner scanner = new Scanner(System.in);
    private  Validation validate = new Validation();
    
  public void addCourse() {
    System.out.println("*** Add new course ***");
    System.out.println("Online (O) or Offline (F): ");
    String type = validate.inputString().trim().toUpperCase();

    while (!type.equals("O") && !type.equals("F")) {
        System.err.println("Data input is invalid");
        System.out.println("Online (O) or Offline (F): ");
        type = validate.inputString().trim().toUpperCase();
    }
    
    System.out.print("Course ID: ");
    String courseId = validate.inputString();
      if (validate.checkIdExist(online, courseId) || validate.checkIdExist(offline, courseId)) {
          System.err.println("Data input is invalid, ID must be unique");
          return;
      }
    System.out.print("Course name: ");
    String courseName = validate.inputString();
    System.out.print("Credits: ");
    int credits = validate.inputCredits();

    if (type.equals("O")) {
        System.out.print("Platform: ");
        String platform = validate.inputString().trim();
        System.out.print("Instructors: ");
        String instructor = validate.inputString().trim();
        System.out.print("Note: ");
        String note = validate.inputString().trim();

        OnlineCourse onlineCourse = new OnlineCourse();
        onlineCourse.inputAll(courseId, courseName, credits, platform, instructor, note);
        online.add(onlineCourse);
    } else {
        Date beginDate, endDate;
        while (true) {
            System.out.print("Begin: ");
            beginDate = validate.dateValidation();
            System.out.print("End: ");
            endDate = validate.dateValidation();

            if (!endDate.after(beginDate)) {
                System.err.println("Data input is invalid, end must be after begin");
                continue;
            }
            break;
        }

        System.out.print("Campus: ");
        String campus = validate.inputString();

        OfflineCourse offlineCourse = new OfflineCourse();
        offlineCourse.inputAll(courseId, courseName, credits, beginDate, endDate, campus);
        offline.add(offlineCourse);
    }
    
    System.out.println("Course added successfully!");
}

    public void updateCourse(){
        
        if(offline.isEmpty() && online.isEmpty()){
            System.out.println("No courses available to update.");
            return;
        }
        while (true) {            
            System.out.println("*** Update course ***");
            System.out.print("Course ID: ");
            String id = validate.inputString().trim();
            Course courseToUpdate = null ;
            for (OnlineCourse oc : online) {
            if (oc.getId().equalsIgnoreCase(id)) {
                courseToUpdate = oc;
                break;
            }
        }
        for (OfflineCourse ofc : offline) {
            if (ofc.getId().equalsIgnoreCase(id)) {
                courseToUpdate = ofc;
                break;
            }
        }
            if(courseToUpdate == null){
                System.out.println("No data found, do you want to find again? (Y/N): ");
                String again = validate.inputString().trim().toUpperCase();
                if(!again.equals("Y")){
                return;
            }
                continue;
            }
        
           
         System.out.println("*** Search results ***");
        System.out.println("Course ID: " + courseToUpdate.getId());
        System.out.println("Course name: " + courseToUpdate.getName());
        System.out.println("Credits: " + courseToUpdate.getCredits());

        if (courseToUpdate instanceof OnlineCourse) {
            OnlineCourse onlineCourse = (OnlineCourse) courseToUpdate;
            System.out.println("Platform: " + onlineCourse.getPlatform());
            System.out.println("Instructors: " + onlineCourse.getInstructors());
            System.out.println("Note: " + onlineCourse.getNote());
        } else if (courseToUpdate instanceof OfflineCourse) {
            OfflineCourse offlineCourse = (OfflineCourse) courseToUpdate;
            System.out.println("Begin: " + offlineCourse.getBegin());
            System.out.println("End: " + offlineCourse.getEnd());
            System.out.println("Campus: " + offlineCourse.getCampus());
        }

     
        System.out.println("\n*** Updating ***");
        System.out.println("Note: Enter empty if you don't want to change it.");

        System.out.print("Course ID: ");
        String newId = scanner.nextLine().trim();
        if (!newId.isEmpty()) {
            courseToUpdate.setId(newId);
        }

        System.out.print("Course name: ");
        String newName = scanner.nextLine().trim();
        if (!newName.isEmpty()) {
            courseToUpdate.setName(newName);
        }

        System.out.print("Credits: ");
        String creditsStr = scanner.nextLine().trim();
        if (!creditsStr.isEmpty()) {
            try {
                int credits = Integer.parseInt(creditsStr);
                if (credits > 0) {
                    courseToUpdate.setCredits(credits);
                } else {
                    System.out.println("Invalid input, credits must be greater than 0!");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input, must be a number!");
            }
        }

        if (courseToUpdate instanceof OnlineCourse) {
            OnlineCourse onlineCourse = (OnlineCourse) courseToUpdate;

            System.out.print("Platform: ");
            String newPlatform = scanner.nextLine().trim();
            if (!newPlatform.isEmpty()) {
                onlineCourse.setPlatform(newPlatform);
            }

            System.out.print("Instructors: ");
            String newInstructors = scanner.nextLine().trim();
            if (!newInstructors.isEmpty()) {
                onlineCourse.setInstructors(newInstructors);
            }

            System.out.print("Note: ");
            String newNote = scanner.nextLine().trim();
            if (!newNote.isEmpty()) {
                onlineCourse.setNote(newNote);
            }
        }

        if (courseToUpdate instanceof OfflineCourse) {
            OfflineCourse offlineCourse = (OfflineCourse) courseToUpdate;

            System.out.print("Begin: ");
            String beginDateStr = scanner.nextLine().trim();
            if (!beginDateStr.isEmpty()) {
                Date newBegin = validate.dateValidation();
                if (newBegin != null) {
                    offlineCourse.setBegin(newBegin);
                }
            }

            System.out.print("End: ");
            String endDateStr = scanner.nextLine().trim();
            if (!endDateStr.isEmpty()) {
                while (true) {
                    Date newEnd = validate.dateValidation();
                    if (newEnd != null) {
                        if (newEnd.after(offlineCourse.getBegin())) {
                            offlineCourse.setEnd(newEnd);
                            break;
                        } else {
                            System.out.println("End date must be after Begin date. Please enter again.");
                        }
                    } else {
                        break;
                    }
                }
            }

            System.out.print("Campus: ");
            String campus = scanner.nextLine().trim();
            if (!campus.isEmpty()) {
                offlineCourse.setCampus(campus);
            }
        }

        System.out.println("Updated successfully!");
        break;
    }
    }
    public void deleteCourse() {
    if (online.isEmpty() && offline.isEmpty()) {
        System.out.println("No courses available to delete.");
        return;
    }

    System.out.println("*** Delete course ***");
    System.out.print("Enter Course ID: ");
    String id = validate.inputString().trim();

    Course foundCourse ;
    for (Course course : online) {
        if (course.getId().equals(id)) {
            foundCourse = course;
            online.remove(course);
            break;
        }
    }
    for (Course course : offline) {
        if (course.getId().equals(id)) {
            foundCourse = course;
            offline.remove(course);
            break;
        }
    }

   
}
    public  void printAllCourses() {
    if (online.isEmpty() && offline.isEmpty()) {
        System.out.println("No courses available.");
        return;
    }

    System.out.println("*** List of Courses ***");
    System.out.println("Online Courses:");
    for (Course course : online) {
        course.display();
        System.out.println();  
    }

    System.out.println("Offline Courses:");
    for (Course course : offline) {
        course.display();
        System.out.println();  
    }
}

public void searchCourse() {
    if (online.isEmpty() && offline.isEmpty()) {
        System.out.println("No courses available.");
        return;
    }
    System.out.println("*** Searching ***");
    System.out.print("Course ID: ");
    String id = validate.inputString().trim();
    Course foundCourse = null;

    System.out.println("*** Search Results ***");

    for (Course course : online) {
         if (course.getId().equalsIgnoreCase(id)) {
            course.display();
            foundCourse  = course;
            break;
        }
    }
    
    for (Course course : offline) {
        if (course.getId().equalsIgnoreCase(id)) {
            course.display();
            foundCourse  = course;
            break;
        }
    }

    if (foundCourse != null) {
        System.out.println("*** Course Found ***");
        foundCourse.display();
    } else {
        System.out.println("No course found with ID: " + id);
    }


    
}
}
