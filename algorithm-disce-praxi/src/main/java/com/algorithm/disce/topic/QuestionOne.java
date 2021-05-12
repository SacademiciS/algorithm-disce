package com.algorithm.disce.topic;

import java.util.HashSet;

public class QuestionOne {

    public int[] removeDuplicateNode(int[] a) {
        HashSet<Integer> set = new HashSet<>(a.length);
        for (int value : a) {
            set.add(value);
        }
        int[] res = new int[set.size()];
        int index = 0;
        for (Integer i : set) {
            res[index++] = i;
        }
        return res;
    }

}
