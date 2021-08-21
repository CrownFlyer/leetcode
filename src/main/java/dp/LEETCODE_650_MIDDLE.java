package dp;

/**
 * @description:
 * @author: ZMC
 * @email: m18996248458@163.com
 * @create: 2021-08-21 16:15
 */
public class LEETCODE_650_MIDDLE {
    // 数学（素数分解）
    public int minSteps(int n) {
        // 2 是最小的素数因子，所以从 2 开始
        int res = 0, d = 2;
        while (n > 1) {
            while (n % d == 0) {
                // 如果此时 d 不是当前 n 的最小素数因子了，那么 d++ 继续试探
                // 其实此处应该是把 d 变为比 d 大的下一个素数，但是我们没有必要在构建出一个素数因子的数组，
                // 因为得不偿失(还需要创建一个判断是否为素数的方法)，那会花费更多的时间和空间，不如让计算机一个个去试就好了
                res += d;
                n /= d;
            }
            d++;
        }
        return res;
    }

    // 动态规划 O(N^3/2)
    public int minSteps1(int n) {
        int[] dp = new int[n + 1];
        dp[1] = 1;
        for (int i = 1; i <= n; i++) {
            dp[i] = i;
            for (int j = 2; j * j <= i; j++) {
                // 这里为什么不用Math.min 这是因为j越到后面所需要的操作次数越小
                // 那其对应的dp[j]和dp[i/j]的花销和就小，不像两个都是中间的，都需要复制等2份的花销
                if (i % j == 0) {
                    dp[i] = dp[j] + dp[i / j];
                    break;
                }
            }
        }
        return dp[n];
    }
}
