package exer.leetcode.week276;

import java.util.Arrays;

/**
 * @description:
 * @author: ZMC
 * @email: m18996248458@163.com
 * @create: 2022-01-16 12:21
 */
public class Solution4 {
    // 排序+木桶效应
    public long maxRunTime(int n, int[] batteries) {
        int m = batteries.length;
        Arrays.sort(batteries);
        long sum = 0L;
        for (int i = 0; i < m; i++) sum += batteries[i];
        for (int i = batteries.length - 1; i >= 0; i--) {
            // sum/n: 电池电量所能支持的最大同时运行时间
            // 如果电池比该电量都大（其不是最大同时运行时间的限制），则默认该电池一直给同一台电脑供电
            // 此决策的递归思路应该是如何分配最大电量的电池！！！
            /*
             * 解释
             * 如果一组数的最大值都小于等于平均值，只有一下两种情况
             * 1.他们的值都相同
             * 2.他们的个数比n个，且分得更细致，因此可以保证其平均值可以取到
             * 如 n = 3, 1 1 2 2 -> 2
             * */
            if (batteries[i] > sum / n) {
                n--;
                sum -= batteries[i];
            }
            // 如果有电池不支持最大运行时间，则表示
            else return sum / n;
        }
        return 0;
    }

    // 二分
    public long maxRunTime2(int n, int[] batteries) {
        // 假设目标天数为k，则每块电池最多用k天，即每天供给一单位电能
        // 想成k个队列，这样保证了单块电池不会出现在同一队列两次（即在同一天用两次）
        // 总的电量总和为 nk
        long l = 1, r = (long) 10e13;
        while (l < r) {
            long m = (l + r + 1) / 2;
            if (check(m, batteries, n)) l = m;
            else r = m - 1;
        }
        return l;
    }

    boolean check(long k, int[] batteries, int n) {
        long sum = 0;
        for (int i = 0; i < batteries.length; i++) {
            sum += Math.min(k, batteries[i]);
        }
        return sum >= n * k;
    }
}
