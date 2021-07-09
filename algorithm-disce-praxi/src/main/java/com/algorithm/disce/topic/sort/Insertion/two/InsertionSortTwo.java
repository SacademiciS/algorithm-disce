package com.algorithm.disce.topic.sort.Insertion.two;

import java.util.Arrays;

public class InsertionSortTwo {

    public void sort(int[] arr) {
        int len = arr.length;
        int pre, cur;
        for (int i = 1; i < len; i++) {
            cur = arr[i];
            pre = i - 1;
            while (pre >= 0 && arr[pre] > cur) {
                arr[pre + 1] = arr[pre--];
            }
            arr[pre + 1] = cur;
        }
    }

    public static void main(String[] args) {
        int[] nums = {2, 5, 7, 3, 9, 3};
        InsertionSortTwo i = new InsertionSortTwo();
        i.sort(nums);
        System.out.println(Arrays.toString(nums));
    }
}
