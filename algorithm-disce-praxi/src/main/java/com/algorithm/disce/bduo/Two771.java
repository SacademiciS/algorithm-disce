package com.algorithm.disce.bduo;

public class Two771 {

    public int numJewelsInStones(String jewels, String stones) {
        boolean[] record = new boolean[58];
        char[] jChars = jewels.toCharArray();
        for (int i = 0; i < jChars.length; i++) {
            record[jChars[i] - 'A'] = true;
        }

        int count = 0;
        char[] chars = stones.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (record[chars[i] - 'A']) {
                count++;
            }
        }
        return count;
    }

}
