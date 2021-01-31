package com.algorithm.disce.sort.mergetion;

import java.util.Arrays;

public class MergeSortOne {

    public void sort(int[] nums) {
        mergeSort(nums, 0, nums.length - 1);
        System.out.println(Arrays.toString(nums));
    }

    private void mergeSort(int[] nums, int begin, int end) {
        if (end <= begin) return;
        int mid = (begin + end) >> 1;

        mergeSort(nums, begin, mid);
        mergeSort(nums, mid + 1, end);
        merge(nums, begin, mid, end);
    }

    private void merge(int[] nums, int begin, int mid, int end) {

        int[] temp = new int[end - begin + 1];
        int i = begin, j = mid + 1, k = 0;

        while (i <= mid && j <= end) {
            temp[k++] = nums[i] < nums[j] ? nums[i++] : nums[j++];
        }

        while (i <= mid) temp[k++] = nums[i++];
        while (j <= end) temp[k++] = nums[j++];

        for (int p = 0; p < temp.length; p++) {
            nums[begin + p] = temp[p];
        }
    }

    public static void main(String[] args) {
        MergeSortOne o = new MergeSortOne();
        int[] nums = {2, 5, 7, 3, 9, 3};
        o.sort(nums);
    }
}
