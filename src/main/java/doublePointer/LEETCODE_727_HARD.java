package doublePointer;

import org.junit.Test;

/**
 * @description:
 * @author: ZMC
 * @email: m18996248458@163.com
 * @create: 2021-07-27 09:16
 */
public class LEETCODE_727_HARD {
    @Test
    public void test() {
        String s1 = "abcdebdde";
        String s2 = "bde";
        System.out.println(minWindow(s1, s2));
    }

    public String minWindow(String s, String t) {
        int sPtr = 0, tPtr = 0;
        int sLen = s.length(), tLen = t.length();
        int minLen = Integer.MAX_VALUE;
        String res = "";
        while (sPtr < sLen) {
            if (s.charAt(sPtr) == t.charAt(tPtr)) tPtr++;
            // 匹配到所有t的字符的右边界
            if (tPtr == tLen) {
                // 记录此时sPtr的位置，即右边界位置
                int R = sPtr;
                // 逆向匹配到s的左边界
                while (tPtr > 0) {
                    if (s.charAt(sPtr) == t.charAt(tPtr - 1)) tPtr--;
                    sPtr--;
                }
                // 由于sPtr会减到第一个字符的前一个位置，此处应加1使下标到第一个字符
                sPtr++;
                // [sPtr,R] -> len = R-sPtr+1
                if (R - sPtr + 1 < minLen) {
                    minLen = R - sPtr + 1;
                    res = s.substring(sPtr, R + 1);
                }
            }
            sPtr++;
        }
        return res;
    }

    // 滑动窗口，判断待优化
    public String minWindow1(String s1, String s2) {
        char[] s1char = s1.toCharArray();
        char[] s2char = s2.toCharArray();
        String res = "";
        int s1Len = s1.length();
        int s2Len = s2.length();
        if (s1Len < s2Len) return res;

        int minLen = Integer.MAX_VALUE;
        int l = 0, r = 0;
        while (r < s1Len) {
            while (check(s1char, l, r, s2char, 0, s2Len - 1)) {
                l++;
                if (r - l + 1 < minLen) {
                    res = s1.substring(l - 1, r + 1);
                    minLen = r - l + 1;
                }
            }
            r++;
        }
        return res;
    }

    public boolean check(char[] s, int sl, int sr, char[] t, int tl, int tr) {
        if (sr - sl < tr - tl) return false;
        int sIndex = sl;
        int tIndex = tl;
        // check的是[sl,sr] 和 [tl,tr]
        while (sIndex <= sr && tIndex <= tr) {
            if (s[sIndex] == t[tIndex]) tIndex++;
            sIndex++;
        }
        return tIndex > tr;
    }
}
