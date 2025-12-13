package org.example;

import jdk.jshell.execution.Util;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;

@Getter
@Setter
@ToString
@EqualsAndHashCode
public class Assignment {
    private String assignmentId;
    private String assignmentName;
    private double weight;
    private ArrayList<Integer> scores;
    private static int nextId = 1;

    public Assignment(String assignmentName, double weight, int maxScore) {
        this.assignmentId = String.format("%02d", nextId++);
        this.assignmentName = assignmentName;
        this.weight = weight;
        this.scores = new ArrayList<>();
    }
    /**Calculates the average score for this assignment.
     *
     */
    public void calcAssignmentAvg() {
        int sum = 0;
        int count = 0;
        for (Integer s : scores) {
            if (s != null) {
                sum += s;
                count++;
            }
        }
        int avg = (count == 0) ? 0 : (int) Math.round((double) sum / count);
    }
    /**
     * Generates random scores for all students in this assignment.
     */
    public void generateRandomScore() {
        java.util.Random rand = new java.util.Random();
        for (int i = 0; i < scores.size(); i++) {
            int r = rand.nextInt(11);
            int score;
            if (r == 0) {
                score = rand.nextInt(60);
            } else if (r == 1 || r == 2) {
                score = 60 + rand.nextInt(10);
            } else if (r == 3 || r == 4) {
                score = 70 + rand.nextInt(10);
            } else if (r >= 5 && r <= 8) {
                score = 80 + rand.nextInt(10);
            } else {
                score = 90 + rand.nextInt(11);
            }
            scores.set(i, score);
        }
    }
    @Override
    public String toString() {
        return "Assignment{" +
                "assignmentId='" + assignmentId + '\'' +
                ", assignmentName='" + assignmentName + '\'' +
                ", weight=" + weight +
                '}';
    }
}
