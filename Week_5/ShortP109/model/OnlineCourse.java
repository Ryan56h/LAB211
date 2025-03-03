/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ShortP109.model;

/**
 *
 * @author Admin
 */
public class OnlineCourse extends Course {

    private String platform;
    private String instructors;
    private String note;

    public OnlineCourse() {
        super();
        platform = "";
        instructors = "";
        note = "";

    }

    public void inputAll(String id, String name, int credits, String platform, String instructor, String note) {
        super.inputAll(id, name, credits);
        this.platform = platform;
        this.instructors = instructor;
        this.note = note;
    }

    public String getPlatform() {
        return platform;
    }

    public void setPlatform(String platform) {
        this.platform = platform;
    }

    public String getInstructors() {
        return instructors;
    }

    public void setInstructors(String instructors) {
        this.instructors = instructors;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
 
    @Override
public void display() {
    super.display();
    System.out.printf(" %-20s %-20s %-20s\n", platform, instructors, note);
}

}
