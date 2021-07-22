package doublePointer;

import org.junit.Test;

/**
 * @description:
 * @author: ZMC
 * @email: m18996248458@163.com
 * @create: 2021-07-22 16:48
 */
public class LEETCODE_1423_MIDDLE {
    @Test
    public void test() {
        int[] cs = {96, 90, 41, 82, 39, 74, 64, 50, 30};
        System.out.println(maxScore(cs, 8));
    }

    public int maxScore(int[] cardPoints, int k) {
        int n = cardPoints.length;
        // pre[i]:前i个元素之和
        int[] pre = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            pre[i] = pre[i - 1] + cardPoints[i - 1];
        }
        int max = 0;
        for (int i = 0; i <= k; i++) {
            max = Math.max(max, pre[i] + pre[n] - pre[n - k + i]);
        }
        return max;
    }
}
