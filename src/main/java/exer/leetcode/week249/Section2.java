package exer.leetcode.week249;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;

/**
 * @description:
 * @author: ZMC
 * @email: m18996248458@163.com
 * @create: 2021-09-20 15:54
 */
public class Section2 {
    @Test
    public void test() {
        String s = "aabca";
        System.out.println(countPalindromicSubsequence2(s));
    }

    // O(n^2logn):超时
    public int countPalindromicSubsequence(String s) {
        int n = s.length();
        HashSet<Integer> set = new HashSet<>();
        for (int l = 0; l < n - 2; l++) {
            int r = n - 1;
            while (l < r && s.charAt(r) != s.charAt(l)) r--;
            for (int i = l + 1; i < r; i++) {
                set.add(hash(s.charAt(l), s.charAt(i)));
            }
        }
        return set.size();
    }

    public int hash(char x, char y) {
        return (x - 'a') * 26 + y - 'a';
    }

    // 前缀和 O(n)
    public int countPalindromicSubsequence2(String s) {
        int n = s.length();
        // cnt[i][j]:s的前i个字符包含的字符j+'a'的数量
        int[][] cnt = new int[n + 1][26];
        int[] first = new int[26];
        int[] last = new int[26];
        Arrays.fill(first, -1);
        Arrays.fill(last, -1);
        for (int i = 1; i <= n; i++) {
            int idx = s.charAt(i - 1) - 'a';
            for (int j = 0; j < 26; j++) {
                cnt[i][j] = cnt[i - 1][j];
            }
            cnt[i][idx]++;
            if (cnt[i][idx] == 1) first[idx] = i - 1;
            last[idx] = i - 1;
        }

        int res = 0;
        for (int i = 0; i < 26; i++) {
            if (last[i] > first[i] && first[i] != -1) {
                for (int j = 0; j < 26; j++) {
                    if (cnt[last[i]][j] - cnt[first[i] + 1][j] != 0)
                        res++;
                }
            }
        }
        return res;
    }

    // 暴力 O(n)
    public int countPalindromicSubsequence3(String s) {
        char[] chars = s.toCharArray();
        int n = chars.length;

        int res = 0;
        for (int i = 0; i < 26; i++) {
            char c = (char) (i + 'a');
            int l = 0, r = n - 1;
            while (l < n && chars[l] != c) l++;
            while (r > l && chars[r] != c) r--;

            if (r - l >= 2) {
                HashSet<Character> set = new HashSet<>();
                for (int j = l + 1; j < r; j++) {
                    set.add(chars[j]);
                }
                res += set.size();
            }
        }
        return res;
    }
}
