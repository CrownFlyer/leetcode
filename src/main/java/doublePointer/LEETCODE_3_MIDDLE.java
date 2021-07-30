package doublePointer;

import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

/**
 * @description:
 * @author: ZMC
 * @email: m18996248458@163.com
 * @create: 2021-07-23 15:03
 */
public class LEETCODE_3_MIDDLE {
    @Test
    public void test() {
        System.out.println(lengthOfLongestSubstring("tmmzuxt"));
    }

    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        int max = 0;
        // 保证[l,r)之间无重复字符
        int l = 0, r = 0;
        Set<Character> set = new HashSet<>();
        while (r < n) {
            char c = s.charAt(r++);
            if (!set.contains(c)) set.add(c);
            else {
                while (s.charAt(l) != c) {
                    set.remove(s.charAt(l));
                    l++;
                }
                l++;
            }
            max = Math.max(max, r - l);
        }
        return max;

    }
}
