package com.algorithm.disce.efives;

/**
 * @Author: wjh
 * @Description
 * @Date: 2021/1/27 11:53
 * Copyright (c) 2019 北京新媒传信科技有限公司
 */
public class Fives191 {

    public int hammingWeight(int n) {
        int count = 0;
        while (n != 0) {
            n &= (n - 1);
            count++;
        }
        return count;
    }

}
