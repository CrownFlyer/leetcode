package exer.leetcode.week247;

import org.junit.Test;

/**
 * @description:
 * @author: ZMC
 * @email: m18996248458@163.com
 * @create: 2021-06-26 22:29
 */
public class Section3 {
    @Test
    public void test() {
        String s = "aabb";
        System.out.println(wonderfulSubstrings(s));
    }

    // 模拟
    public long wonderfulSubstrings1(String word) {
        int n = word.length();
        // dp[i]:前i个字符最美非空字符串的数目
        long[] dp = new long[n + 1];
        int[] cnt;
        for (int i = 1; i <= n; i++) {
            cnt = new int[10];
            long delta = 0;
            int temp_i = i - 1;
            while (temp_i >= 0) {
                cnt[word.charAt(temp_i--) - 'a']++;
                if (check(cnt)) delta++;
            }
            dp[i] = dp[i - 1] + delta;
        }
        return dp[n];
    }


    // 状态压缩
    @SuppressWarnings("Duplicates")
    public long wonderfulSubstrings(String word) {
        long res = 0;
        int mask = 0;   // mask 记录前缀和
        long[] freq = new long[1 << 10];    // 记录各前缀和(000...00~111...111)的个数
        freq[0] = 1;    // 初始化000...000为1，这里代表前0个字符没有字符的时候，都是偶数0
        for (char c : word.toCharArray()) {
            int index = c - 'a';
            // 1、计算所有字符出现都是偶数的
            // 如果这个mask前缀和出现过，说明当前i与上一个出现这个mask之间的所有字符出现偶数次，满足最美子字符串
            mask ^= (1 << index);
            // 由于相同前缀和之间的必然是出现偶数和的子字符串，因此不以word[i]结尾计算之前的偶数子字符串，计数+
            res += freq[mask];
            // 2、计算所有字符出现一个奇数的
            for (int i = 0; i < 10; i++) {
                // 希望找到两个前缀和，一个是mask，一个是之前出现的前缀和x
                // 希望两个前缀和的异或结果如果是1<<i，那从x对应的前缀和到当前word[i]之间一定仅有一个位置为1，满足最美子字符串
                // 即 x^mask = 1<<i ==> x = mask ^ (1<<i)，这里也是直接计数满足x出现的频数，表示整体算作一个最美子字符串
                res+=freq[mask^(1<<i)];
            }
            // 这里是对该组合计数
            freq[mask]++;
        }
        return res;
    }

    public boolean check(int[] cnt) {
        int oddNum = 0;
        for (int i = 0; i < 10; i++) {
            if (cnt[i] % 2 == 1) oddNum++;
        }
        return oddNum <= 1;
    }


}
