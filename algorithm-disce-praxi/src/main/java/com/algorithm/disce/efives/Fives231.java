package com.algorithm.disce.efives;

/**
 * @Author: wjh
 * @Description
 * @Date: 2021/1/27 11:56
 * Copyright (c) 2019 北京新媒传信科技有限公司
 */
public class Fives231 {

    public boolean isPowerOfTwo(int n) {
        return n > 0 && (n & (n - 1)) == 0;
    }
}
