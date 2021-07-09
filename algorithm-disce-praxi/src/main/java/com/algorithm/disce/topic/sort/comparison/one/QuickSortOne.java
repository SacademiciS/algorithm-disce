package com.algorithm.disce.topic.sort.comparison.one;

import java.util.Arrays;

//快速排序
//从数列中挑出一个元素（基准pivot），交换pivot前后元素，使前边小后面大
//然后通过分治法递归下去
//时间 O(nlogn) 空间 O(nlogn)  不稳定
public class QuickSortOne {

    public void quickSort(int[] nums) {
        quickSort(nums, 0, nums.length - 1);
        System.out.println(Arrays.toString(nums));
    }

    private void quickSort(int[] nums, int begin, int end) {
        if (begin >= end) return;
        int privet = partition(nums, begin, end);
        quickSort(nums, 0, privet - 1);
        quickSort(nums, privet + 1, end);
    }

    private int partition(int[] nums, int begin, int end) {
        int privet = begin;
        int temp = nums[end];
        for (int i = begin; i <= end; i++) {
            //privet指针下一位可能存在交换位置
            if (nums[i] < temp) {
                swap(nums, i, privet++);
            }
        }
        swap(nums, privet, end);
        return privet;
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        int[] nums = {2, 5, 7, 3, 9, 3};
        QuickSortOne q = new QuickSortOne();
        q.quickSort(nums);
    }
}
