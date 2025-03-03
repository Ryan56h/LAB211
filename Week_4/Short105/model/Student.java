package Week_4.Short105;


class Student extends Person {
    private int yearOfAdmission;
    private int entranceEnglishScore;

    public Student() {
        super();
        yearOfAdmission = 0;
        entranceEnglishScore = 0;
    }

    public void inputAll(int year, int englishScore, String id, String name, int fNum, int yearOfBirth, String major) {
        super.inputAll(id, name, fNum, yearOfBirth, major);
        yearOfAdmission = year;
        entranceEnglishScore = englishScore;
    }

    public void display() {
        super.display();
        System.out.printf(" %-6d %-6d\n", yearOfAdmission, entranceEnglishScore);
    }

   
}

