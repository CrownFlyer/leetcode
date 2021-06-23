package greedy;

import org.junit.Test;

/**
 * @description:
 * @author: ZMC
 * @email: m18996248458@163.com
 * @create: 2021-06-22 12:04
 */
public class LEETCODE_1247_MIDDLE {
    @Test
    public void test() {
        String s1 = "xy", s2 = "yx";
        System.out.println(new LEETCODE_1247_MIDDLE().minimumSwap(s1, s2));
    }

    public int minimumSwap(String s1, String s2) {
        int numXY = 0;
        int numYX = 0;
        int n = s1.length();
        for (int i = 0; i < n; i++) {
            if (s1.charAt(i) == s2.charAt(i)) continue;
            else if (s1.charAt(i) == 'x' && s2.charAt(i) == 'y') numXY++;
            else numYX++;
        }

        if ((numYX + numXY) % 2 == 1) return -1;
        return numXY / 2 + numYX / 2 + (numXY % 2) * 2;
    }
}
