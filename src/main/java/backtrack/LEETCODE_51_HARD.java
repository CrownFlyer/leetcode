package backtrack;

import org.junit.Test;

import java.util.*;

/**
 * @description:
 * @author: ZMC
 * @email: m18996248458@163.com
 * @create: 2021-09-23 14:43
 */
public class LEETCODE_51_HARD {
    @Test
    public void test() {
        System.out.println(solveNQueens(4));
    }

    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<>();
        // queens[i] = j:第i行的第j列放置皇后
        int[] queens = new int[n];
        Set<Integer> columns = new HashSet<>();
        Set<Integer> diagonals1 = new HashSet<>();
        Set<Integer> diagonals2 = new HashSet<>();
        backtrace(res, queens, n, 0, columns, diagonals1, diagonals2);
        return res;
    }

    public void backtrace(List<List<String>> res, int[] queens, int n, int row, Set<Integer> columns, Set<Integer> diagonals1, Set<Integer> diagonals2) {
        if (row == n) {
            List<String> board = generateBoard(queens, n);
            res.add(board);
        } else {
            for (int i = 0; i < n; i++) {
                if (columns.contains(i)) continue;
                int diagonal1 = row - i;
                if (diagonals1.contains(diagonal1)) continue;
                int diagonal2 = row + i;
                if (diagonals2.contains(diagonal2)) continue;

                queens[row] = i;
                columns.add(i);
                diagonals1.add(diagonal1);
                diagonals2.add(diagonal2);
                backtrace(res, queens, n, row + 1, columns, diagonals1, diagonals2);
                queens[row] = 0;
                columns.remove(i);
                diagonals1.remove(diagonal1);
                diagonals2.remove(diagonal2);
            }
        }
    }

    private List<String> generateBoard(int[] queens, int n) {
        List<String> board = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            char[] row = new char[n];
            Arrays.fill(row, '.');
            row[queens[i]] = 'Q';
            board.add(new String(row));
        }
        return board;
    }

}
