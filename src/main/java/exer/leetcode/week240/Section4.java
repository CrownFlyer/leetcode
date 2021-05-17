package exer.leetcode.week240;

import java.util.*;

/**
 * @description:
 * @author: ZMC
 * @email: m18996248458@163.com
 * @create: 2021-05-10 20:06
 */
public class Section4 {
    public static void main(String[] args) {
        String colors = "abaca";
        int[][] edges = {{0, 1}, {0, 2}, {2, 3}, {3, 4}};
        System.out.println(largestPathValue(colors, edges));
    }


    public static int largestPathValue(String colors, int[][] edges) {
        //总的节点数量
        int clen = colors.length();
        //边的数目
        int len = edges.length;
        //储存当前节点的父节点的数目
        int[] sum = new int[clen];
        //储存当前节点的的next节点
        Map<Integer, Set<Integer>> map = new HashMap();
        for (int i = 0; i < len; i++) {
            int a = edges[i][0];
            int b = edges[i][1];
            if (map.get(a) == null) map.put(a, new HashSet());
            map.get(a).add(b);
            sum[b]++;
        }
        List<Integer> list = new ArrayList();
        Queue<Integer> queue = new ArrayDeque();
        //先找到父节点数目为0的初试节点
        for (int i = 0; i < clen; i++)
            if (sum[i] == 0) queue.add(i);
        while (!queue.isEmpty()) {
            //移除当前父节点数目为0的节点
            int tem = queue.poll();
            list.add(tem);
            if (map.get(tem) != null)
                //移除的同时,将该节点的子节点的引用数目减一,减到0的节点加入队列重复操作
                for (Integer a : map.get(tem)) {
                    sum[a]--;
                    if (sum[a] == 0)
                        queue.add(a);
                }
        }
        //如果链表中添加的节点数目不等于总节点数目,则存在循环
        if (list.size() != clen) return -1;
        int[][] dp = new int[clen][26]; //  dp[i][j] 表示以i为终点，字符j的最大出现次数
        int max = 0;
        //此时链表中节点的顺序一定是:前面的节点不会是后面节点的子节点,并且每次扫描到链表中节点的时候,将当前节点的子节点的26种情况进行判断更新为最大值
        for (int i = 0; i < clen; i++) {
            int a = list.get(i);
            int color = colors.charAt(a) - 'a';
            dp[a][color] = Math.max(dp[a][color], 1);   // 这里为什么是和1比较大小，因为加1的操作是由前驱节点对其后继节点更新时产生的，这里只是对初始值有用
            if (map.get(a) != null) // 如果a还有后继节点，继续遍历
                for (Integer b : map.get(a))
                    for (int j = 0; j < 26; j++) {
                        int c = colors.charAt(b) - 'a';
                        dp[b][j] = Math.max(dp[b][j], dp[a][j] + (c == j ? 1 : 0));
                    }
            max = Math.max(max, dp[a][color]);
        }
        return max;
    }


}
