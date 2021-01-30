package com.algorithm.disce.aunus;

public class One1122 {

    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        int upper = 0;
        for (int i = 0; i < arr1.length; i++) {
            if (upper < arr1[i]) upper = arr1[i];
        }

        int[] container = new int[upper + 1];

        for (int i = 0; i < arr1.length; i++) {
            container[arr1[i]]++;
        }
        int[] res = new int[arr1.length];
        int index = 0;
        for (int i = 0; i < arr2.length; i++) {
            while (container[arr2[i]] > 0) {
                res[index++] = arr2[i];
                container[arr2[i]]--;
            }
        }

        for (int i = 0; i < container.length; i++) {
            while (container[i] > 0) {
                res[index++] = i;
                container[i]--;
            }
        }

        return res;
    }

}
