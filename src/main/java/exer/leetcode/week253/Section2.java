package exer.leetcode.week253;

import org.junit.Test;

import java.util.PriorityQueue;

/**
 * @description:
 * @author: ZMC
 * @email: m18996248458@163.com
 * @create: 2021-08-08 10:22
 */
public class Section2 {
    @Test
    public void test() {

    }

    public int minStoneSum(int[] piles, int k) {
        PriorityQueue<Integer> q = new PriorityQueue<>((x, y) -> y - x);
        for (int pile : piles) {
            q.offer(pile);
        }

        while (k > 0) {
            Integer e = q.poll();
            e -= e / 2;
            q.offer(e);
            k--;
        }
        int res = 0;
        while (!q.isEmpty()) res += q.poll();
        return res;
    }

}
