package com.algorithm.disce.sort.insertion;

import java.util.Arrays;

//简单插入排序
public class InsertionSortOne {

    private void sort(int[] nums) {
        int len = nums.length;

        for (int i = 1; i < len; i++) {
            int preIndex = i - 1;
            int cur = nums[i];
            while (preIndex >= 0 && nums[preIndex] > cur) {
                nums[preIndex + 1] = nums[preIndex];
                preIndex--;
            }
            nums[preIndex + 1] = cur;
        }
        System.out.println(Arrays.toString(nums));
    }

    public static void main(String[] args) {
        int[] nums = {2, 5, 7, 3, 9, 3};
        InsertionSortOne i = new InsertionSortOne();
        i.sort(nums);
    }

}
