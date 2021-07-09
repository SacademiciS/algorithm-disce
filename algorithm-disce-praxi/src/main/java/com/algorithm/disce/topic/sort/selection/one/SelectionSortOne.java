package com.algorithm.disce.topic.sort.selection.one;

import java.util.Arrays;

//选择排序
//个人理解：逐渐选出数组要排序区间最小(大)的值，向后(前)推进
//时间 O(n^2) 空间 O(1)  不稳定
public class SelectionSortOne {

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
            swap(arr, i, minIndex);
        }

    }

    private void swap(int[] arr, int i, int minIndex) {
        int temp = arr[i];
        arr[i] = arr[minIndex];
        arr[minIndex] = temp;
    }

    public static void main(String[] args) {
        SelectionSortOne s = new SelectionSortOne();
        int[] nums = {2, 5, 7, 3, 9, 3};
        s.sort(nums);
        System.out.println(Arrays.toString(nums));
    }
}
