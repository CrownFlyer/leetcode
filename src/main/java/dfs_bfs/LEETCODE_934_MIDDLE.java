package dfs_bfs;

import org.junit.Test;

import java.util.*;

/**
 * @description:
 * @author: ZMC
 * @email: m18996248458@163.com
 * @create: 2021-06-23 16:13
 */
public class LEETCODE_934_MIDDLE {
    @Test
    public void test() {
        int[][] A = {{1,1,1,1,1},{1,0,0,0,1},{1,0,1,0,1},{1,0,0,0,1},{1,1,1,1,1}};
        System.out.println(new LEETCODE_934_MIDDLE().shortestBridge1(A));
    }

    public int shortestBridge1(int[][] A) {
        int m = A.length, n = A[0].length;
        int findOneInSomeIsland = 0;
        for (findOneInSomeIsland = 0; findOneInSomeIsland < m * n; findOneInSomeIsland++) {
            if (A[findOneInSomeIsland / n][findOneInSomeIsland % n] != 0) break;
        }
        // bfs 寻找findOneInSomeIsland所在岛的所有元素，并标记为2；后续被复用为存储上一层的元素
        LinkedList<Integer> q = new LinkedList<>();
        // 存储下一层搜索的所有元素，去重
        Set<Integer> set = new HashSet<>();
        q.push(findOneInSomeIsland);
        boolean[] visited = new boolean[m * n];
        while (!q.isEmpty()) {
            int node = q.poll();
            visited[node] = true;
            set.add(node);
            int r = node / n, c = node % n;
            A[r][c] = 2;
            if (r - 1 >= 0 && A[r - 1][c] == 1) q.push((r - 1) * n + c);
            if (r + 1 < m && A[r + 1][c] == 1) q.push((r + 1) * n + c);
            if (c - 1 >= 0 && A[r][c - 1] == 1) q.push(r * n + c - 1);
            if (c + 1 < n && A[r][c + 1] == 1) q.push(r * n + c + 1);
        }

        int depth = 0;
        //dfs 寻找岛周围一层的元素
        while (true) {
            int size = set.size();

            Iterator<Integer> iter = set.iterator();
            while (iter.hasNext()) {
                Integer next = iter.next();
                if (A[next / n][next % n] == 1) return depth - 1;
                q.offer(next);
            }
            set.clear();

            for (int i = 0; i < size; i++) {
                Integer next = q.poll();
                visited[next] = true;
                int r = next / n, c = next % n;
                if (r - 1 >= 0 && !visited[(r - 1) * n + c]) set.add((r - 1) * n + c);
                if (r + 1 < m && !visited[(r + 1) * n + c]) set.add((r + 1) * n + c);
                if (c - 1 >= 0 && !visited[r * n + c - 1]) set.add(r * n + c - 1);
                if (c + 1 < n && !visited[r * n + c + 1]) set.add(r * n + c + 1);
            }
            depth++;
        }

    }

    public int shortestBridge(int[][] A) {
        int m = A.length, n = A[0].length;
        int[][] colors = getComponents(A);

        // 记录下colors中标记为1的岛
        Queue<Node> queue = new LinkedList<>();
        // 记录下另一个岛
        Set<Integer> target = new HashSet<>();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (colors[i][j] == 1) queue.add(new Node(i, j, 0));
                else if (colors[i][j] == 2) target.add(i * n + j);
            }
        }

        while (!queue.isEmpty()) {
            Node node = queue.poll();
            if (target.contains(node.r * n + node.c)) return node.depth - 1;
            for (Integer neighbor : neighbors(A, node.r, node.c)) {
                int nr = neighbor / n, nc = neighbor % n;
                if (colors[nr][nc] != 1) {
                    queue.add(new Node(nr, nc, node.depth + 1));
                    colors[nr][nc] = 1;
                }
            }
        }

        return -1;
    }

    public int[][] getComponents(int[][] A) {
        int m = A.length, n = A[0].length;
        int[][] colors = new int[m][n];
        int t = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (colors[i][j] == 0 && A[i][j] == 1) {
                    // dfs搜索
                    Stack<Integer> stack = new Stack<>();
                    stack.push(i * n + j);
                    colors[i][j] = ++t;
                    while (!stack.isEmpty()) {
                        int node = stack.pop();
                        int r = node / n, c = node % n;
                        for (Integer neighbor : neighbors(A, r, c)) {
                            int nr = neighbor / n, nc = neighbor % n;
                            if (A[nr][nc] == 1 && colors[nr][nc] == 0) {
                                colors[nr][nc] = t;
                                stack.push(neighbor);
                            }
                        }
                    }
                }
            }
        }
        return colors;
    }

    public List<Integer> neighbors(int[][] A, int r, int c) {
        int m = A.length;
        int n = A[0].length;
        ArrayList<Integer> neighbors = new ArrayList<>();
        if (r - 1 >= 0) neighbors.add((r - 1) * n + c);
        if (r + 1 < m) neighbors.add((r + 1) * n + c);
        if (c - 1 >= 0) neighbors.add(r * n + c - 1);
        if (c + 1 < n) neighbors.add(r * n + c + 1);
        return neighbors;
    }

    class Node {
        int r;
        int c;
        int depth;

        public Node(int r, int c, int depth) {
            this.r = r;
            this.c = c;
            this.depth = depth;
        }
    }
}
