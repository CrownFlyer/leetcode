package doublePointer;

import org.junit.Test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @description:
 * @author: ZMC
 * @email: m18996248458@163.com
 * @create: 2021-07-23 14:07
 */
public class LEETCODE_424_MIDDLE {

    @Test
    public void test() {
        System.out.println(characterReplacement("AABABBA", 1));
    }

    public int characterReplacement(String s, int k) {
        int n = s.length();
        if (n < 2) return n;
        // 保证[l,r)之间全为相同元素
        int l = 0, r = 0;
        int res = 0;
        int maxCount = 0;
        int[] freq = new int[26];
        while (r < n) {
            char c = s.charAt(r++);
            freq[c - 'A']++;
            maxCount = Math.max(maxCount, freq[c - 'A']);
            // 由于我们要取最长连续的，因此才会选择频数最大的元素
            if (r - l > maxCount + k) freq[s.charAt(l++) - 'A']--;
            res = Math.max(res,r-l);
        }
        return res;
    }

    public int characterReplacement1(String s, int k) {
        Set<Character> set = new HashSet<>();
        int n = s.length();
        for (int i = 0; i < n; i++) {
            set.add(s.charAt(i));
        }

        int max = 0;
        for (Character c : set) {
            // [l,r)之间都为相同的元素
            int l = 0, r = 0;
            int tempK = k;
            while (r < n) {
                if (s.charAt(r) == c) r++;
                else if (tempK == 0) {
                    while (s.charAt(l) == c) l++;
                    l++;
                    tempK++;
                } else {
                    r++;
                    tempK--;
                }

                max = Math.max(max, r - l);
            }
        }
        return max;
    }

}
