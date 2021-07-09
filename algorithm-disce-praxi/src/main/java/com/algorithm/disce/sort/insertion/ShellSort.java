package com.algorithm.disce.sort.insertion;

import java.util.Arrays;

/**
 * 希尔排序
 *
 * 先将整个待排序的记录序列分割成为若干子序列分别进行直接插入排序，具体算法描述：
 * 选择一个增量序列t1，t2，…，tk，其中ti>tj，tk=1；
 * 按增量序列个数k，对序列进行k 趟排序；
 * 每趟排序，根据对应的增量ti，将待排序列分割成若干长度为m 的子序列，分别对各子表进行直接插入排序。仅增量因子为1 时，整个序列作为一个表来处理，表长度即为整个序列的长度
 * 平均时间复杂度：O(n^1.3) 最好：O(n) 最坏：O(n^2)
 * 空间复杂度：O(1)
 * 稳定性：不稳定
 */
public class ShellSort {

    public void sort(int[] nums) {
        int len = nums.length;
        for (int gap = len / 2; gap > 0; gap = gap / 2) {
            for (int i = gap; i < len; i++) {
                int j = i;
                int current = nums[i];
                while (j - gap >= 0 && current < nums[j - gap]) {
                    nums[j] = nums[j - gap];
                    j = j - gap;
                }
                nums[j] = current;
            }
        }

        System.out.println(Arrays.toString(nums));
    }

    public static void main(String[] args) {
        ShellSort sort = new ShellSort();
        int[] nums = {2, 5, 7, 3, 9, 3};
        sort.sort(nums);
    }
}
