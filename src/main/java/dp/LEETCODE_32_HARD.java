package dp;

import org.junit.Test;

/**
 * @description:
 * @author: ZMC
 * @email: m18996248458@163.com
 * @create: 2021-07-14 11:13
 */
public class LEETCODE_32_HARD {
    @Test
    public void test() {
        String s = "((()))";
        System.out.println(longestValidParentheses(s));
    }

    public int longestValidParentheses(String s) {
        // 记录已遍历过的左括号的个数
        int n = s.length();
        int max = 0;
        // dp[i]:前i个字符组成的字符串包含的最长有效括号长度
        int[] dp = new int[n];
        for (int i = 1; i < n; i++) {
            if (s.charAt(i) == ')') {
                // 形如...()
                if (s.charAt(i - 1) == '(') dp[i] = (i - 2 >= 0 ? dp[i - 2] : 0) + 2;
                    // 形如...))
                else if (i - dp[i - 1] - 1 >= 0 && s.charAt(i - dp[i - 1] - 1) == '(')
                    dp[i] = dp[i - 1] + (i - dp[i - 1] - 2 >= 0 ? dp[i - dp[i - 1] - 2] : 0) + 2;
            }
            max = Math.max(max,dp[i]);
        }
        return max;
    }
}
