package com.google.hashcode.model;

import java.util.List;

public class Scores {
    private List<Integer> scores;

    public Scores(List<Integer> scores) {
        this.scores = scores;
    }

    public List<Integer> getScores() {
        return scores;
    }

    public void setScores(List<Integer> scores) {
        this.scores = scores;
    }
}
