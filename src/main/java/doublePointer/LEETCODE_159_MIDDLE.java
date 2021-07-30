package doublePointer;

import org.junit.Test;

/**
 * @description:
 * @author: ZMC
 * @email: m18996248458@163.com
 * @create: 2021-07-28 10:07
 */
public class LEETCODE_159_MIDDLE {
    @Test
    public void test() {
        String s = "eceba";
        System.out.println(lengthOfLongestSubstringTwoDistinct(s));
    }

    public int lengthOfLongestSubstringTwoDistinct(String s) {
        int n = s.length();
        // 保证[l,r)之间为有效的
        int l = 0, r = 0;
        int[] cnt = new int[128];
        // 优化判断条件，记录字符种类数
        int count = 0;
        int max = 0;
        while (r < n) {
            cnt[s.charAt(r)]++;
            if (cnt[s.charAt(r++)] == 1) count++;
            while (count > 2) {
                cnt[s.charAt(l)]--;
                if (cnt[s.charAt(l++)] == 0) count--;
            }
            max = Math.max(max, r - l);
        }
        return max;
    }


}
