package stateCompress;

import java.util.ArrayList;
import java.util.List;

/**
 * @description:状态压缩，用最小的那个数作为状态进行压缩
 * @author: ZMC
 * @email: m18996248458@163.com
 * @create: 2021-08-29 20:07
 */
public class LEETCODE_1434_HARD {

    public int numberWays(List<List<Integer>> hats) {
        final int mod = 1000_000_007;
        int n = hats.size();
        int maxHatId = 0;
        for (List<Integer> list : hats) {
            for (Integer hat : list) {
                maxHatId = Math.max(maxHatId, hat);
            }
        }

        // 记录每顶帽子被哪些人喜欢
        List<List<Integer>> hatsToPersons = new ArrayList<>();
        for (int i = 0; i <= maxHatId; i++) {
            hatsToPersons.add(new ArrayList<>());
        }
        for (int i = 0; i < n; i++) {
            List<Integer> list = hats.get(i);
            for (Integer hat : list) {
                hatsToPersons.get(hat).add(i);
            }
        }

        // dp[i][mask]:处理前i顶帽子，并且已经被分配帽子的人的状态为mask的方案数
        // 这里不涉及重复（同一顶帽子被分配给多人），因为动态规划的遍历就表明了帽子是依次分的
        int[][] dp = new int[maxHatId + 1][1 << n];
        // 边界条件
        dp[0][0] = 1;
        for (int i = 1; i <= maxHatId; i++) {
            for (int mask = 0; mask < (1 << n); mask++) {
                // 第i顶帽子不被任何人选中
                dp[i][mask] = dp[i - 1][mask];
                // 第i顶帽子被选中，然后遍历第i顶帽子可能选中的人
                for (Integer bit : hatsToPersons.get(i)) {
                    if ((mask & (1 << bit)) != 0) { // 第i顶帽子被分配给第bit个人，那该mask掩码中第bit位必须为1
                        dp[i][mask] += dp[i - 1][mask ^ (1 << bit)];
                        dp[i][mask] %= mod;
                    }
                }
            }
        }
        // 最后要的是前maxHatId顶帽子都被分配，且分配状态为全1
        return dp[maxHatId][(1 << n) - 1];
    }
}
