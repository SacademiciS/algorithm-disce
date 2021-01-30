package com.algorithm.disce.aunus;

public class One547 {

    class UnionFind {
        private int[] parent;
        private int[] size;
        private int count;

        public UnionFind(int n) {
            this.count = n;
            parent = new int[n];
            size = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
                size[i] = 1;
            }
        }

        public int get(int p) {
            while (p != parent[p]) {
                parent[p] = parent[parent[p]];
                p = parent[p];
            }
            return p;
        }

        public void union(int p, int q) {
            int rootP = get(p);
            int rootQ = get(q);
            if (rootP == rootQ) return;
            if (size[rootP] > size[rootQ]) {
                parent[rootQ] = rootP;
                size[rootP] += size[rootQ];
            } else {
                parent[rootP] = rootQ;
                size[rootQ] += size[rootP];
            }
            count--;
        }

        public int getCount() {
            return count;
        }
    }

    public int findCircleNum(int[][] M) {
        int n = M.length;
        if (n == 0) return 0;
        UnionFind u = new UnionFind(n);
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                //大哥，注意审题！！！
                if (M[i][j] == 1) {
                    u.union(i, j);
                }
            }
        }
        return u.getCount();
    }

}
