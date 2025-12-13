package org.example;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Collection;

@Setter
@Getter
@EqualsAndHashCode
public class Course {
    private String courseId;
    private String courseName;
    private double credits;
    private Department department;
    private ArrayList<Assignment> assignments;
    private ArrayList<Student> registeredStudents;
    private ArrayList<Integer> finalScores;
    private static int nextId = 1;

    /**
     * Checks if the Assignment sum of weights is equal to 100
     * @return
     */
    public boolean isAssignmentWeightValid() {
        double sum = 0.0;
        for (Assignment a : assignments) sum += a.getWeight();
        return sum == 100.0;
    }

    /**
     * Adds a student to the student list of the course,also a new null element
     * to each assignment of this course and a for finl scores
     * @param student The student Class
     * @return true or false
     */
    public boolean registerStudent(Student student) {
        if (registeredStudents.contains(student)) return false;
        registeredStudents.add(student);
        for (Assignment a : assignments) {
            a.getScores().add(null);
        }
        finalScores.add(null);
        return true;
    }
    /**
     * calculates the weighted average score of a student.
     * @return the weighted average
     */
    public int[] calcStudentsAverage() {
        int[] averages = new int[registeredStudents.size()];
        for (int i = 0; i < registeredStudents.size(); i++) {
            double total = 0.0;
            for (Assignment a : assignments) {
                Integer score = a.getScores().get(i);
                if (score != null) {
                    total += score * (a.getWeight() / 100.0);
                }
            }
            averages[i] = (int) Math.round(total);
        }
        return averages;
    }
    public boolean addAssignment(String assignmentName, double weight, int maxScore) {
        Assignment a = new Assignment(assignmentName, weight, maxScore);
        for (int i = 0; i < registeredStudents.size(); i++) {
            a.getScores().add(null);
        }
        assignments.add(a);
        return true;
    }
}
