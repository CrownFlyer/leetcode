package exer.leetcode.week260;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @description:
 * @author: ZMC
 * @email: m18996248458@163.com
 * @create: 2021-09-26 22:48
 */
public class Section3 {
    @Test
    public void test() {

    }


    // 只定义下或者右的方向
    public boolean placeWordInCrossword(char[][] board, String word) {
        int targetLen = word.length();

        List<int[]> rows = new ArrayList<>();
        List<int[]> cols = new ArrayList<>();
        int m = board.length, n = board[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                boolean notOk = false;
                if (i - 1 >= 0 && board[i - 1][j] != '#') notOk = true;
                if (!notOk) {
                    boolean ok = true;
                    for (int k = 0; k < targetLen && ok; k++) {
                        if (i + k >= m || board[i + k][j] == '#') ok = false;
                    }
                    if(i+targetLen<m && board[i+targetLen][j] != '#') ok = false;
                    if (ok) rows.add(new int[]{i, j});
                }

                notOk = false;
                if (j - 1 >= 0 && board[i][j - 1] != '#') notOk = true;
                if (!notOk) {
                    boolean ok = true;
                    for (int k = 0; k < targetLen && ok; k++) {
                        if (j + k >= n || board[i][j + k] == '#') ok = false;
                    }
                    if(j+targetLen<n && board[i][j+targetLen] != '#') ok = false;
                    if (ok) cols.add(new int[]{i, j});
                }
            }
        }
        int[] cnt = new int[26];
        for (int i = 0; i < targetLen; i++) {
            cnt[word.charAt(i) - 'a']++;
        }
        for (int[] row : rows) {
            int[] temp = new int[26];
            for (int i = 0; i < targetLen; i++) {
                int x = row[0] + i, y = row[1];
                if (board[x][y] >= 'a' && board[x][y] <= 'z')
                    temp[board[x][y] - 'a']++;
            }
            boolean ok = true;
            for (int i = 0; i < 26 && ok; i++) {
                if (cnt[i] < temp[i]) ok = false;
            }
            if (ok) return true;
        }

        for (int[] col : cols) {
            int[] temp = new int[26];
            for (int i = 0; i < targetLen; i++) {
                int x = col[0], y = col[1] + i;
                if (board[x][y] >= 'a' && board[x][y] <= 'z')
                    temp[board[x][y] - 'a']++;
            }
            boolean ok = true;
            for (int i = 0; i < 26 && ok; i++) {
                if (cnt[i] < temp[i]) ok = false;
            }
            if (ok) return true;
        }

        return false;
    }
}
