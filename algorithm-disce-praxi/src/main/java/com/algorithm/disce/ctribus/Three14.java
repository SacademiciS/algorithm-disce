package com.algorithm.disce.ctribus;

/**
 * 方法二：纵向扫描
 * 方法一是横向扫描，依次遍历每个字符串，更新最长公共前缀。另一种方法是纵向扫描。纵向扫描时，从前往后遍历所有字符串的每一列，比较相同列上的字符是否相同，如果相同则继续对下一列进行比较，如果不相同则当前列不再属于公共前缀，当前列之前的部分为最长公共前缀
 *
 * 作者：LeetCode-Solution
 * 链接：https://leetcode-cn.com/problems/longest-common-prefix/solution/zui-chang-gong-gong-qian-zhui-by-leetcode-solution/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
public class Three14 {

    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) return "";

        int count = strs.length;
        int len = strs[0].length();

        for (int i = 0; i < len; i++) {
            char c = strs[0].charAt(0);
            for (int j = 1; j < count; j++) {
                if (i == strs[j].length() || strs[j].charAt(i) != strs[0].charAt(i)) {
                    return strs[0].substring(0, i);
                }
            }
        }
        return strs[0];
    }
}
