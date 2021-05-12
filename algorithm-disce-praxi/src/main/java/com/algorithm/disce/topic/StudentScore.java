package com.algorithm.disce.topic;

import java.util.Stack;

public class StudentScore {

    private Stack<Integer> stack;

    private Stack<Integer> lowerStack;

    public StudentScore() {
        stack = new Stack();
        lowerStack = new Stack<>();
    }

    public void saveScore(int score) {
        if (lowerStack.isEmpty() || lowerStack.peek() >= score) {
            lowerStack.add(score);
        }
        stack.add(score);
    }

    public Integer removeScore() {
        Integer pop = stack.pop();
        if (pop.equals(lowerStack.peek())) {
            lowerStack.pop();
        }
        return pop;
    }

    public Integer getLoweScore() {
        return lowerStack.peek();
    }
}
