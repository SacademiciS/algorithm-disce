package com.algorithm.disce.topic.sort.comparison.two;

import java.util.Arrays;

public class BubbleSortTwo {

    public void sort(int[] arr) {
        int len = arr.length;
        for (int i = 0; i < len; i++) {
            for (int j = 1; j < len - i; j++) {
                if (arr[j - 1] > arr[j]) {
                    int temp = arr[j];
                    arr[j] = arr[j - 1];
                    arr[j - 1] = temp;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = {2, 5, 7, 3, 9, 3};
        BubbleSortTwo o = new BubbleSortTwo();
        o.sort(nums);
        System.out.println(Arrays.toString(nums));
    }
}
