package org.example;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import java.util.ArrayList;

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
    private int maxScore;

    public Course(String courseName, double credits, Department department) {
        this.courseName = Util.toTitleCase(courseName);
        this.credits = credits;
        this.department = department;
        this.assignments = new ArrayList<>();
        this.registeredStudents = new ArrayList<>();
        this.finalScores = new ArrayList<>();
        this.courseId = "C-" + department.getDepartmentId() + "-" + String.format("%02d", nextId++);
    }
    /**
     * Checks if the Assignment sum of weights is equal to 100
     * @return
     */
    public boolean isAssignmentWeightValid() {
        double sum = 0.0;
        for (Assignment assignment : assignments) sum += assignment.getWeight();
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
        for (Assignment assignment : assignments) {
            assignment.getScores().add(null);
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
            for (Assignment assignment : assignments) {
                Integer score = assignment.getScores().get(i);
                if (score != null) {
                    total += score * (assignment.getWeight() / 100.0);
                }}
            averages[i] = (int) Math.round(total);
        }
        return averages;
    }
    /**
     * Adds a new assignment to the course
     * @param assignmentName Name of the Assignment
     * @param weight The weightage of the Asignment
     * @param maxScore The Max score poible
     * @return true or false for the Assignment being added ro no
     */
    public boolean AddAssignment(String assignmentName, double weight, int maxScore) {
        Assignment assignment = new Assignment(assignmentName, weight, maxScore);
        for (int i = 0; i < registeredStudents.size(); i++) {
            assignment.getScores().add(null);
        }
        assignments.add(assignment);
        return true;
    }
    /**
     * Calculates Assignment Averages
     * @param assignment The assignment
     * @return Assignments averages
     */
    private int calcAssignmentAverage(Assignment assignment) {
        int sum = 0;
        int count = 0;
        for (Integer score : assignment.getScores()) {
            if (score != null) {
                sum += score;
                count++;
            }
        }
        return (count == 0) ? 0 : (int) Math.round((double) sum / count);
    }

    /**
     * generates random scores for each assignment and student, and calculates the final score for each student.
     */
    public void generateScores() {
        for (Assignment assignment : assignments) {
            assignment.generateRandomScore();
        }
        int[] averages = calcStudentsAverage();
        for (int i = 0; i < averages.length; i++) {
            finalScores.set(i, averages[i]);
        }
    }
    /**
     * Displays score course in a table format
     */
    public void displayScores() {
        System.out.println("Course: " + courseName + "(" + courseId + ")");
        System.out.printf("%-25s", "");
        for (Assignment a : assignments) {
            System.out.printf("%-15s", a.getAssignmentName());
        }
        System.out.printf("%-15s%n", "Final Score");
        for (int i = 0; i < registeredStudents.size(); i++) {
            Student s = registeredStudents.get(i);
            System.out.printf("%-25s", s.getStudentName());
            for (Assignment a : assignments) {
                System.out.printf("%-15d", a.getScores().get(i));
            }
            System.out.printf("%-15d%n", finalScores.get(i));
        }
        System.out.printf("%-25s", "Average");
        for (Assignment a : assignments) {
            System.out.printf("%-15d", calcAssignmentAverage(a));
        }
        System.out.println();
    }
    public String toSimplifiedString() {
        return courseId + " | " + courseName + " | " + credits + " | " + department.getDepartmentName();
    }
    @Override
    public String toString() {
        return "Course{" +
                "courseId='" + courseId + '\'' +
                ", courseName='" + courseName + '\'' +
                ", credits=" + credits +
                ", department=" + department +
                ", assignments=" + assignments +
                ", registeredStudents=" + registeredStudents +
                '}';
    }
}
