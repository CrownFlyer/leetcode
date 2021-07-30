package doublePointer;

/**
 * @description:
 * @author: ZMC
 * @email: m18996248458@163.com
 * @create: 2021-07-30 15:55
 */
public class LEETCODE_467_MIDDLE {
    // 动态规划
    public int findSubstringInWraproundString1(String p) {
        // 记录p中以每个字符结尾的最长连续子串的长度
        int[] dp = new int[26];
        int n = p.length();
        // 记录连续子串的长度
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (i > 0 && (p.charAt(i) - p.charAt(i - 1) - 1) % 26 == 0) count++;
            else count = 1;
            dp[p.charAt(i) - 'a'] = Math.max(dp[p.charAt(i) - 'a'], count);
        }
        int res = 0;
        // 这里记录的最长距离为什么可以直接加，因为末尾元素不同，且dp[i]的个数表示以末尾元素的不同长度元素，保证了唯一性
        for (int e : dp) {
            res += e;
        }
        return res;
    }

}
