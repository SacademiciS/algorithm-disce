package com.algorithm.disce.aunus;

import java.util.LinkedList;
import java.util.List;

public class One22 {

    public List<String> generateParenthesis(int n) {
        //子问题 使用 n个"()" 能组成最多括号组合
        //状态数组 dp[n]
        //状态定义 使用 n个"()"组成最多括号组合
        //dp方程 dp[n]

        LinkedList<LinkedList<String>> result = new LinkedList<LinkedList<String>>();
        if (n == 0) {
            return result.get(0);
        }

        LinkedList<String> list0 = new LinkedList<>();
        list0.add("");
        result.add(list0);
        LinkedList<String> list1 = new LinkedList<>();
        list1.add("()");
        result.add(list1);

        for (int i = 2; i <= n; i++) {
            LinkedList<String> temp = new LinkedList<>();
            for (int j = 0; j < i; j++) {
                List<String> str1 = result.get(j);
                List<String> str2 = result.get(i - 1 - j);
                for (String s1 : str1) {
                    for (String s2 : str2) {
                        String el = "(" + s1 + ")" + s2;
                        temp.add(el);
                    }
                }
            }
            result.add(temp);
        }
        System.out.println(result.toString());
        return result.get(n);
    }

    public static void main(String[] args) {
        One22 o = new One22();
        o.generateParenthesis(3);
    }

}
