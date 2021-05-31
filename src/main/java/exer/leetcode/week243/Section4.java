package exer.leetcode.week243;

/**
 * @description:
 * @author: ZMC
 * @email: m18996248458@163.com
 * @create: 2021-05-30 09:49
 */
public class Section4 {
    public static void main(String[] args) {
        Section4 test = new Section4();
        int dist[] = {7,3,5,5};
        int speed = 2;
        int hoursBefore = 10;
        System.out.println(test.minSkips(dist, speed, hoursBefore));
    }

    public int minSkips(int[] dist, int speed, int hoursBefore) {
        int n = dist.length;
        // dp[i][j]: 经过了前i段道路，使用了j次跳跃的最短用时所对应走过的路径，避免浮点运算损失精度
        long[][] dp = new long[n + 1][n + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= n; j++) {
                dp[i][j] = Integer.MAX_VALUE;
            }
        }
        for (int i = 1; i < n; i++) {
            // 这里j为什么要取=i，因为为了后续加跳跃步数，j也得计算为跳跃的值
            for (int j = 0; j <= i; j++) {
                if (j == 0) {   // 只能跳0次
                    dp[i][j] = (dp[i - 1][j] + dist[i - 1] + speed - 1) / speed * speed;
                } else {
                    dp[i][j] = Math.min(dp[i - 1][j - 1] + dist[i - 1], (dp[i - 1][j] + dist[i - 1] + speed - 1) / speed * speed);
                }
            }
        }
        for (int i = 0; i <= n; i++) {
            if ((dp[n - 1][i] + dist[n - 1]) <= speed * hoursBefore)
                return i;
        }
        return -1;
    }


}
