package stackAndQueue;

import org.junit.Test;

import java.util.*;

/**
 * @description:
 * @author: ZMC
 * @email: m18996248458@163.com
 * @create: 2021-07-13 09:32
 */
public class LEETCODE_218_HARD {
    @Test
    public void test() {
        int[][] bs = {{2, 9, 10}, {3, 7, 8}};
        System.out.println(getSkyline(bs));

    }

    public List<List<Integer>> getSkyline(int[][] buildings) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((x, y) -> x[0] != y[0] ? x[0] - y[0] : x[1] - y[1]);
        for (int[] building : buildings) {
            // 用负数代表左边界
            pq.offer(new int[]{building[0], -building[2]});
            pq.offer(new int[]{building[1], building[2]});
        }
        List<List<Integer>> res = new ArrayList<>();

        TreeMap<Integer, Integer> heights = new TreeMap<>((x, y) -> y - x);
        // 这个高度赋值为了解决heights没有元素的问题
        heights.put(0, 1);
        int l = 0, h = 0;

        while (!pq.isEmpty()) {
            int[] arr = pq.poll();
            // 左端点
            if (arr[1] < 0) heights.put(-arr[1], heights.getOrDefault(-arr[1], 0) + 1);
            // 右端点
            else {
                heights.put(arr[1], heights.get(arr[1]) - 1);
                // 说明左右端点已经遍历完
                if (heights.get(arr[1]) == 0) heights.remove(arr[1]);
            }
            // 由于heights以降序排列，所以下面会获得最大高度
            int maxHeight = heights.keySet().iterator().next();
            // 如果最大高度改变，则说明当前建筑高度在一个比它高的建筑下面，不做操作
            if (maxHeight != h) {
                l = arr[0];
                h = maxHeight;
                res.add(Arrays.asList(l, h));
            }
        }
        return res;
    }
}
