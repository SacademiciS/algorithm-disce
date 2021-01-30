package com.algorithm.disce.ctribus;

public class Three191 {

    public int hammingWeight(int n) {
        int count = 0;
        int mark = 1;
        for (int i = 0; i < 32; i++) {
            if ((n & mark) == 1) {
                count++;
            }
            mark <<= 1;
        }
        return count;
    }

    public static void main(String[] args) {
        Three191 t = new Three191();
        t.hammingWeight(11);
    }

}
