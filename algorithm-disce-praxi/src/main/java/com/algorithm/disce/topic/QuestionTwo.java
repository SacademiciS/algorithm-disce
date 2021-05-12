package com.algorithm.disce.topic;

import java.util.HashMap;
import java.util.Map;

public class QuestionTwo {

    public String count(int[] a) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < a.length; i++) {
            map.put(a[i], map.getOrDefault(a[i], 0) + 1);
        }
        String mod = "%s出现了%s次，";
        StringBuilder res = new StringBuilder("在该数组中，");
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            res.append(String.format(mod, entry.getKey(), entry.getValue()));
        }
        res.deleteCharAt(res.length());
        return res.toString();
    }
}
