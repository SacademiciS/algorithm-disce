package com.algorithm.disce.topic.sort.Insertion.one;

import java.util.Arrays;

//插入排序
//理解：工作原理是通过构建有序序列，从第一个数认定为以排序，再往后面扩张.对于未排序数据，在已排序序列中从后向前扫描，找到相应位置并插入
//相对难以理解，例子 强迫症将军扩张领土，每攻占一个领地，把小部队撤回去防守，大部队调出去继续进军
//时间 O(n^2) 空间 O(1)  稳定
public class InsertionSortOne {

    public void sort(int[] arr) {
        int len = arr.length;
        int preIndex, current;
        for (int i = 1; i < len; i++) {
            preIndex = i - 1;
            current = arr[i];
            while (preIndex >= 0 && arr[preIndex] > current) {
                arr[preIndex + 1] = arr[preIndex];
                preIndex--;
            }
            arr[preIndex + 1] = current;
        }
    }

    public static void main(String[] args) {
        int[] nums = {2, 5, 7, 3, 9, 3};
        InsertionSortOne i = new InsertionSortOne();
        i.sort(nums);
        System.out.println(Arrays.toString(nums));
    }
}
