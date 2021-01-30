package com.algorithm.disce.ctribus;

public class Three231 {

    public boolean isPowerOfTwo(int n) {

        //位运算中 x & (x-1) 是去除x二进制形式最后一位1
        return n > 0 && (n & (n - 1)) == 0;
    }

}
