package com.algorithm.disce.bduo;

/**
 * 中心扩展法
 * 暴力法采用双指针两边夹，验证是否是回文子串。
 * 除了枚举字符串的左右边界以外，比较容易想到的是枚举可能出现的回文子串的“中心位置”，从“中心位置”尝试尽可能扩散出去，得到一个回文串。
 *
 * 因此中心扩散法的思路是：遍历每一个索引，以这个索引为中心，利用“回文串”中心对称的特点，往两边扩散，看最多能扩散多远。
 *
 * 枚举“中心位置”时间复杂度为 O(N)，从“中心位置”扩散得到“回文子串”的时间复杂度为 O(N)，因此时间复杂度可以降到 O(N^2)
 *
 * 在这里要注意一个细节：回文串在长度为奇数和偶数的时候，“回文中心”的形式是不一样的。
 * 奇数回文串的“中心”是一个具体的字符，例如：回文串 "aba" 的中心是字符 "b"；
 * 偶数回文串的“中心”是位于中间的两个字符的“空隙”，例如：回文串串 "abba" 的中心是两个 "b" 中间的那个“空隙”。
 */
public class Two5 {
    public String longestPalindrome(String s) {
        int len = s.length();
        String res = s.substring(0, 1);
        int maxLength = 1;
        for (int i = 0; i < len - 1; i++) {
            String oddEx = isReversePalindrome(s, i, i);
            String evenEx = isReversePalindrome(s, i, i + 1);
            String str = oddEx.length() > evenEx.length() ? oddEx : evenEx;

            if (str.length() > maxLength) {
                maxLength = str.length();
                res = str;
            }
        }
        return res;
    }

    private String isReversePalindrome(String s, int left, int right) {
        int len = s.length();
        int l = left;
        int r = right;
        while (l >= 0 && r < len) {
            if (s.charAt(l) == s.charAt(r)) {
                l--;
                r++;
            } else {
                break;
            }
        }
        return s.substring(l + 1, r);
    }
}
