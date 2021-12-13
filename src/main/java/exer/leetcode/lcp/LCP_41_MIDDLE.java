package exer.leetcode.lcp;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @description:
 * @author: ZMC
 * @email: m18996248458@163.com
 * @create: 2021-09-11 14:14
 */
public class LCP_41_MIDDLE {
    @Test
    public void test() {
        String[] s = {"...", "X..", "O.."};
        System.out.println(flipChess(s));

    }

    // 这里不考虑角落的情况，必须是在同一条线上才有可能翻转
    public int flipChess(String[] chessboard) {
        int m = chessboard.length, n = chessboard[0].length();
        int[][] dirs = {{-1, -1}, {-1, 0}, {-1, 1}, {0, -1}, {0, 1}, {1, -1}, {1, 0}, {1, 1}};
        int cnt = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (chessboard[i].charAt(j) == '.') {
                    // 不修改原有的棋盘
                    int[][] board = new int[m][n];
                    // 记录黑色棋子
                    List<Integer> list = new ArrayList<>();
                    // 这里起始为1是因为 要把该位下成黑棋
                    // 记录准黑棋个数
                    int start = 1;
                    for (int ni = 0; ni < m; ni++) {
                        for (int nj = 0; nj < n; nj++) {
                            if (chessboard[ni].charAt(nj) == '.') board[ni][nj] = 0;
                            else if (chessboard[ni].charAt(nj) == 'X') {
                                list.add(ni * n + nj);
                                start++;
                                board[ni][nj] = 1;
                            } else board[ni][nj] = 2;
                        }
                    }
                    // 将该位置变成黑色棋子
                    board[i][j] = 1;
                    list.add(i * n + j);
                    int idx = 0;
                    while (idx < list.size()) {
                        int x = list.get(idx) / n, y = list.get(idx) % n;
                        for (int k = 0; k < 8; k++) {
                            int nx = x + dirs[k][0], ny = y + dirs[k][1];
                            while (nx >= 0 && nx < m && ny >= 0 && ny < n && board[nx][ny] == 2) {
                                nx += dirs[k][0];
                                ny += dirs[k][1];
                            }
                            // 找到一个闭合的区间
                            if (nx >= 0 && nx < m && ny >= 0 && ny < n && board[nx][ny] == 1) {
                                nx = x + dirs[k][0];
                                ny = y + dirs[k][1];
                                // 将中间的白棋全部变为黑棋
                                while (nx >= 0 && nx < m && ny >= 0 && ny < n && board[nx][ny] == 2) {
                                    list.add(nx * n + ny);
                                    board[nx][ny] = 1;
                                    nx = x + dirs[k][0];
                                    ny = y + dirs[k][1];
                                }
                            }
                        }
                        idx++;
                    }
                    // 所有黑棋 - 原有黑棋 = 翻转的白棋
                    cnt = Math.max(cnt, list.size() - start);
                }
            }
        }
        return cnt;
    }


}
