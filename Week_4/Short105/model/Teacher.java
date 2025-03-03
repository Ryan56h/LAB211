
package Week_4.Short105;


class Teacher extends Person {

    private int yearInProfession;
    private String contract;
    private double salary;

    public Teacher() {
        super();
        yearInProfession = 0;
        contract = "";
        salary = 0.0;
    }

    public void inputAll(int year, String contractType, double salaryy, String id, String name, int fNum, int yearOfBirth, String major) {
        super.inputAll(id, name, fNum, yearOfBirth, major);
        yearInProfession = year;
        contract = contractType;
        salary = salaryy;
    }

    public void display() {
        super.display();
        System.out.printf(" %-6d %-6s %-6.1f\n", yearInProfession, contract, salary);
    }

   

    

   
}
