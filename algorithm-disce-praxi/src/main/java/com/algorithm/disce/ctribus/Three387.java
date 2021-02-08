package com.algorithm.disce.ctribus;

public class Three387 {

    public int firstUniqChar(String s) {
        int n = s.length();
        if (n <= 26) {
            int[] record = new int[26];
            for (int i = 0; i < n; i++) {
                record[s.charAt(i) - 'a']++;
            }
            for (int i = 0; i < n; i++) {
                if (record[s.charAt(i) - 'a'] == 1) return i;
            }
            return -1;
        }

        int index = -1;
        for (char c = 'a'; c <= 'z'; c++) {
            int pre = s.indexOf(c);
            if (pre != -1 && pre == s.lastIndexOf(c)) {
                index = (index == -1 || index > pre) ? pre : index;
            }
        }
        return index;
    }

}
