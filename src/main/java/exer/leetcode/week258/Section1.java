package exer.leetcode.week258;

import org.junit.Test;

/**
 * @description:
 * @author: ZMC
 * @email: m18996248458@163.com
 * @create: 2021-09-12 10:27
 */
public class Section1 {
    @Test
    public void test() {

    }

    public String reversePrefix(String word, char ch) {
        int n = word.length();
        char[] chars = word.toCharArray();
        int idx = 0;
        while (idx < n) {
            if (chars[idx++] == ch) break;
        }
        if (chars[idx-1] == ch) {
            int l = 0, r = idx - 1;
            while (l < r) {
                char temp = chars[l];
                chars[l] = chars[r];
                chars[r] = temp;
                l++;
                r--;
            }
        }

        return new String(chars);
    }

}
