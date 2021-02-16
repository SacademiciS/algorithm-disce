package com.algorithm.disce.bduo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Two49 {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> record = new HashMap<>();
        for (String str : strs) {
            int[] t = new int[26];
            StringBuilder sb = new StringBuilder();
            int len = str.length();
            for (int j = 0; j < len; j++) {
                t[str.charAt(j) - 'a']++;
            }

            // 将每个出现次数大于 0 的字母和出现次数按顺序拼接成字符串，作为哈希表的键
            for (int k = 0; k < 26; k++) {
                if (t[k] != 0) {
                    sb.append((char) ('a' + k));
                    sb.append(t[k]);
                }
            }
            String key = sb.toString();
            List<String> list = record.getOrDefault(key, new ArrayList<String>());
            list.add(str);
            record.put(key, list);
        }
        return new ArrayList<List<String>>(record.values());
    }
}
