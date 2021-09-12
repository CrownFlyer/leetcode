package hash;

import java.util.HashMap;

/**
 * @description:
 * @author: ZMC
 * @email: m18996248458@163.com
 * @create: 2021-09-02 10:53
 */
public class LEETCODE_36_MIDDLE {
    public boolean isValidSudoku(char[][] board) {
        HashMap<Integer, Integer>[] rows = new HashMap[9];
        HashMap<Integer, Integer>[] columns = new HashMap[9];
        HashMap<Integer, Integer>[] boxs = new HashMap[9];
        for (int i = 0; i < 9; i++) {
            rows[i] = new HashMap<>();
            columns[i] = new HashMap<>();
            boxs[i] = new HashMap<>();
        }

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char c = board[i][j];
                if (c != '.') {
                    int n = c - '0';
                    int boxIndex = (i / 3) * 3 + j / 3;

                    rows[i].put(n, rows[i].getOrDefault(n, 0) + 1);
                    columns[j].put(n, columns[j].getOrDefault(n, 0) + 1);
                    boxs[boxIndex].put(n, boxs[boxIndex].getOrDefault(n, 0) + 1);
                    if (rows[i].get(n) > 1 || columns[j].get(n) > 1 || boxs[boxIndex].get(n) > 1) return false;
                }
            }
        }
        return true;
    }
}
