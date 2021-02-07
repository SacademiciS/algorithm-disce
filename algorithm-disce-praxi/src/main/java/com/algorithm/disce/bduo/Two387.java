package com.algorithm.disce.bduo;

public class Two387 {

    public int firstUniqChar(String s) {
        int n = s.length();
        if (n <= 26) {
            int[] record = new int[26];
            for (int i = 0; i < s.length(); i++) {
                record[s.charAt(i) - 'a']++;
            }
            for (int i = 0; i < s.length(); i++) {
                if (record[s.charAt(i) - 'a'] == 1) return i;
            }
            return -1;
        }

        int index = -1;
        for (char c = 'a'; c <= 'z'; c++) {
            int start = s.indexOf(c);
            if (start != -1 && start == s.lastIndexOf(c)) {
                index = (index == -1 || index > start) ? start : index;
            }
        }
        return index;
    }

}
