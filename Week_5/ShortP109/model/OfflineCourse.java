package ShortP109.model;

import java.text.SimpleDateFormat;
import java.util.Date;


public class OfflineCourse extends Course {
     private Date begin;
    private Date end;
    private String campus;

    public OfflineCourse() {
        super();
        this.begin = null;
        this.end = null;
        this.campus = "";

    }

    public void inputAll(String campuss, String id, int credits, Date beginn, Date endd, String name) {
       super.inputAll(id, name, credits);
       begin = beginn;
       end = endd ;
       campus = campuss;
    }

    public Date getBegin() {
        return begin;
    }

    public void setBegin(Date begin) {
        this.begin = begin;
    }

    public Date getEnd() {
        return end;
    }

    public void setEnd(Date end) {
        this.end = end;
    }

    public String getCampus() {
        return campus;
    }

    public void setCampus(String campus) {
        this.campus = campus;
    }
    
    @Override
public void display() {
    super.display();
    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    System.out.printf(" %-15s %-15s %-20s\n", sdf.format(begin), sdf.format(end), campus);
}


    
}
