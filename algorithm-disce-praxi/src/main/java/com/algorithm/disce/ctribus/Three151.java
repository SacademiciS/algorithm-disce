package com.algorithm.disce.ctribus;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Three151 {
    public String reverseWords(String s) {
        s = s.trim();
        List<String> list = Arrays.asList(s.split("\\s+"));
        Collections.reverse(list);
        return String.join(" ", list);
    }

    public static void main(String[] args) {
        Three151 t = new Three151();
        System.out.println(t.reverseWords("the sky is blue"));
    }
}
