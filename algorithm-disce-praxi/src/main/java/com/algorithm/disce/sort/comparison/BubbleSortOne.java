package com.algorithm.disce.sort.comparison;

import java.util.Arrays;

//冒泡排序
public class BubbleSortOne {

    private void bubbleSort(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = 1; j < nums.length - i; j++) {
                if (nums[j - 1] > nums[j]) {
                    int t = nums[j - 1];
                    nums[j - 1] = nums[j];
                    nums[j] = t;
                }
            }
        }
        System.out.println(Arrays.toString(nums));
    }

    public static void main(String[] args) {
        int[] nums = {2, 5, 7, 3, 9, 3};
        BubbleSortOne o = new BubbleSortOne();
        o.bubbleSort(nums);
    }

}
