package com.algorithm.disce.aunus;

public class One387 {

    public int firstUniqChar(String s) {
        int[] record = new int[26];
        for (int i = 0; i < s.length(); i++) {
            record[s.charAt(i) - 'a']++;
        }
        for (int i = 0; i < s.length(); i++) {
            if (record[s.charAt(i) - 'a'] == 1) return i;
        }

        return -1;
    }

}
