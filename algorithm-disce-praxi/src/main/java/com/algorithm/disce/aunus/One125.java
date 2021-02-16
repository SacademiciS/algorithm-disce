package com.algorithm.disce.aunus;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class One125 {
    public boolean isPalindrome(String s) {
        if (s == null || s.length() == 0) return true;
        char[] chars = s.toCharArray();
        Stack<Character> stack = new Stack<>();
        Queue<Character> queue = new LinkedList<>();
        for (char aChar : chars) {
            if (Character.isDigit(aChar) || Character.isLetter(aChar)) {
                stack.push(aChar);
                queue.offer(aChar);
            }
        }

        while (!queue.isEmpty()) {
            Character qc = queue.poll();
            Character sc = stack.pop();
            if (Character.isDigit(qc) && Character.isDigit(sc) && qc == sc) {
                continue;
            }
            if (Character.isLetter(qc) && Character.isLetter(sc) && (qc == sc || qc - 'A' == sc - 'a' || qc - 'a' == sc - 'A')) {
                continue;
            }
            return false;
        }

        return true;
    }

    public static void main(String[] args) {
        One125 o = new One125();
        System.out.println(o.isPalindrome("0P"));
    }
}
