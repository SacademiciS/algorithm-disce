package com.algorithm.disce.bduo;

import java.util.*;
import java.util.stream.Collectors;

public class Two_1122 {

    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        //Map记录arr2数值和下标
        Map<Integer, Integer> record = new HashMap<>(arr2.length);
        for (int i = 0; i < arr2.length; i++) {
            record.put(arr2[i], i);
        }
        //将数组arr1转成res list集合对象
        List<Integer> res = Arrays.stream(arr1).boxed().collect(Collectors.toList());

        //对res集合进行排序
        //情况1:如果值 num1 和 num2 都存在 Map 的keys中
        //取出对应下标相减进行对比
        //情况2:如果值 num1 在 Map 的keys中，而 num2 不在（反过来也是一样）
        //num1在Map中下标和1000相减进行对比，由于题目中 1 <= arr1.length, arr2.length <= 1000
        //在 Map 的 keys存在下标一定小于等于1000，所以 num1 一定会排到 num2 前面
        //情况3:值 num1 和 num2 都不在 Map 的keys中
        //直接对值 num1 和 num2 相减进行对比
        res.sort((num1, num2) -> {
            if (record.containsKey(num1) || record.containsKey(num2)) {
                return record.getOrDefault(num1, 1000) - record.getOrDefault(num2, 1000);
            } else {
                return num1 - num2;
            }
        });

        return res.stream().mapToInt(i -> i).toArray();
    }

}
