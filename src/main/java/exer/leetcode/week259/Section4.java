package exer.leetcode.week259;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @description:
 * @author: ZMC
 * @email: m18996248458@163.com
 * @create: 2021-09-19 15:49
 */
public class Section4 {
    // 枚举 + BFS剪枝
    public String longestSubsequenceRepeatedK(String s, int k) {
        String res = "";
        Queue<String> q = new LinkedList<>();
        q.add("");
        while (!q.isEmpty()) {
            int size = q.size();
            // BFS
            while (size-- > 0) {
                String cur = q.poll();
                // 字母升序，保证了同等长度取字典序大的
                // 子串的长度最长为7，所以为26^7次判断isSub
                // 在大多数情况下，子串判断并不满足，q只存在很少的一部分
                for (int i = 0; i < 26; i++) {
                    String next = cur + (char) ('a' + i);
                    if (isSub(s, next, k)) {
                        res = next;
                        q.add(next);
                    }
                }
            }
        }
        return res;
    }

    // 判断 sub * k是否是s的子串
    // O(n):n = s.length()
    private boolean isSub(String s, String sub, int k) {
        int i = 0;
        int sLen = s.length(), subLen = sub.length();
        int curIndex = 0, curTimes = 0;
        while (i < sLen && curTimes < k) {
            if (s.charAt(i++) == sub.charAt(curIndex)) curIndex++;
            if (curIndex == subLen) {
                curTimes++;
                curIndex = 0;
            }
        }
        return curTimes == k;
    }
}
