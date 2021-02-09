package com.algorithm.disce.aunus;

import java.util.*;

/**
 * @Author: wjh
 * @Description
 * @Date: 2021/2/9 11:21
 * Copyright (c) 2019 北京新媒传信科技有限公司
 */
public class One14 {

    public String longestCommonPrefix(String[] strs) {
        int n = strs.length;
        if (n == 0) return "";
        int min = Integer.MAX_VALUE;
        Map<Integer, Set<Character>> record = new HashMap<>();
        for (int i = 0; i < n; i++) {
            char[] str = strs[i].toCharArray();
            if (min > str.length) {
                min = str.length;
            }
            for (int j = 0; j < str.length; j++) {
                Set<Character> set = record.getOrDefault(j, new HashSet<>());
                set.add(str[j]);
                record.put(j, set);
            }
        }
        List<Character> list = new ArrayList<>();
        for (int i = 0; i < min; i++) {
            if (record.get(i).size() != 1) {
                break;
            }
            list.addAll(record.get(i));
        }
        char[] res = new char[list.size()];
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }
        return new String(res);
    }

    public static void main(String[] args) {
        String[] strs = new String[]{"cir", "car"};
        One14 o = new One14();
        System.out.println(o.longestCommonPrefix(strs));
    }

}
