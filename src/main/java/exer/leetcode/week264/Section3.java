package exer.leetcode.week264;

import org.junit.Test;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @description:
 * @author: ZMC
 * @email: m18996248458@163.com
 * @create: 2021-10-24 10:28
 */
public class Section3 {
    @Test
    public void test() {
        int[] ps = {-1, 2, 0};
        System.out.println(countHighestScoreNodes(ps));
    }


    public int countHighestScoreNodes(int[] parents) {
        int n = parents.length;
        int[] inDegree = new int[n];
        for (int i = 1; i < n; i++)
            inDegree[parents[i]]++;
        Deque<Integer> q = new LinkedList<>();
        for (int i = 0; i < n; i++)
            if (inDegree[i] == 0) q.offer(i);
        // 记录左右子节点个数
        int[] lsum = new int[n];
        int[] rsum = new int[n];
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int cur = q.poll();
                inDegree[parents[cur]]--;
                // 1表示子节点，lsum[cur]、rsum[cur]表示子节点的左右节点总和
                if (lsum[parents[cur]] == 0) lsum[parents[cur]] = 1 + lsum[cur] + rsum[cur];
                else rsum[parents[cur]] = 1 + lsum[cur] + rsum[cur];
                if (inDegree[parents[cur]] == 0 && parents[cur] != 0) q.offer(parents[cur]);
            }
        }

        long max = 0;
        int res = 0;
        for (int i = 0; i < n; i++) {
            // 这里稍微画个图就可以分析，第一部分是去除点的左右子树乘积
            long tempMax = Math.max(1, Math.max(1, lsum[i]) * Math.max(rsum[i], 1));
            // 第二部分是与去掉点的父节点相连部分的乘积
            tempMax *= Math.max(1, (lsum[0] + rsum[0]) - (lsum[i] + rsum[i]));
            if (tempMax == max) res++;
            else if (tempMax > max) {
                max = tempMax;
                res = 1;
            }
        }
        return res;
    }


}
