package com.algorithm.disce.bduo;


import java.util.Stack;

public class Two917 {

    public String reverseOnlyLetters(String S) {
        if (S == null || S.length() == 0) return "";
        char[] chars = S.toCharArray();
        Stack<Character> stack = new Stack<>();
        for (char aChar : chars) {
            if (Character.isLetter(aChar)) {
                stack.push(aChar);
            }
        }

        for (int i = 0; i < chars.length; i++) {
            if (Character.isLetter(chars[i])) {
                chars[i] = stack.pop();
            }
        }
        return new String(chars);
    }

}
