package com.algorithm.disce.ctribus;

import java.util.ArrayList;
import java.util.List;

public class Three438 {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<>();
        if (s.length() == 0 || s.length() < p.length()) return res;
        char[] chars_S = s.toCharArray();
        char[] chars_p = p.toCharArray();

        int[] needed = new int[26];
        int[] window = new int[26];

        int left = 0;
        int right = 0;
        int len = s.length();

        for (char c : chars_p) {
            needed[c - 'a']++;
        }

        while (right < len) {
            char chr = chars_S[right];
            // 将右窗口当前访问到的元素 curR 个数加 1
            window[chr - 'a']++;
            right++;

            // 当 window 数组中 curR 比 needs 数组中对应元素的个数要多的时候就该移动左窗口指针
            while (window[chr - 'a'] > needed[chr - 'a']) {
                char chl = chars_S[left];
                window[chl - 'a']--;
                left++;
            }

            //原本想法误区：想在左指针字符超needed数组标准后移动
            //问题：初始字符一直不增加，左指针会一直在0下标不动
//            char chl = chars_S[left];
//            if (needed[chl - 'a'] > 0) {
//                while (window[chl - 'a'] > needed[chl - 'a']) {
//                    window[chars_p[left] - 'a']--;
//                    left++;
//                }
//            } else {
//                left++;
//            }

            if (right - left == p.length()) {
                res.add(left);
            }
        }

        return res;
    }

    public static void main(String[] args) {
        Three438 t = new Three438();
        t.findAnagrams("cbaebabacd", "abc");
    }
}
