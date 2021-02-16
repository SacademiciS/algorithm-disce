package com.algorithm.disce.aunus;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class One49 {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res = new ArrayList<>();
        if (strs.length == 0) return res;
        HashMap<String, Integer> record = new HashMap<>();
        int r = 0;
        for (String str : strs) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String temp = new String(chars);
            if (record.containsKey(temp)) {
                res.get(record.get(temp)).add(str);
            } else {
                res.add(new ArrayList<>());
                res.get(r).add(str);
                record.put(temp, r++);
            }
        }
        return res;
    }
}
