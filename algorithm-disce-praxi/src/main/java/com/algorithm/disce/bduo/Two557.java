package com.algorithm.disce.bduo;

public class Two557 {
    public String reverseWords(String s) {
        char[] chars = s.toCharArray();
        int len = chars.length;
        int index = len - 1;
        int right = index;
        while (index >= 0) {
            while (index >= 0 && chars[index] != ' ') index--;
            int left = index + 1;
            while (left < right) {
                char t = chars[left];
                chars[left] = chars[right];
                chars[right] = t;
                left++;
                right--;
            }
            while (index >= 0 && chars[index] == ' ') index--;
            right = index;
        }
        return new String(chars);
    }

    public static void main(String[] args) {
        Two557 t = new Two557();
        t.reverseWords("Let's take LeetCode contest");
    }
}
