package dp;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @description:
 * @author: ZMC
 * @email: m18996248458@163.com
 * @create: 2021-08-05 16:29
 */
public class LEETCODE_131_MIDDLE {
    @Test
    public void test() {
        String s = "abbab";
        System.out.println(partition(s));
    }

    // 记录回文串
    boolean[][] dp;
    List<List<String>> res = new ArrayList<>();
    List<String> list = new ArrayList<>();
    int n;

    // O(n*2^n) O(n^2)
    public List<List<String>> partition(String s) {
        n = s.length();
        // dp[i][j] = true：s[i:j]为回文串
        dp = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], true);
        }
        for (int i = n - 1; i >= 0; i--) {
            for (int j = i + 1; j < n; j++) {
                // j从i后一位开始遍历，保证了[i:j]中间的都是判断过的
                dp[i][j] = (s.charAt(i) == s.charAt(j)) && dp[i + 1][j - 1];
            }
        }
        dfs(s, 0);
        return res;
    }

    public void dfs(String s, int i) {
        if (i == n) res.add(new ArrayList<>(list));
        else {
            // j表示子字符串终点下标
            for (int j = i; j < n; j++) {
                if (dp[i][j]) {
                    list.add(s.substring(i, j + 1));
                    dfs(s, j + 1);
                    // 这里不能是 list.remove(s.substring(i, j + 1));
                    // 一定是删除最后一个，而不是根据对象去删除，不然会导致乱序
                    list.remove(list.size() - 1);
                }
            }
        }
    }
}
