package exer.leetcode.week249;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @description:
 * @author: ZMC
 * @email: m18996248458@163.com
 * @create: 2021-09-20 15:54
 */
public class Section3 {
    @Test
    public void test() {
        System.out.println(colorTheGrid(5, 5));
    }

    public int colorTheGrid(int m, int n) {
        final int mod = 1000_000_007;
        // <k,v>:<valid mask,mask -> 3 radix number>
        HashMap<Integer, int[]> map = new HashMap<>();

        int maskEnd = (int) (Math.pow(3, m));
        for (int mask = 0; mask < maskEnd; mask++) {
            int[] color = new int[m];
            int temp = mask;
            boolean check = true;
            for (int i = 0; i < m; i++) {
                color[i] = temp % 3;
                if (i > 0 && color[i] == color[i - 1]) check = false;
                temp /= 3;
            }
            if (check) map.put(mask, color);
        }

        // <k,v>:<mask,valid neighbors with mask>
        HashMap<Integer, List<Integer>> adjacent = new HashMap<>();
        for (Integer mask1 : map.keySet()) {
            List<Integer> list = new ArrayList<>();
            for (Integer mask2 : map.keySet()) {
                boolean check = true;
                for (int i = 0; i < m; i++) {
                    if (map.get(mask1)[i] == map.get(mask2)[i]) {
                        check = false;
                        break;
                    }
                }
                if (check) list.add(mask2);
            }
            adjacent.put(mask1, list);
        }

        // dp[i][mask]:对第0，1，...,i进行了涂色，并且第i行的涂色方案对应的三进制表示为mask的前提下的总方案数
        // 最终答案即为所有满足mask的和
        // 由于dp[i][mask] 仅与 dp[i-1][mask]有关，因此采用一维滚动数组
        int[] dp = new int[maskEnd];

        for (Integer mask : map.keySet()) {
            dp[mask] = 1;
        }

        for (int i = 1; i < n; i++) {
            int[] temp = new int[maskEnd];
            for (Integer mask : map.keySet()) {
                for (Integer mask2 : adjacent.get(mask)) {
                    temp[mask] += dp[mask2];
                    temp[mask] %= mod;
                }
            }
            dp = temp;
        }

        int res = 0;
        for (int i = 0; i < maskEnd; i++) {
            res += dp[i];
            res %= mod;
        }
        return res;
    }


}
