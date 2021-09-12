package dfs_bfs;

import java.util.ArrayList;
import java.util.List;

/**
 * @description:
 * @author: ZMC
 * @email: m18996248458@163.com
 * @create: 2021-09-02 13:59
 */
public class LEETCODE_37_HARD {
    private boolean[][] rows = new boolean[9][9];
    private boolean[][] cols = new boolean[9][9];
    private boolean[][][] boxs = new boolean[3][3][9];
    // 全局搜索标志
    private boolean valid = false;
    private List<int[]> spaces = new ArrayList<>();

    public void solveSudoku(char[][] board) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.') spaces.add(new int[]{i, j});
                else {
                    int idx = board[i][j] - '1';
                    rows[i][idx] = cols[idx][j] = boxs[i / 3][j / 3][idx] = true;
                }
            }
        }

        dfs(board, 0);
    }

    public void dfs(char[][] board, int pos) {
        if (pos == spaces.size()) {
            valid = true;
            return;
        }
        int[] space = spaces.get(pos);
        int i = space[0], j = space[1];
        for (int idx = 0; idx < 9 && !valid; idx++) {
            if (!rows[i][idx] && !cols[idx][j] && !boxs[i / 3][j / 3][idx]) {
                rows[i][idx] = cols[idx][j] = boxs[i / 3][j / 3][idx] = true;
                board[i][j] = (char) (idx + '1');
                dfs(board, pos + 1);
                rows[i][idx] = cols[idx][j] = boxs[i / 3][j / 3][idx] = false;
            }
        }
    }

}
