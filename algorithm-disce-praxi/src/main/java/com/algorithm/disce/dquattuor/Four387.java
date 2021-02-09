package com.algorithm.disce.dquattuor;


import java.util.HashMap;
import java.util.Map;

public class Four387 {

    public int firstUniqChar(String s) {
        int n = s.length();
        Map<Character, Integer> record = new HashMap<>();
        char[] chars = s.toCharArray();
        for (int i = 0; i < n; i++) {
            if (record.containsKey(chars[i])) {
                record.put(chars[i], -1);
            } else {
                record.put(chars[i], i);
            }
        }

        int index = n;
        for (Map.Entry<Character, Integer> entry : record.entrySet()) {
            int value = entry.getValue();
            if (value != -1 && index > value) {
                index = value;
            }
        }
        return index == n ? -1 : index;
    }

}
