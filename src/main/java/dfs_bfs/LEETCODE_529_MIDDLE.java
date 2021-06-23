package dfs_bfs;

import org.junit.Test;

/**
 * @description:
 * @author: ZMC
 * @email: m18996248458@163.com
 * @create: 2021-06-23 20:07
 */
public class LEETCODE_529_MIDDLE {

    int[] dirX = {-1, -1, -1, 0, 0, 1, 1, 1};
    int[] dirY = {-1, 0, 1, -1, 1, -1, 0, 1};

    @Test
    public void test() {
        char[][] b = {{'E', 'E', 'E', 'E', 'E'}, {'E', 'E', 'M', 'E', 'E'}, {'E', 'E', 'E', 'E', 'E'}, {'E', 'E', 'E', 'E', 'E'}};
        int[] c = {3, 0};
        new LEETCODE_529_MIDDLE().updateBoard(b, c);
        int[] c1 = {1, 2};
        new LEETCODE_529_MIDDLE().updateBoard(b, c1);
        for (int i = 0; i < b.length; i++) {
            for (int j = 0; j < b[0].length; j++) {
                System.out.print(b[i][j]);
            }
            System.out.println();
        }
    }


    public char[][] updateBoard(char[][] board, int[] click) {
        int x = click[0], y = click[1];
        if (board[x][y] == 'M') board[x][y] = 'X';
        else dfs(board, x, y);
        return board;
    }

    public void dfs(char[][] board, int x, int y) {
        int cnt = 0;
        for (int i = 0; i < 8; i++) {
            int tx = x + dirX[i], ty = y + dirY[i];
            if (tx < 0 || tx >= board.length || ty < 0 || ty >= board[0].length) continue;
            // 判断周围是否有mine
            if (board[tx][ty] == 'M') cnt++;
        }
        if (cnt > 0) board[x][y] = (char) (cnt + '0');
        else {
            board[x][y] = 'B';
            for (int i = 0; i < 8; i++) {
                int tx = x + dirX[i], ty = y + dirY[i];
                if (tx < 0 || tx >= board.length || ty < 0 || ty >= board[0].length || board[tx][ty] != 'E') continue;
                dfs(board, tx, ty);
            }
        }
    }
}
