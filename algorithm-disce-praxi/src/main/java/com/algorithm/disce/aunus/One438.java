package com.algorithm.disce.aunus;

import java.util.ArrayList;
import java.util.List;

/**
 * 暴力解法
 */
public class One438 {
    public List<Integer> findAnagrams(String s, String p) {
        int len = p.length();
        List<Integer> res = new ArrayList<>();
        if (s == null || s.length() < len) return res;
        String standard = convert2Str(p);
        for (int i = 0; i <= s.length() - len; i++) {
            if (standard.equals(convert2Str(s.substring(i, i + len)))) {
                res.add(i);
            }
        }
        return res;
    }

    private String convert2Str(String p) {
        StringBuilder sb = new StringBuilder();
        int[] record = new int[26];
        for (char c : p.toCharArray()) {
            record[c - 'a']++;
        }

        for (int i = 0; i < 26; i++) {
            if (record[i] != 0) {
                sb.append((char) ('a' + i));
                sb.append(record[i]);
            }
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        One438 o = new One438();
        System.out.println(o.findAnagrams("abab", "ab").toString());
    }
}
