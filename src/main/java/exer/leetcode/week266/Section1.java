package exer.leetcode.week266;

import org.junit.Test;

/**
 * @description:
 * @author: ZMC
 * @email: m18996248458@163.com
 * @create: 2021-11-07 10:28
 */
public class Section1 {
    @Test
    public void test() {
        System.out.println(countVowelSubstrings("bbaeixoubb"));
    }

    public int countVowelSubstrings(String word) {
        int n = word.length();
        int res = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                boolean[] v = new boolean[26];
                boolean f = true;
                for (int k = i; k <= j; k++) {
                    if (!isValid(word.charAt(k))) {
                        f = false;
                    }
                    v[word.charAt(k) - 'a'] = true;
                }
                if (!f) continue;

                int cnt = 0;
                for (int k = 0; k < 26; k++) {
                    if (v[k] && isValid((char) (k + 'a'))) cnt++;
                }
                if (cnt == 5) res++;
            }
        }
        return res;
    }

    boolean isValid(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }
}
