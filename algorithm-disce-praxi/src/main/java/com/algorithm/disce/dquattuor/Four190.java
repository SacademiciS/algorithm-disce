package com.algorithm.disce.dquattuor;

public class Four190 {

    public int reverseBits(int n) {
        int res = 0;
        for (int i = 0; i < 32; i++) {
            //(n & (1 << i)) 判断第i位是否为 1
            //若为 1,颠倒的处理是 ^= (1<<(31-i))
            //这里用 ^ 异或 和 & 还有 | 都可以, 运算结果都是一样的
            res ^= (n & (1 << i)) != 0 ? (1 << (31 - i)) : 0;
        }
        return res;
    }

}
