package exer.leetcode.week242;

/**
 * @description:
 * @author: ZMC
 * @email: m18996248458@163.com
 * @create: 2021-05-24 12:02
 */
public class Section3 {
    public static void main(String[] args) {
        String s = "01101";
        System.out.println(canReach(s, 2, 3));
    }

    // dp + 前缀和 优化
    public static boolean canReach(String s, int minJump, int maxJump) {
        int n = s.length();
        // dp[i]: true 表示能从0->i
        boolean[] dp = new boolean[n];
        int[] pre = new int[n];
        for (int i = 0; i < minJump; i++) {
            // 前缀和为1，初始化为第一个可达
            pre[i] = 1;
        }
        for (int i = minJump; i < n; i++) {
            int left = i - maxJump, right = i - minJump;
            if (s.charAt(i) == '0') {
                int total = pre[right] - (left <= 0 ? 0 : pre[left - 1]);
                dp[i] = total != 0;
            }
            pre[i] = pre[i - 1] + (dp[i] ? 1 : 0);
        }

        return dp[n - 1];
    }

    public static boolean canReach1(String s, int minJump, int maxJump) {
        int n = s.length();
        if (s.charAt(n - 1) != '0') return false;
        // dp[i]: true 表示能从0->i
        boolean[] dp = new boolean[n];
//        for (int i = 0; i < n; i++) dp[i] = s.charAt(i) == '0';
        for (int i = minJump; i <= maxJump; i++) {
            dp[i] = s.charAt(i) == '0';
        }
        for (int j = maxJump + 1; j < n; j++) {
            for (int i = j - maxJump; i <= j - minJump; i++) {
                dp[j] = dp[j] || dp[i];
                if (dp[i]) break;
            }
            dp[j] &= s.charAt(j) == '0';
        }

        return dp[n - 1];
    }
}
