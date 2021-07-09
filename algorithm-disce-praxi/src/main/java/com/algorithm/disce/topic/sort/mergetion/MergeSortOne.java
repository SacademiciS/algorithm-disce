package com.algorithm.disce.topic.sort.mergetion;

import java.util.Arrays;

//归并排序
//理解：采用分治法（Divide and Conquer）的一个非常典型的应用，将n长度数组分解为n/2长度子序列，再对两个字序列使用归并排序(即分治递归)
//最后最重要的一点，最终数组会被分为长度为1的n个子序列，再将这些子序列两两之间整合排序
//时间 O(nlogn) 空间 O(n)  稳定
public class MergeSortOne {

    public void sort(int[] arr) {
        mergeSort(arr, 0, arr.length - 1);
    }

    private void mergeSort(int[] arr, int begin, int end) {
        if (begin >= end) return;
        int mid = (begin + end) >> 1;
        mergeSort(arr, begin, mid);
        mergeSort(arr, mid + 1, end);
        merge(arr, begin, mid, end);
    }

    private void merge(int[] arr, int begin, int mid, int end) {
        int[] temp = new int[end - begin + 1];
        int i = begin, j = mid + 1, k = 0;
        while (i <= mid && j <= end) {
            temp[k++] = arr[i] < arr[j] ? arr[i++] : arr[j++];
        }

        while (i <= mid) temp[k++] = arr[i++];
        while (j <= end) temp[k++] = arr[j++];

        int len = temp.length;
        for (int p = 0; p < len; p++) {
            arr[begin + p] = temp[p];
        }

    }

    public static void main(String[] args) {
        MergeSortOne o = new MergeSortOne();
        int[] nums = {2, 5, 7, 3, 9, 3};
        o.sort(nums);
        System.out.println(Arrays.toString(nums));
    }
}
