package dp;

/**
 * @description:
 * @author: ZMC
 * @email: m18996248458@163.com
 * @create: 2021-02-08 10:05
 */
public class OneAndZero_474 {
    public static void main(String[] args) {
        String[] strs = {"10", "0001", "01", "1", "0"};
        int m = 5;
        int n = 3;
        int res = findMaxForm(strs, m, n);
        System.out.println(res);

    }

    private static int[] countZeroAndOne(String str) {
        int[] cnt = new int[2];
        for (char c : str.toCharArray()) {
            cnt[c - '0']++;
        }
        return cnt;
    }

    public static int findMaxForm(String[] strs, int m, int n) {
        if (strs == null || strs.length <= 0) {
            return 0;
        }
        int[][] dp = new int[m + 1][n + 1];
        for (String str : strs) {
            /*
                记录当前字符串中0/1个数:
                Nums[0]表示0的个数
                Nums[1]表示1的个数
             */
            int[] Nums = countZeroAndOne(str);
            /*
                dp[i][j]的结果有两种情况:
                    1.当前状态(dp[i][j])
                    2.上一个状态(dp[i-Nums[0]][j-Nums[1]])的个数+1
            */
            for (int i = m; i >= Nums[0]; i--) {
                for (int j = n; j >= Nums[1]; j--) {
                    dp[i][j] = Math.max(dp[i][j], dp[i - Nums[0]][j - Nums[1]] + 1);
                }
            }
        }
        return dp[m][n];
    }
}
