package exer.leetcode.week261;

import org.junit.Test;

import java.util.Arrays;

/**
 * @description:
 * @author: ZMC
 * @email: m18996248458@163.com
 * @create: 2021-10-03 12:13
 */
public class Section2 {
    @Test
    public void test() {

    }

    public int[] missingRolls(int[] rolls, int mean, int n) {
        int m = rolls.length;
        int total = mean * (n + m);
        int remain = total - Arrays.stream(rolls).sum();
        int elseMean = remain / n;
        if (elseMean > 6 || (elseMean == 6 && remain - elseMean * n > 0)
                || elseMean < 1) return new int[0];
        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            res[i] = elseMean;
            remain -= elseMean;
        }

        int idx = 0;
        while (remain > 0) {
            res[idx++]++;
            remain--;
        }

        return res;
    }
}
