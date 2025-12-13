package org.example;

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

    /**Calculates the average score for this assignment.
     *
     */
    public void calcAssignmentAvg() {
        if (!scores.isEmpty()) {
            int sum = 0;
            for (Integer s : scores) {
                if (s != null) {
                    sum += s;
                }
            }
            double avg = (double) sum / scores.size();
        } else {
            return;
        }
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
