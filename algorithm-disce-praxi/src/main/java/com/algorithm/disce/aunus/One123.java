package com.algorithm.disce.aunus;

import java.util.HashMap;
import java.util.Map;

public class One123 {

    //使用递归
    public int maxProfit(int[] prices) {
        int n = prices.length;
        if (n == 0) return 0;
        //可以是map来进行记忆化,对已经计算结果进行缓存
        Map<Key, Integer> map = new HashMap<>();
        return dfs(prices, 0, 0, 0, map);
    }

    //子问题：求在i节点最多交易2次后最大利润
    //stats: 0.可以买入股票 1.可以卖出股票
    //k:已经交易次数
    private int dfs(int[] prices, int index, int status, int k, Map<Key, Integer> map) {

//        Key key = new Key(index, status, k);
//        if (map.containsKey(key)) {
//            return map.get(key);
//        }
        //终止条件
        if (index == prices.length || k == 2)
            return 0;

        //执行逻辑
        //进入下层
        //定义三个变量，分别记录[不动]、[买]、[卖]
        int a = 0, b = 0, c = 0;
        //不动
        a = dfs(prices, index + 1, status, k, map);
        if (status == 1) {
            //递归处理卖的情况，这里需要将k+1，表示执行了一次交易
            b = dfs(prices, index + 1, 0, k + 1, map) + prices[index];
        } else {
            //递归处理买的情况
            c = dfs(prices, index + 1, 1, k, map) - prices[index];
        }

        return Math.max(Math.max(a, b), c);
//        map.put(key, Math.max(Math.max(a, b), c));
//        return map.get(key);
        //状态重置
    }

    //Key对象封装了index、status、交易次数，作为map的key
    class Key {
        final int index;
        final int status;
        final int k;

        Key(int index, int status, int k) {
            this.index = index;
            this.status = status;
            this.k = k;
        }

        //这里需要实现自定义的equals和hashCode函数
        public int hashCode() {
            return this.index + this.status + this.k;
        }

        public boolean equals(Object obj) {
            Key other = (Key) obj;
            if (index == other.index && status == other.status && k == other.k) {
                return true;
            }
            return false;
        }
    }

    public static void main(String[] args) {
        One123 o = new One123();
        int[] p = {3, 3, 5, 0, 0, 3, 1, 4};
        System.out.println(o.maxProfit(p));
    }

}
