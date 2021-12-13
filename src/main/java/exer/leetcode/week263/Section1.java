package exer.leetcode.week263;

import org.junit.Test;


/**
 * @description:
 * @author: ZMC
 * @email: m18996248458@163.com
 * @create: 2021-10-17 10:22
 */
public class Section1 {
    @Test
    public void test() {
        String s = "1 box has 3 blue 4 red 6 green and 12 yellow marbles";
        System.out.println(areNumbersAscending(s));
    }

    public boolean areNumbersAscending(String s) {
        int n = s.length();
        int i = 0;
        int last = -1;
        while (i < n) {
            int cur = 0;
            boolean f = false;
            while (i<n && s.charAt(i) >= '0' && s.charAt(i) <= '9') {
                if (!f) f = true;
                cur = cur * 10 + s.charAt(i) - '0';
                i++;
            }
            if (f) {
                if (cur <= last) return false;
                last = cur;
            } else i++;

        }
        return true;
    }

}
