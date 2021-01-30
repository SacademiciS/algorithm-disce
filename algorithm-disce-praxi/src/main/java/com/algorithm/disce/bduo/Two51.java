package com.algorithm.disce.bduo;

import java.util.*;

public class Two51 {

    private int n;
    //记录当前列的单元格是否放置了皇后
    private Set<Integer> col;
    //记录副对角线的单元格是否放置了皇后
    private Set<Integer> main;
    //记录主对角线上的单元格是否放置了皇后
    private Set<Integer> sub;
    private List<List<String>> res;

    public List<List<String>> solveNQueens(int n) {
        if (n == 0) return res;
        this.n = n;
        col = new HashSet<>();
        main = new HashSet<>();
        sub = new HashSet<>();
        res = new ArrayList<>();
        ArrayDeque<Integer> path = new ArrayDeque<>();
        dfs(0, path);
        return res;
    }

    /**
     * 递归检测并返回所有不同的 n 皇后问题的解决方案
     * @param row 行
     * @param path ！！下标i为行，value值为列，记录放置皇后路径
     */
    private void dfs(int row, ArrayDeque<Integer> path) {

        //能到最后一行,说明有了一种n皇后的解法
        if (row == n) {
            //解析成棋盘集合,并记录
            List<String> broad = convert2Broad(path);
            res.add(broad);
        }

        for (int j = 0; j < n; j++) {
            //col记录那些列上放置了皇后
            //考虑对角线校验（找规律）
            //为了保证至少两个皇后不同时出现在 同一主对角线方向 或者 同一副对角线方向。检查策略是，只要「检测」到新摆放的「皇后」与已经摆放好的「皇后」冲突，就尝试摆放同一行的下一个位置，到行尾还不能放置皇后，就退回到上一行
            //n*n的棋盘上主队线和副对角线分别有 2*n -1 条
            //其中规律
            //主对角线：同一对角线 row - col 值相同，注意 row - col 会出现负数情况，若用boolean数组等下标不能为负数的结构记录要考虑加上 n-1 偏移量
            //副对角线：同一对角线 row + col 值相同
            if (!col.contains(j) && !main.contains(row - j) && !sub.contains(row + j)) {
                col.add(j);
                main.add(row - j);
                sub.add(row + j);
                path.addLast(j);
                dfs(row + 1, path);

                sub.remove(row + j);
                main.remove(row - j);
                col.remove(j);
                path.removeLast();
            }
        }

    }

    private List<String> convert2Broad(ArrayDeque<Integer> path) {
        List<String> broad = new ArrayList<>();
        char[] c = new char[n];
        Arrays.fill(c, '.');
        for (int num : path) {
            char[] temp = c.clone();
            temp[num] = 'Q';
            broad.add(new String(temp));
        }
        return broad;
    }
}
