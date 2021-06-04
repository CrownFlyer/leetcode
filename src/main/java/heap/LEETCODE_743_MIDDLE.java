package heap;

import java.util.*;

/**
 * @description:
 * @author: ZMC
 * @email: m18996248458@163.com
 * @create: 2021-06-03 15:03
 */
public class LEETCODE_743_MIDDLE {
    public static void main(String[] args) {
        int[][] times = {{2, 1, 1}, {2, 3, 1}, {3, 4, 1}};
//        int[][] times = {{1,2,1}};
        LEETCODE_743_MIDDLE test = new LEETCODE_743_MIDDLE();
        System.out.println(test.networkDelayTime(times, 4, 2));
    }

    Map<Integer,Integer> dist;
    public int networkDelayTime(int[][] times, int n, int k) {
        HashMap<Integer, List<int[]>> graph = new HashMap<>();
        for (int[] edge : times) {
            graph.getOrDefault(edge[0], new ArrayList<int[]>()).add(new int[]{edge[2],edge[1]});
        }
        return 0;
    }

    public int dfs(int k) {
        return 0;
    }


}
