package com.algorithm.disce.aunus;

public class One338 {

    public int[] countBits(int num) {
        int[] res = new int[num + 1];
        for (int i = 0; i <= num; i++) {
            res[i] = popCount(i);
        }
        return res;
    }

    private int popCount(int n) {
        int count;
        for (count = 0; n != 0; count++)
            n &= (n - 1);
        return count;
    }

}
