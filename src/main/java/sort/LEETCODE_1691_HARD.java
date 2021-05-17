package sort;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @description:
 * @author: ZMC
 * @email: m18996248458@163.com
 * @create: 2021-04-23 19:45
 */
public class LEETCODE_1691_HARD {
    public static void main(String[] args) {
//        int[][] cuboids = {{50, 45, 20}, {95, 37, 53}, {45, 23, 12}};
        int[][] cuboids = {{10, 15, 20}, {12, 17, 24}, {13, 16, 23}, {14, 15, 26}};
        System.out.println(maxHeight(cuboids));
    }


    // 妙!
    public static int maxHeight(int[][] cuboids) {
        for (int[] cuboid : cuboids) Arrays.sort(cuboid);
        // 对数组进行排序
        Arrays.sort(cuboids, Comparator.<int[]>comparingInt(o -> o[0])
                .thenComparingInt(o -> o[1])
                .thenComparingInt(o -> o[2]));

        int[] dp = new int[cuboids.length]; // dp[i] 表示以第i个长方体为底堆叠的最大高度
        int res = 0;    // 存储最终结果
        for (int i = 0; i < cuboids.length; i++) {
            dp[i] = cuboids[i][2];
            for (int j = 0; j < i; j++)
                if (cuboids[i][1] >= cuboids[j][1] && cuboids[i][2] >= cuboids[j][2])
                    dp[i] = Math.max(dp[i], cuboids[i][2] + dp[j]);
            res = Math.max(dp[i], res);
        }

        return res;
    }


}
