package com.algorithm.disce.topic.sort.selection.two;

import java.util.Arrays;

public class SelectionSortTwo {

    public void sort(int[] arr) {
        int len = arr.length;
        for (int i = 0; i < len - 1; i++) {
            int minIndex = i;
            //j不能等于i
            for (int j = i + 1; j < len; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            int temp = arr[minIndex];
            arr[minIndex] = arr[i];
            arr[i] = temp;
        }
    }

    public static void main(String[] args) {
        SelectionSortTwo s = new SelectionSortTwo();
        int[] nums = {2, 5, 7, 3, 9, 3};
        s.sort(nums);
        System.out.println(Arrays.toString(nums));
    }
}
