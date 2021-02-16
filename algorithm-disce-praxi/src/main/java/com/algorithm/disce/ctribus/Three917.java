package com.algorithm.disce.ctribus;

/**
 * 方法 2：反转指针
 * 想法
 * <p>
 * 一个接一个输出 s 的所有字符。当遇到一个字母时，我们希望找到逆序遍历字符串的下一个字母。
 * <p>
 * 所以我们这么做：维护一个指针 j 从后往前遍历字符串，当需要字母时就使用它
 * <p>
 * 作者：LeetCode
 * 链接：https://leetcode-cn.com/problems/reverse-only-letters/solution/jin-jin-fan-zhuan-zi-mu-by-leetcode/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
public class Three917 {

    public String reverseOnlyLetters(String S) {
        if (S == null || S.length() == 0) return "";
        char[] chars = S.toCharArray();
        int j = chars.length - 1;
        StringBuilder str = new StringBuilder();
        for (char aChar : chars) {
            //要先判断后遍历
            if (Character.isLetter(aChar)) {
                while (!Character.isLetter(chars[j])) {
                    j--;
                }
                str.append(chars[j--]);
            } else {
                str.append(aChar);
            }
        }

//        for (char aChar : chars) {
//            //先遍历后判断会导致 j 反转可能超过 i （例如 a-!）
//            //导致 while !Character.isLetter(chars[j]) 条件里char[j]会超数组下限异常
//            while (!Character.isLetter(chars[j])) {
//                    j--;
//            }
//            if (Character.isLetter(aChar)) {
//                str.append(chars[j--]);
//            } else {
//                str.append(aChar);
//            }
//        }

        return str.toString();
    }

    public static void main(String[] args) {
        Three917 t = new Three917();
        System.out.println(t.reverseOnlyLetters("Test1ng-Leet=code-Q!"));
    }
}
