package com.algorithm.disce.topic.interview;

import java.util.Stack;

public class QStudentScore {

    private Stack<Integer> scores;

    private Stack<Integer> min;

    public QStudentScore() {
        scores = new Stack<>();
        min = new Stack<>();
    }

    public void saveScore(int score) {
        if (min.empty() || min.peek() >= score) {
            min.add(score);
        }
        scores.add(score);
    }

    public int delScore() {
        Integer pop = scores.pop();
        if (pop.equals(min.peek())) {
            min.pop();
        }
        return pop;
    }

    public int getMinScore() {
        return min.peek();
    }
}
