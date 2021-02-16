package com.algorithm.disce.aunus;


public class One242 {

    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;
        int len = s.length();
        int[] record = new int[26];
        for (int i = 0; i < len; i++) {
            record[s.charAt(i) - 'a']++;
        }

        for (int i = 0; i < len; i++) {
            if (record[t.charAt(i) - 'a'] == 0) return false;
            record[t.charAt(i) - 'a']--;
        }
        return true;
    }


}
