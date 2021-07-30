package doublePointer;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @description:
 * @author: ZMC
 * @email: m18996248458@163.com
 * @create: 2021-07-24 10:53
 */
public class LEETCODE_567_MIDDLE {
    @Test
    public void test() {
        String s = "ab";
        String p = "eidboaoo";
        System.out.println(checkInclusion(s, p));
    }
    public boolean checkInclusion(String s2, String s1) {
        int[] cur = new int[26];
        int[] target = new int[26];
        int len1 = s1.length();
        int len2 = s2.length();

        if (len1 < len2) return false;
        for (int i = 0; i < len2; i++) {
            target[s2.charAt(i) - 'a']++;
        }

        int l = 0, r;
        for (r = 0; r < len2 - 1; r++) {
            cur[s1.charAt(r) - 'a']++;
        }
        while (r < len1) {
            cur[s1.charAt(r++) - 'a']++;
            if (check(cur, target)) return true;
            cur[s1.charAt(l++) - 'a']--;
        }
        return false;
    }

    public boolean check(int[] cur, int[] target) {
        for (int i = 0; i < 26; i++) {
            if (cur[i] != target[i]) return false;
        }
        return true;
    }
}
