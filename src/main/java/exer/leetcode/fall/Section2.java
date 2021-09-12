package exer.leetcode.fall;

import org.junit.Test;

import java.util.Arrays;

/**
 * @description:
 * @author: ZMC
 * @email: m18996248458@163.com
 * @create: 2021-09-11 14:14
 */
public class Section2 {
    @Test
    public void test() {
        int[] cs = {3,3,1};
        System.out.println(maxmiumScore(cs, 1));
    }

    public int maxmiumScore(int[] cards, int cnt) {
        int n = cards.length;
        Arrays.sort(cards);
        int res = 0;
        int idx = n - 1;
        while (cnt > 0) {
            res += cards[idx--];
            cnt--;
        }
        if (res % 2 == 0) return res;
        int lastEven = idx + 1;
        int lastOdd = idx + 1;
        while (lastEven < n && cards[lastEven] % 2 != 0) lastEven++;
        while (lastOdd < n && cards[lastOdd] % 2 != 1) lastOdd++;

        int replaceOdd = idx;
        if (lastEven != n) {
            while (replaceOdd >= 0 && cards[replaceOdd] % 2 == 0) replaceOdd--;
        }
        int res1 = 0;
        if (lastEven != n && replaceOdd != -1) res1 = res - cards[lastEven] + cards[replaceOdd];

        int replaceEven = idx;
        if (lastOdd != n) {
            while (replaceEven >= 0 && cards[replaceEven] % 2 == 1) replaceEven--;
        }
        int res2 = 0;
        if (lastOdd != n && replaceEven != -1) res2 = res - cards[lastOdd] + cards[replaceEven];
        return Math.max(res1, res2);
    }
}
