package exer.leetcode.week272;

import java.util.ArrayList;
import java.util.List;

/**
 * @description:
 * @author: ZMC
 * @email: m18996248458@163.com
 * @create: 2021-12-19 11:49
 */
public class Solution3 {
    public long getDescentPeriods(int[] prices) {
        int n = prices.length;
        long res = 0L;
        for (int l = 0; l < n; ) {
            int r = l + 1;
            while (r < n && prices[r] == prices[l] - (r - l)) {
                r++;
            }
            res += (long) (r - l + 1) * (r - l) / 2;
            l = r;
        }

        return res;
    }
}
