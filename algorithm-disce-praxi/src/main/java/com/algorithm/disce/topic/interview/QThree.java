package com.algorithm.disce.topic.interview;

import java.util.Arrays;

public class QThree {

    public static Integer removeDuplicateScores(int[] arr) {
        if (arr == null || arr.length == 0) return 0;
        Arrays.sort(arr);
        int size = arr.length;
        int l = 0;
        for (int r = 1; r < size; r++) {
            if (arr[l] != arr[r]) {
                arr[++l] = arr[r];
            }
        }
        return ++l;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        System.out.println(removeDuplicateScores(arr));
        System.out.println(Arrays.toString(arr));
    }
}
