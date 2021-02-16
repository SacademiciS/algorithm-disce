package com.algorithm.disce.ctribus;


import java.util.HashMap;
import java.util.Map;

/**
 * 方法一：自动机
 * 思路
 *
 * 字符串处理的题目往往涉及复杂的流程以及条件情况，如果直接上手写程序，一不小心就会写出极其臃肿的代码。
 *
 * 因此，为了有条理地分析每个输入字符的处理方法，我们可以使用自动机这个概念：
 *
 * 我们的程序在每个时刻有一个状态 s，每次从序列中输入一个字符 c，并根据字符 c 转移到下一个状态 s'。这样，我们只需要建立一个覆盖所有情况的从 s 与 c 映射到 s' 的表格即可解决题目中的问题。
 */
public class Three8 {

    public int myAtoi(String s) {
        int len = s.length();
        Automaton automaton = new Automaton();
        for (int i = 0; i < len; i++) {
            automaton.get(s.charAt(i));
        }
        return (int) (automaton.sign * automaton.ans);
    }

    class Automaton {
        int sign = 1;
        long ans = 0;
        private String state = "start";
        Map<String, String[]> table = new HashMap<String, String[]>() {{
            put("start", new String[]{"start", "sign", "in_number", "end"});
            put("sign", new String[]{"end", "end", "in_number", "end"});
            put("in_number", new String[]{"end", "end", "in_number", "end"});
            put("end", new String[]{"end", "end", "end", "end"});
        }};

        public void get(char c) {
            state = table.get(state)[get_col(c)];
            if ("in_number".equals(state)) {
                ans = ans * 10 + c - '0';
                ans = sign == 1 ? Math.min(ans, (long) Integer.MAX_VALUE) : Math.min(ans, -(long) Integer.MIN_VALUE);
            } else if ("sign".equals(state)) {
                sign = c == '+' ? 1 : -1;
            }
        }

        private int get_col(char c) {
            if (c == ' ') {
                return 0;
            } else if (c == '+' || c == '-') {
                return 1;
            } else if (Character.isDigit(c)) {
                return 2;
            } else {
                return 3;
            }
        }
    }


}
