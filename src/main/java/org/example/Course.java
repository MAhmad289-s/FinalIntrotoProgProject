package org.example;

import java.util.ArrayList;
import java.util.Collection;

public class Course {
    private String courseId;
    private String courseName;
    private double credits;
    private Department department;
    private ArrayList<Assignment> assignments;
    private ArrayList<Student> registeredStudents;
    private ArrayList<Integer> finalScores;
    private static int nextId = 1;

    public boolean isAssignmentWeightValid() {
        double sum = 0.0;
        for (Assignment assignment : assignments) {
            sum += assignment.getWeight();
        }
        return sum == 100.0;
    }
    public boolean registerStudent(Student student) {
        if (registeredStudents.contains(student)) {
            return false;
        }
        registeredStudents.add(student);
        for (Assignment assignment : assignments) {
            assignment.getScores().add(null);
        }
        finalScores.add(null);
        return true;
    }

    public Collection<Student> getRegisteredStudents() {
    }

    public char[] getCourseId() {
    }

    public char[] getCourseName() {
    }

    public Object getDepartment() {
        return null;
    }
}
