package com.algorithm.disce.topic.sort.comparison.one;

import java.util.Arrays;

//冒泡排序
//个人理解：数组要排序区间内比较相邻的元素交换，越小的元素会经由交换慢慢“浮”到数列的顶端
//时间 O(n^2) 空间 O(1)  稳定
public class BubbleSortOne {

    private void bubbleSort(int[] nums) {
        int size = nums.length;
        for (int i = 0; i < size; i++) {
            for (int j = 1; j < size - i; j++) {
                if (nums[j - 1] > nums[j]) {
                    swap(nums, j - 1, j);
                }
            }
        }
        System.out.println(Arrays.toString(nums));
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        int[] nums = {2, 5, 7, 3, 9, 3};
        BubbleSortOne o = new BubbleSortOne();
        o.bubbleSort(nums);
    }
}
