package com.algorithm.disce.topic.sort.comparison.two;

public class QuickSortTwo {

    public void sort(int[] arr) {
        quickSort(arr, 0, arr.length);
    }

    private void quickSort(int[] arr, int begin, int end) {
        if (begin >= end) return;
        int pivot = partition(arr, begin, end);
        quickSort(arr, begin, pivot - 1);
        quickSort(arr, pivot + 1, end);
    }

    private int partition(int[] arr, int begin, int end) {
        int pivot = begin;
        int temp = arr[end];
        for (int i = begin; i <= end; i++) {
            if (arr[i] < temp) {
                //记住：这里有pivot 和i 的双指针
                //交换规则 pivot = i 时，小的值不动；遇到大的值pivot不动，i指针超过pivot
                //pivot != i 时,小的值和pivot指针位置交换，pivot指针向后移动；遇到大的值pivot不动，i指针一直持续向后移动
                //pivot指针下一位可能存在交换位置
                swap(arr, i, pivot++);
            }
        }
        swap(arr, pivot, end);
        return pivot;
    }

    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
