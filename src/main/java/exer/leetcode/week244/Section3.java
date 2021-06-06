package exer.leetcode.week244;

import sun.security.util.Length;

import java.util.*;

/**
 * @description:
 * @author: ZMC
 * @email: m18996248458@163.com
 * @create: 2021-05-30 09:49
 */
public class Section3 {
    public static void main(String[] args) {
        Section3 test = new Section3();
        String s = "11000";
        System.out.println(test.minFlips(s));
    }

    public int minFlips(String s) {
        int n = s.length();
        char[] t = new char[2 * n];
        char[] a = new char[2 * n];
        char[] b = new char[2 * n];
        int da = 0, db = 0;
        for (int i = 0; i < n; i++) {
            a[2 * i] = '0';
            b[2 * i] = '1';
            a[2 * i + 1] = '1';
            b[2 * i + 1] = '0';
            t[i] = s.charAt(i);
            t[i + n] = s.charAt(i);
        }

        int min = n;
        for (int i = 0; i < 2 * n; i++) {
            // 对于每个数都正常+
            if (t[i] != a[i]) da += 1;
            if (t[i] != b[i]) db += 1;

            if (i >= n) {
                // 如果计算到后n个元素时，前面如果计算为不同导致多加的需要减掉
                if (t[i - n] != a[i - n]) da -= 1;
                if (t[i - n] != b[i - n]) db -= 1;
            }
            if (i >= n - 1) min = Math.min(min, Math.min(da, db));
        }
        return min;
    }

    public int minFlips1(String s) {
        int n = s.length();
        String target = "01";

        int cnt = 0;
        for (int i = 0; i < n; i++) {
            cnt += (s.charAt(i) != target.charAt(i % 2)) ? 1 : 0;
        }
        // 其中n-cnt代表"10"
        int min = Math.min(cnt, n - cnt);
        for (int i = 0; i < n; i++) {
            cnt -= (s.charAt(i) != target.charAt(i % 2)) ? 1 : 0;
            cnt += (s.charAt(i) != target.charAt((i + n) % 2)) ? 1 : 0;
            min = Math.min(min, Math.min(cnt, n - cnt));
        }
        return min;
    }


}
