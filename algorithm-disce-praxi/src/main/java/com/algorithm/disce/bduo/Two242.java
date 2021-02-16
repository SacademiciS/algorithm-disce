package com.algorithm.disce.bduo;

public class Two242 {

    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;
        int[] record = new int[26];
        int len = s.length();
        char[] sc = s.toCharArray();
        char[] tc = t.toCharArray();
        for (int i = 0; i < len; i++) {
            record[sc[i] - 'a']++;
            record[tc[i] - 'a']--;
        }

        for (int i = 0; i < 26; i++) {
            if (record[i] != 0) return false;
        }
        return true;
    }

}
