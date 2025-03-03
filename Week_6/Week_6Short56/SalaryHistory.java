package Week_6Short56;


public class SalaryHistory extends Worker {
    private String status;
    private String date; 

    public SalaryHistory() {
    }

    public SalaryHistory(int id, String name, int age, int salary, String workLocation, String status, String date) {
        super(id, name, age, salary, workLocation);
        this.status = status;
        this.date = date;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public String toString() {
        super.toString();
        return "SalaryHistory{" + "status=" + status + ", date=" + date + '}';
    }

    
    
    
}
