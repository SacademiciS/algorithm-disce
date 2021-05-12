package com.algorithm.disce.topic;

import java.util.Arrays;

public class QuestionThree {

    public static Integer removeDuplicates(int[] a) {
        if (a == null || a.length == 0) {
            return 0;
        }
        Arrays.sort(a);
        int number = 0;
        for (int i = 1; i < a.length; i++) {
            if (a[number] != a[i]) {
                number++;
                a[number] = a[i];
            }
        }
        return ++number;
    }

    public static void main(String[] args) {
        int[] nums = {1, 1, 2};
        int i = removeDuplicates(nums);
        System.out.println(i);
        System.out.println(Arrays.toString(nums));
    }

}
