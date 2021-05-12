package com.algorithm.disce.bduo;

import java.util.ArrayList;
import java.util.List;

public class Two22 {
    public List<String> generateParenthesis(int n) {
        if (n == 0) return new ArrayList<>();
        List<String> res = new ArrayList<>();
        generate(0, 0, n, "", res);
        return res;
    }

    private void generate(int left, int right, int n, String s, List<String> res) {
        if (left == n && right == n) {
            res.add(s);
        }

        if (left < n) {
            generate(left + 1, right, n, s + "(", res);
        }

        if (right < left) {
            generate(left, right + 1, n, s + ")", res);
        }
    }
}
