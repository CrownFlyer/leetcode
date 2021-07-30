package doublePointer;

import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

/**
 * @description:
 * @author: ZMC
 * @email: m18996248458@163.com
 * @create: 2021-07-27 14:51
 */
public class LEETCODE_1100_MIDDLE {
    @Test
    public void test() {
        String s = "havefunonleetcode";
        System.out.println(numKLenSubstrNoRepeats(s, 5));
    }

    public int numKLenSubstrNoRepeats(String s, int k) {
        int[] cnt = new int[26];
        int n = s.length();
        int res = 0;
        if (n < k) return 0;
        int l = 0, r = k;
        for (int i = l; i < r; i++) {
            cnt[s.charAt(i) - 'a']++;
        }
        if (check(cnt, k)) res++;
        while (r < n) {
            cnt[s.charAt(l++) - 'a']--;
            cnt[s.charAt(r++) - 'a']++;
            if (check(cnt, k)) res++;
        }
        return res;
    }

    public boolean check(int[] cnt, int k) {
        int res = 0;
        for (int i = 0; i < 26; i++) {
            if (cnt[i] > 0) res++;
        }
        return res == k;
    }
}
