package model;

public class Student {

    private String id;
    private String name;
    private String semsester;
    private String courseName;

    public Student(String id, String name, String semsester, String courseName) {
        this.id = id;
        this.name = name;
        this.semsester = semsester;
        this.courseName = courseName;
    }
    
    public Student() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSemsester() {
        return semsester;
    }

    public void setSemsester(String semsester) {
        this.semsester = semsester;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

   
    @Override
public String toString() {
    return String.format("| %-10s | %-20s | %-10s | %-10s |",
                         id, name, semsester, courseName);
}

    
    
}
