package exer.leetcode.week274;

import org.junit.Test;

import java.util.*;

/**
 * @description:
 * @author: ZMC
 * @email: m18996248458@163.com
 * @create: 2022-01-02 10:29
 */
public class Solution1 {
    @Test
    public void test() {
    }

    public boolean checkString(String s) {
        int b = 0, n = s.length(), a = n - 1;
        while (a >= 0 && s.charAt(a) != 'a') a--;
        while (b < n && s.charAt(b) != 'b') b++;
        return a < b;
    }

}
