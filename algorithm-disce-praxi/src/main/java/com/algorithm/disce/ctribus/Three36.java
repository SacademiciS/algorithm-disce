package com.algorithm.disce.ctribus;

public class Three36 {

    public boolean isValidSudoku(char[][] board) {

        int[] row = new int[10];
        int[] col = new int[10];
        int[] box = new int[10];

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.') {
                    int boxMark = (i / 3) * 3 + j / 3;
                    int val = board[i][j] - '0';
                    row[i] = sudokuer(row[i], val);
                    col[j] = sudokuer(col[j], val);
                    box[boxMark] = sudokuer(box[boxMark], val);
                    if (row[i] == -1 || col[j] == -1 || box[boxMark] == -1) {
                        return false;
                    }
                }
            }
        }

        return true;
    }

    //位运算
    //基本知识：
    //与运算(a & b)：a,b均为1时，返回1，否则返回0
    //异或运算(a ^ b)：a,b不同时为0或1时，返回1，否则返回0
    //本题可以使用一个9位二进制数判断数字是否被访问。第k位数为1代表已加入，为0代表未加入
    //更新方式(记九位数为val，传入的数字为n)：
    //判断是否加入：将九位数右移位n位，与1进行与运算
    //结果为0：未加入，将传入的数字加入九位数
    //结果为1：已加入，返回false

    //将传入的数字加入九位数：将1左移位n位，与val异或即可
    //例子：对于数字1010010000，其第4,7,9位为11，表示当前4,7,9已经访问过了
    //新来数字为3：
    //将1010010000右移3位得到1010010，与1进行与运算，结果为0，未访问过。
    //将1左移位3位得到1000，与val值即1010010000异或后得到1010011000(把3的位置登记上)
    //新来数字为4：
    //将1010011000右移4位得到101001，与1进行与运算，结果为1，访问过。
    //返回false
    private int sudokuer(int val, int n) {
        return (val >> n & 1) == 1 ? -1 : val ^ (1 << n);
    }

}
