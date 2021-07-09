package com.algorithm.disce.topic.interview;

import java.util.HashMap;
import java.util.Map;

public class QTwo {

    public static String statisticalData(int[] arr) {
        Map<Integer, Integer> record = new HashMap<>();
        for (int i : arr) {
            record.put(i, record.getOrDefault(i, 0) + 1);
        }

        String mod = "%s出现了%s次，";
        StringBuilder res = new StringBuilder("在该数组中，");
        for (Map.Entry<Integer, Integer> entry : record.entrySet()) {
            res.append(String.format(mod, entry.getKey(), entry.getValue()));
        }
        res.deleteCharAt(res.length() - 1);
        return res.toString();
    }

    public static void main(String[] args) {
        int[] arr = new int[]{9, 7, 7, 9, 9, 3};
        System.out.println(statisticalData(arr));
    }

}
