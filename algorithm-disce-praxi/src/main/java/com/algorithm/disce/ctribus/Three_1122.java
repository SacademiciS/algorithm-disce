package com.algorithm.disce.ctribus;

import java.util.HashMap;
import java.util.Map;

public class Three_1122 {

    Map<Integer, Integer> record;

    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        record = new HashMap<>(arr2.length);
        for (int i = 0; i < arr2.length; i++) {
            record.put(arr2[i], i);
        }
        quickSort(arr1, 0, arr1.length - 1);
        return arr1;
    }

    private void quickSort(int[] arr1, int s, int e) {
        if (s >= e) return;
        int center = partition(arr1, s, e);
        quickSort(arr1, s, center - 1);
        quickSort(arr1, center + 1, e);
    }

    private int partition(int[] ints, int s, int e) {
        int temp = ints[e];
        int j = s;
        for (int i = s; i < e; i++) {
            if (less(ints[i], temp)) {
                swap(ints, i, j++);
            }
        }
        swap(ints, j, e);
        return j;
    }

    private boolean less(int num1, int num2) {
        if (record.containsKey(num1) || record.containsKey(num2)) {
            return record.getOrDefault(num1, 1000) < record.getOrDefault(num2, 1000);
        } else {
            return num1 < num2;
        }
    }

    private void swap(int[] ints, int j, int e) {
        int t = ints[e];
        ints[e] = ints[j];
        ints[j] = t;
    }

}
