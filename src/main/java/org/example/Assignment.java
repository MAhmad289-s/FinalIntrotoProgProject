package org.example;

import java.util.ArrayList;

public class Assignment {
    private String assignmentId;
    private String assignmentName;
    private double weight;
    private ArrayList<Integer> scores;
    private static int nextId = 1;

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



}
