package com.algorithm.disce.aunus;

/**
 * @Author: wjh
 * @Description
 * @Date: 2021/2/9 14:23
 * Copyright (c) 2019 北京新媒传信科技有限公司
 */
public class One344 {

    public void reverseString(char[] s) {
        int n = s.length;
        for (int i = 0, j = s.length - 1; i < j; i++, j--) {
            char t = s[i];
            s[i] = s[j];
            s[j] = t;
        }
    }

}
