package exer.leetcode.week239;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @description:
 * @author: ZMC
 * @email: m18996248458@163.com
 * @create: 2021-05-22 22:21
 */
public class Section4 {
    public static void main(String[] args) {
        int[][] intervals = {{2, 3}, {2, 5}, {1, 8}, {20, 25}};
        int[] queries = {2, 9, 5, 22};
        int[] ints = minInterval(intervals, queries);
        for (int i : ints) {
            System.out.println(i);
        }
    }

    // lambda表达式 超时
    public static int[] minInterval1(int[][] intervals, int[] queries) {
        int n = queries.length;
        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            final int temp = i;
            List<int[]> list = Arrays.stream(intervals)
                    .filter(x -> x[0] <= queries[temp] && x[1] >= queries[temp])
                    .sorted((x, y) -> x[1] - x[0] - y[1] + y[0])
                    .collect(Collectors.toList());
            res[i] = list.size() == 0 ? -1 : list.get(0)[1] - list.get(0)[0] + 1;
        }
        return res;
    }

    // 按照长度排序，遍历，无记忆性 超时
    public static int[] minInterval2(int[][] intervals, int[] queries) {
        int n = queries.length;
        int len = intervals.length;
        int[] res = new int[n];
        Arrays.fill(res, -1);
        Arrays.sort(intervals, (x, y) -> x[1] - x[0] - y[1] + y[0]);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < len; j++) {
                if (queries[i] <= intervals[j][1] && queries[i] >= intervals[j][0]) {
                    res[i] = intervals[j][1] - intervals[j][0] + 1;
                    break;
                }
            }
        }
        return res;
    }

    // 优先队列
    public static int[] minInterval(int[][] intervals, int[] queries) {
        //将区间按区间头从小到大排序
        Arrays.sort(intervals, (o1, o2) -> (o1[0] - o2[0]));
        //记录queries以及i，也就是queries[i]和i
        int[][] que = new int[queries.length][2];
        for (int i = 0; i < queries.length; ++i) {
            que[i][0] = queries[i];
            que[i][1] = i;
        }
        //将值排序，小的在前
        Arrays.sort(que, (o1, o2) -> (o1[0] - o2[0]));
        int[] res = new int[queries.length];
        Arrays.fill(res, -1);
        // 维护一个长度最短的优先队列
        PriorityQueue<int[]> queue = new PriorityQueue<>((x, y) -> x[1] - x[0] - y[1] + y[0]);

        int index = 0;
        for (int i = 0; i < queries.length; i++) {
            // 先把左边界符合queries[i]条件加入队列
            while (index < intervals.length && que[i][0] >= intervals[index][0]) queue.offer(intervals[index++]);

            // 再把右边界不符合queries[i]条件弹出队列
            while (!queue.isEmpty() && queue.peek()[1] < que[i][0]) queue.poll();

            if (!queue.isEmpty()) res[que[i][1]] = queue.peek()[1] - queue.peek()[0] + 1;
        }

        return res;
    }
}
