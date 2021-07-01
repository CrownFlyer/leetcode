package dfs_bfs;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @description:
 * @author: ZMC
 * @email: m18996248458@163.com
 * @create: 2021-06-30 21:42
 */
public class LEETCODE_773_HARD {
    @Test
    public void test() {
        int[][] b = {{1,2,3}, {4,5,0}};
        System.out.println(slidingPuzzle(b));
    }

    public int slidingPuzzle(int[][] board) {
        int m = board.length;
        int n = board[0].length;
        int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        int[] startCharArray = new int[6];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                startCharArray[i * n + j] = board[i][j];
            }
        }
        int[] endCharArray = {1, 2, 3, 4, 5, 0};
        if (comp(startCharArray, endCharArray)) return 0;

        // 记录总的遍历过的
        Map<Integer, int[]> visited = new HashMap<>();

        // 记录左右bfs
        Map<Integer, int[]> beginVisited = new HashMap<>();
        beginVisited.put(hash(startCharArray), startCharArray);
        Map<Integer, int[]> endVisited = new HashMap<>();
        endVisited.put(hash(endCharArray), endCharArray);

        int step = 0;
        while (!beginVisited.isEmpty() && !endVisited.isEmpty()) {
            // 用小的集合来bfs
            if (beginVisited.size() > endVisited.size()) {
                Map<Integer, int[]> temp = beginVisited;
                beginVisited = endVisited;
                endVisited = temp;
            }

            // 现在beginVisited为小的集合
            Map<Integer, int[]> nextLevelVisited = new HashMap<>();
            for (int[] cur : beginVisited.values()) {
                for (int i = 0; i < cur.length; i++)
                    if (cur[i] == 0) {
                        int x = i / n, y = i % n;
                        for (int j = 0; j < 4; j++) {
                            int nx = x + dir[j][0];
                            int ny = y + dir[j][1];
                            if (nx >= 0 && nx < m && ny >= 0 && ny < n) {
                                int temp = cur[x * n + y];
                                cur[x * n + y] = cur[nx * n + ny];
                                cur[nx * n + ny] = temp;
                                // 注意，这里放入Map的value是引用，因此需要重新复制一份
                                int[] dest = new int[6];
                                System.arraycopy(cur, 0, dest, 0, 6);
                                if (!visited.containsKey(hash(cur))) {
                                    visited.put(hash(dest), dest);
                                    nextLevelVisited.put(hash(dest), dest);
                                }
                                if (endVisited.containsKey(hash(dest))) return step + 1;
                                // 这里还要换回去
                                cur[nx * n + ny] = cur[x * n + y];
                                cur[x * n + y] = temp;
                            }
                        }
                    }
            }
            step++;
            beginVisited = nextLevelVisited;
        }
        return -1;
    }

    public int hash(int[] arr) {
        int hash = 0;
        for (int i = 0; i < arr.length; i++) {
            hash = hash * 7 + arr[i];
        }
        return hash;
    }

    public boolean comp(int[] arr1, int[] arr2) {
        if (arr1.length != arr2.length) return false;
        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] != arr2[i]) return false;
        }
        return true;
    }
}
