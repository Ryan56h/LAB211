package model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;

public class StudentList {

    private ArrayList<Student> students = new ArrayList<>();

    public StudentList() {
        this.students = new ArrayList<>();
    }

    public void addStudent(Student student) {
        if (student != null) {
            students.add(student);
            
        } else {
            System.out.println("Invalid student data.");
        }
    }

    public ArrayList<Student> getStudents() {
        return students;
    }

    public List<Student> searchStudents(Predicate<Student> predicate) {
        List<Student> result = new ArrayList<>();
        for (Student student : students) {
            if (predicate.test(student)) {
                result.add(student);
            }
        }
        return result;
    }

    public void sortStudentsByName(ArrayList<Student> students) {
        Collections.sort(students, Comparator.comparing(Student::getName));
    }

    public boolean updateOrDeleteStudent(String id, String action, String name, String semester, String courseName) {
        Iterator<Student> iterator = students.iterator();
        while (iterator.hasNext()) {
            Student student = iterator.next();
            if (student.getId().equalsIgnoreCase(id)) {
                if (action.equalsIgnoreCase("U")) {
                    student.setName(name);
                    student.setSemsester(semester);
                    student.setCourseName(courseName);
                    return true;
                } else if (action.equalsIgnoreCase("D")) {
                    iterator.remove();
                    return true;
                }
            }
        }
        return false;
    }

    public Map<String, Integer> reportStudents() {
        Map<String, Integer> report = new HashMap<>();
        for (Student student : students) {
            String key = student.getId() + " | " + student.getName() + " | " + student.getSemsester() + " | " + student.getCourseName();
            report.put(key, report.getOrDefault(key, 0) + 1);
        }
        return report;
    }

}
