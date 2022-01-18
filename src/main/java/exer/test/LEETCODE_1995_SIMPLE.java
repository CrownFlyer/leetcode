package exer.test;

/**
 * @description:
 * @author: ZMC
 * @email: m18996248458@163.com
 * @create: 2021-12-29 10:11
 */
public class LEETCODE_1995_SIMPLE {
    // 哈希表
    // O(n^2)
    public int countQuadruplets2(int[] nums) {
        int n = nums.length, res = 0;
        int[] cnt = new int[401];
        for(int b = n - 3;b>=1;b--){
            for(int d = n - 1;d-1>b;d--) cnt[nums[d]-nums[b+1] + 200]++;
            for(int a = 0;a<b;a++) res += cnt[nums[a] + nums[b]+200];
        }
        return res;
    }

    // 二维背包
    // O(n)
    public int countQuadruplets(int[] nums) {
        int n = nums.length;
        // dp[i][j][k]:考虑前i个物品，凑成数值恰好为j，使用个数恰好为k的方案数
        int[][][] dp = new int[n+1][101][4];
        dp[0][0][0] = 1;
        for(int i = 1;i<=n;i++){
            int t = nums[i-1];
            for(int j = 0;j<101;j++){
                for(int k = 0;k<4;k++){
                    // nums[i-1]不参与组成
                    dp[i][j][k] += dp[i-1][j][k];
                    // nums[i-1]参与组成
                    if(j-t>=0 && k-1 >= 0) dp[i][j][k] += dp[i-1][j-t][k-1];
                }
            }
        }
        int res = 0;
        for(int i = 3;i<=n;i++) res+=dp[i][nums[i-1]][3];
        return res;

    }
}
