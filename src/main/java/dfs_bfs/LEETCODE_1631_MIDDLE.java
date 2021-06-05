package dfs_bfs;

import java.util.LinkedList;

/**
 * @description:
 * @author: ZMC
 * @email: m18996248458@163.com
 * @create: 2021-06-04 22:16
 */
public class LEETCODE_1631_MIDDLE {
    public static void main(String[] args) {
        int[][] arr = {{1,10,6,7,9,10,4,9}};
//        int[][] arr = {{1,2,2},{3,8,2},{5,3,5}};
        LEETCODE_1631_MIDDLE test = new LEETCODE_1631_MIDDLE();
        System.out.println(test.minimumEffortPath(arr));
    }

    int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public int minimumEffortPath(int[][] heights) {
        int l = 0, r = 99999;
        int m = heights.length;
        int n = heights[0].length;
        LinkedList<int[]> q = new LinkedList<>();
        q.offer(new int[]{0, 0});
        while (l < r) {
            int mid = (l + r) >> 1;
            q.offer(new int[]{0, 0});
            boolean[] visited = new boolean[m * n];
            visited[0] = true;
            while (!q.isEmpty()) {
                int[] cur = q.poll();
                int x = cur[0], y = cur[1];
                for (int i = 0; i < 4; i++) {
                    int nx = x + dirs[i][0];
                    int ny = y + dirs[i][1];
                    if (nx >= 0 && nx < m && ny >= 0 && ny < n && !visited[nx * n + ny] && Math.abs(heights[nx][ny] - heights[x][y]) <= mid) {
                        q.offer(new int[]{nx, ny});
                        visited[nx * n + ny] = true;
                    }
                }
            }
            if (visited[m * n - 1]) r = mid;
            else l = mid + 1;
        }
        return l;
    }
}
