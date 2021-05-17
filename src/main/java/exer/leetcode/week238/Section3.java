package exer.leetcode.week238;

import java.util.LinkedHashMap;
import java.util.LinkedHashSet;

/**
 * @description:
 * @author: ZMC
 * @email: m18996248458@163.com
 * @create: 2021-04-25 12:46
 */
public class Section3 {
    public static void main(String[] args) {
        System.out.println(longestBeautifulSubstring(""));
    }

    public static int longestBeautifulSubstring(String word) {
        int res = 0;
        int max = 0;
        char[] metas = {'a', 'e', 'i', 'o', 'u'};
        int cur = 0, needed = 0;
        for (int i = 0; i < word.length(); i++) {
            if (needed < 5 && word.charAt(i) == metas[needed]) {    // 前进 aei
                cur = needed++;
                if (cur == 0) {
                    res = i;
                }
                if (cur == 4) {
                    res = i - res + 1;
                    int temp = i + 1;
                    while (temp < word.length() && word.charAt(temp++) == 'u') res++;
                    max = Math.max(max, res);
                }
            } else if (word.charAt(i) == metas[cur]) {    // 重复 aee
            } else {    // 倒退 aeia
                if (word.charAt(i) == 'a') {
                    res = i;
                    cur = 0;
                    needed = 1;
                    continue;
                }
                cur = 0;
                needed = 0;
            }
        }

        return max;
    }

    public static boolean isMeta(char ch) {
        return ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u';
    }

}
