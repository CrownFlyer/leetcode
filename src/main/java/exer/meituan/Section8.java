package exer.meituan;

import java.io.*;
import java.util.*;

/**
 * @description:
 * @author: ZMC
 * @email: m18996248458@163.com
 * @create: 2021-10-14 10:46
 */
public class Section8 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] init = br.readLine().split(" ");
        int n = Integer.parseInt(init[0]), x = Integer.parseInt(init[1]), y = Integer.parseInt(init[2]);
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 1; i < n; i++) {
            String[] datas = br.readLine().split(" ");
            int x1 = Integer.parseInt(datas[0]), y1 = Integer.parseInt(datas[1]);
            map.putIfAbsent(x1, new ArrayList<>());
            map.putIfAbsent(y1, new ArrayList<>());
            map.get(x1).add(y1);
            map.get(y1).add(x1);
        }
        int[] distX = bfs(map, x, n);
        int[] distY = bfs(map, y, n);

        int res = 0;
        for (int i = 1; i <= n; i++) {
            // y到i处不会被抓到
            if (distX[i] > distY[i]) res = Math.max(res, distX[i]);
        }

        bw.write(res + "\n");
        br.close();
        bw.close();
    }

    public static int[] bfs(Map<Integer, List<Integer>> map, int start, int n) {
        // 返回到所有点的最短距离
        int[] res = new int[n + 1];
        Arrays.fill(res, -1);
        // 队列
        Queue<Integer> q = new LinkedList<>();
        q.offer(start);
        // 初始点距离为0
        res[start] = 0;

        while (!q.isEmpty()) {
            int cur = q.poll();
            for (Integer next : map.get(cur)) {
                if (res[next] == -1) {
                    q.offer(next);
                    res[next] = res[cur] + 1;
                }
            }
        }
        return res;
    }
}

