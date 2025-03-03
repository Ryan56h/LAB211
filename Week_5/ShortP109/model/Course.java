package ShortP109.model;

public class Course {

    private String id;
    private String name;
    private int credits;

    public Course() {
        id = "";
        name = "";
        credits = 0;
    }

    public void inputAll(String id, String name, int credits) {
        this.id = id;
        this.name = name;
        this.credits = credits;
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

    public int getCredits() {
        return credits;
    }

    public void setCredits(int credits) {
        this.credits = credits;
    }
    

    public void display() {
    System.out.printf("%-6s %-20s %-6d", id, name, credits); // Sử dụng %d cho số nguyên
}


}
