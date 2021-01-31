package com.algorithm.disce.sort.comparison;

import java.util.Arrays;

public class QuickSortOne {

    public void quickSort(int[] nums) {
        quickSort(nums, 0, nums.length - 1);
        System.out.println(Arrays.toString(nums));
    }

    private void quickSort(int[] nums, int begin, int end) {
        if (begin >= end) return;
        int pivot = partition(nums, begin, end);
        quickSort(nums, begin, pivot - 1);
        quickSort(nums, pivot + 1, end);
    }

    private int partition(int[] nums, int begin, int end) {
        int pivot = begin;
        int temp = nums[end];
        for (int i = begin; i < end; i++) {
            if (nums[i] < temp) {
                swap(nums, i, pivot++);
            }
        }
        swap(nums, pivot, end);
        return pivot;
    }

    private void swap(int[] nums, int index1, int index2) {
        int t = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = t;
    }

    public static void main(String[] args) {
        int[] nums = {2, 5, 7, 3, 9, 3};
        QuickSortOne q = new QuickSortOne();
        q.quickSort(nums);
    }

}
