package exer.test;

import org.junit.Test;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @description:
 * @author: ZMC
 * @email: m18996248458@163.com
 * @create: 2021-09-12 09:30
 */
public class LEETCODE_678_MIDDLE {
    @Test
    public void test() {
    }

    // 区间dp:O(n^3) O(n^2)
    public boolean checkValidString(String s) {
        int n = s.length();
        // dp[i][j]:s[i]~s[j]是否为有效括号
        boolean[][] dp = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '*')
                dp[i][i] = true;
        }

        for (int i = 1; i < n; i++) {
            char c1 = s.charAt(i - 1), c2 = s.charAt(i);
            dp[i - 1][i] = (c1 == '(' || c1 == '*') && (c2 == ')' || c2 == '*');
        }

        for (int i = n - 3; i >= 0; i--) {
            char c1 = s.charAt(i);
            for (int j = i + 2; j < n; j++) {
                char c2 = s.charAt(j);
                if ((c1 == '(' || c1 == '*') && (c2 == ')' || c2 == '*'))
                    dp[i][j] = dp[i + 1][j - 1];
                for (int k = i; k < j && !dp[i][j]; k++)
                    dp[i][j] = dp[i][k] && dp[k + 1][j];
            }
        }
        return dp[0][n - 1];
    }

    // Stack:O(n) O(1)
    public boolean checkValidString2(String s) {
        Deque<Integer> lStk = new LinkedList<>();
        Deque<Integer> sStk = new LinkedList<>();
        int n = s.length();
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if (c == '(') lStk.push(i);
            else if (c == '*') sStk.push(i);
            else {
                if (!lStk.isEmpty()) lStk.pop();
                else if (!sStk.isEmpty()) sStk.pop();
                else return false;
            }
        }
        while (!lStk.isEmpty() && !sStk.isEmpty()) {
            if (lStk.pop() > sStk.pop())
                return false;
        }

        return lStk.isEmpty();
    }


}
