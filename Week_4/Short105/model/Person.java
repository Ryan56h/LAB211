

package Week_4.Short105;

class Person {
    private String id;
    private String fullName;
    private int phoneNumber;
    private int yearOfBirth;
    private String major;
    
    public Person() {
        id = "";
        fullName = "";
        phoneNumber = 0;
        yearOfBirth = 0;
        major = "";
    }

    public void inputAll(String ID, String name, int phone, int year, String majorr) {
         id = ID;
         fullName = name;
         phoneNumber = phone;
         yearOfBirth = year;
         major = majorr;
    }

    public void display() {
        System.out.printf("%-6s %-20s %-15s %-6d %-30s", id, fullName, phoneNumber, yearOfBirth, major);
    }

    public String getFullName() {
        return fullName;
    }
    
}

