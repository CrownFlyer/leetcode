package dp;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @description:
 * @author: ZMC
 * @email: m18996248458@163.com
 * @create: 2021-07-07 09:49
 */
public class LEETCODE_1711_MIDDLE {
    @Test
    public void test() {
        int[] ds = {611, 1437, 29470, 3298, 50, 14, 10, 22, 3, 1, 51, 13, 5872, 26896, 3, 5, 13, 3, 1, 1, 0, 16, 0, 4, 24444, 8324, 10, 502, 4032, 12352, 182, 74, 12863, 3521, 27, 229, 167, 89, 769, 255, 126, 2, 6125, 2067, 70, 16314, 15, 49, 938, 86, 5, 11, 3009, 1087, 2, 62, 5, 3, 579, 1469, 567, 3529, 1, 1, 14, 2, 102, 26, 3570, 4622, 0, 4, 2511, 5681, 64, 0, 744, 1304, 7, 57, 0, 1, 11, 5, 842, 31926, 2591, 5601, 4, 0, 57, 199, 25, 7, 15940, 16828, 1, 0, 251, 261, 1, 31, 51, 13, 4, 0, 2859, 1237, 3667, 4525, 1, 0, 0, 64, 244, 268, 116, 12, 6, 2, 94, 34, 76, 948, 3, 1, 3, 5, 78, 50, 10085, 6299, 1231, 817, 2308, 5884, 43, 21, 1896, 2200, 0, 2, 14, 18, 12, 4, 98, 30, 3, 29, 15350, 1034, 9, 7, 972, 52, 1633, 415, 1, 3, 332, 3764, 4, 0, 0, 1, 1268, 780, 1738, 2358, 2, 0, 9, 7, 78, 50, 0, 1, 1, 0, 2, 0, 740, 1308, 29, 2019, 493, 19, 10, 1014, 95, 33, 232, 24, 133, 123, 7, 1, 907, 117, 311, 201, 4, 4, 279, 233, 59, 453, 88, 168, 1046, 7146, 220, 804, 3, 1, 82, 174, 12172, 4212, 298, 726, 24703, 8065, 14, 18, 2, 0, 2, 0, 14, 2, 354, 158, 1, 1, 1210, 2886, 1011, 13, 905, 119, 1, 1, 342, 682, 12, 52, 25, 7, 2, 6};
        System.out.println(countPairs(ds));
    }


    public int countPairs(int[] deliciousnesss) {
        final int mod = 1000_000_007;

        int max = Integer.MIN_VALUE;
        for (int deliciousness : deliciousnesss) {
            max = Math.max(max, deliciousness);
        }

        int res = 0;
        int maxSum = 2 * max;
        Map<Integer, Integer> map = new HashMap<>();
        for (int deliciousness : deliciousnesss) {
            int count = 0;
            for (int sum = 1; sum <= maxSum; sum <<= 1) {
                count = map.getOrDefault(sum - deliciousness, 0);
                res = (res+count)%mod;
            }
            map.put(deliciousness, map.getOrDefault(deliciousness, 0) + 1);
        }
        return res;
    }


}
