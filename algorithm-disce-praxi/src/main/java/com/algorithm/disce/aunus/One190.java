package com.algorithm.disce.aunus;

public class One190 {

    public int reverseBits(int n) {
        int r = 0;
        for (int i = 0; i < 32; i++) {
            if ((n & 1) == 1) {
                r = r | (1 << (32 - i - 1));
            }
            n >>= 1;
        }
        return r;
    }

    public static void main(String[] args) {
        One190 o = new One190();
        System.out.println(o.reverseBits(1));
    }
}
