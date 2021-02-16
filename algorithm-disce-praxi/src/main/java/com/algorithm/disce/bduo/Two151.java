package com.algorithm.disce.bduo;

public class Two151 {
    public String reverseWords(String s) {
        s = s.trim();
        char[] chars = s.toCharArray();
        int end = chars.length - 1;
        int start = end;
        StringBuilder sb = new StringBuilder();
        while (start >= 0) {
            while (start >= 0 && chars[start] != ' ') start--;//搜索第一个空格
            sb.append(s.substring(start + 1, end + 1)).append(" ");//添加单词
            while (start >= 0 && chars[start] == ' ') start--;//填过单词中间空格
            end = start;//end指向下个单词的尾字符
        }
        return sb.toString();
    }
}
