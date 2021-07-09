package com.algorithm.disce.topic.interview;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class QOne {

    public static int[] removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) return nums;

        Set<Integer> record = new HashSet<>();
        for (int n : nums) {
            record.add(n);
        }

        int[] result = new int[record.size()];
        int index = 0;
        for (Integer i : record) {
            result[index++] = i;
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{10, 10, 10, 10, 20};
        System.out.println(Arrays.toString(removeDuplicates(nums)));
    }
}
