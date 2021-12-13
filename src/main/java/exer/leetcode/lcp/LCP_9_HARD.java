package exer.leetcode.lcp;

import org.junit.Test;

/**
 * @description:
 * @author: ZMC
 * @email: m18996248458@163.com
 * @create: 2021-09-14 08:54
 */
public class LCP_9_HARD {
    @Test
    public void test() {
        int[] j = {2, 5, 1, 1, 1, 1};
        System.out.println(minJump(j));
    }

    public int minJump(int[] jump) {
        int n = jump.length;
        // dp[i]:从i的位置跳出弹簧机的最小步数
        int[] dp = new int[n];
        dp[n - 1] = 1;
        for (int i = n - 2; i >= 0; i--) {
            dp[i] = jump[i] + i >= n ? 1 : dp[i + jump[i]] + 1;
            // 如果dp[i]更新了，对于所有的j(i<j<n)都多了一种选择，可以先往左跳到i然后再往右跳
            // dp[i]更新了更小的值一定说明从i这个位置可以一下跳出，然后才有后面值的更新
            for (int j = i + 1; j < n && dp[j] >= dp[i] + 1; j++)
                dp[j] = dp[i] + 1;
        }
        return dp[0];
    }
}
