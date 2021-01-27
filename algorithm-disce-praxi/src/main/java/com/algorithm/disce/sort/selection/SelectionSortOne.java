package com.algorithm.disce.sort.selection;

import java.util.Arrays;

//简单选择排序
public class SelectionSortOne {

    private void sort(int[] nums) {
        int len = nums.length;

        for (int i = 0; i < len - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < len; j++) {
                if (nums[j] < nums[minIndex]) {
                    minIndex = j;
                }
            }
            int temp = nums[i];
            nums[i] = nums[minIndex];
            nums[minIndex] = temp;
        }

        System.out.println(Arrays.toString(nums));
    }

    public static void main(String[] args) {
        SelectionSortOne s = new SelectionSortOne();
        int[] nums = {2, 5, 7, 3, 9, 3};
        s.sort(nums);
    }

}
