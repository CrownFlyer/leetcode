package exer.leetcode.lcp;

import org.junit.Test;

/**
 * @description:
 * @author: ZMC
 * @email: m18996248458@163.com
 * @create: 2021-09-25 14:54
 */
public class LCP_47_HARD {
    @Test
    public void test() {

    }

    public int securityCheck(int[] capacities, int k) {
        final int mod = 1000_000_007;
        int n = capacities.length;
        // dp[i]:背包总空间为i的时候装的方案数，一个都不装也是一种，因此初始化为1
        int[] dp = new int[k + 1];
        dp[0] = 1;
        // 总共要被扣留k个人，在n个背包中选中若干个背包，其扣留的人数总和恰好为k
        // 如果不是恰好则会多扣留人的时候把k也扣留进去，则k不会是第一个出来的
        // 扣留只能栈才能扣留，队列不会扣留
        // 每个capacities[j]扣留的人数为capacities[j]-1因为最上面的是活动的，不会扣留
        // 外循环是将capacities[i-1]当做栈时
        for (int i = 1; i <= n; i++) {
            // 内循环是0-1背包问题的迭代过程
            // j - (capacities[i - 1] - 1)就是除开capacities[i-1]当做栈时扣留的其他人数
            // 即将capacities[i - 1] - 1装进背包后的其他空间的最大方案数
            // 这里为什么要是逆序遍历，因为逆序保证了其他空间的最大方案数里不包括capacities[i - 1]为栈，否则会重复
            // 因为i是顺序遍历的，所以之前更新的dp只会把当前i之前的东西加入背包
            for (int j = k; j - (capacities[i - 1] - 1) >= 0; j--) {
                dp[j] += dp[j - (capacities[i - 1] - 1)];
                dp[j] %= mod;
            }
        }
        return dp[k];
    }

}
