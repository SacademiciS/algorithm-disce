package com.algorithm.disce.aunus;

/**
 * @Author: wjh
 * @Description
 * @Date: 2021/1/26 11:14
 * Copyright (c) 2019 北京新媒传信科技有限公司
 */
public class One_1 {

    public int[] twoSum(int[] nums, int target) {
        int[] res = null;
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i; j < nums.length; j++) {
                if (i != j && nums[i] + nums[j] == target) {
                    res = new int[]{i, j};
                }
            }
        }
        return res;
    }
}
