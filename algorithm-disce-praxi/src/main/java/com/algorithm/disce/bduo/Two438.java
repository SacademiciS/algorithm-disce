package com.algorithm.disce.bduo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 滑动窗口
 */
public class Two438 {
    public List<Integer> findAnagrams(String s, String p) {
        if (s.length() < p.length()) return Collections.emptyList();
        List<Integer> res = new ArrayList<>();
        //由于都是小写字母，因此直接用26个长度的数组代替原来的HashMap
        int[] need = new int[26];
        int[] window = new int[26];
        int left = 0;
        int right = left;
        //用total检测窗口中是否已经涵盖了p中的字符
        int total = p.length();
        //记录需要对比字符串转化为int数组
        for (char c : p.toCharArray()) {
            need[c - 'a']++;
        }
        int len = s.length();

        while (right < len) {
            //判断右指针字符是否满足对比数组条件
            char chr = s.charAt(right);
            if (need[chr - 'a'] > 0) {
                //滑动窗口记录状态
                window[chr - 'a']++;
                if (window[chr - 'a'] <= need[chr - 'a']) {
                    //！！chr满足p字符条件,total记录个数变更
                    total--;
                }
            }

            //当total记录个数为0,说明从left到right中的字符至少包含了p中所有字符的条件
            while (total == 0) {
                if (right - left + 1 == p.length()) {
                    //刚刚好满足条件，直接记录左指针
                    res.add(left);
                }

                //准备向右滑动窗口
                char chl = s.charAt(left);
                if (need[chl - 'a'] > 0) {
                    //左指针字符记录去除（因为要向右滑动，要去掉多余左指针字符）
                    window[chl - 'a']--;
                    //！！判断chl字符是否溢出，若total记录多余溢出字符个数会超过p字符串的上限
                    if (window[chl - 'a'] < need[chl - 'a']) {
                        //chl字符（未溢出）去除,total记录个数变更
                        total++;
                    }
                }
                //左指针向左移,滑动窗口
                left++;
            }
            //右指针向右移
            right++;
        }

        return res;
    }
}
