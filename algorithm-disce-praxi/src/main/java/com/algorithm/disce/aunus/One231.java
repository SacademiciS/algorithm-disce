package com.algorithm.disce.aunus;

public class One231 {
    //若 n = 2^x
    //且 x 为自然数（即 n 为 2 的幂），则一定满足以下条件：
    //恒有 n & (n - 1) == 0，这是因为：
    //n 二进制最高位为 1，其余所有位为 0；
    //n - 1二进制最高位为 0，其余所有位为 1；
    //一定满足 n > 0。
    //因此，通过 n > 0 且 n & (n - 1) == 0 即可判定是否满足 n = 2^x

    public boolean isPowerOfTwo(int n) {
        return n > 0 && (n & (n - 1)) == 0;
    }

    public static void main(String[] args) {
        One231 o = new One231();
        System.out.println(o.isPowerOfTwo(-16));
    }
}
