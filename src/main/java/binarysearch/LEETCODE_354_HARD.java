package binarysearch;

import com.sun.org.apache.xml.internal.serializer.ElemDesc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @description:
 * @author: ZMC
 * @email: m18996248458@163.com
 * @create: 2021-05-27 09:29
 */
public class LEETCODE_354_HARD {
    public static void main(String[] args) {
        int[][] env = {{1, 0}, {2, 2}, {2, 3}, {2, 4}, {2, 5}, {3, 3}, {4, 1},{5,2}};
//        System.out.println(maxEnvelopes(env));

        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(3);
        list.add(5);
        list.add(6);
        System.out.println(binarySearch(list, 3));
    }

    // dp
    // O(n^2)
    public static int maxEnvelopes1(int[][] envelopes) {
        int n = envelopes.length;
        if (n == 0) return 0;

        Arrays.sort(envelopes, (o1, o2) -> {
            if (o1[0] != o2[0]) return o1[0] - o2[0];   // 第一关键词升序，保证了遍历比较时，第一关键词的可放入性
            else return o2[1] - o1[1];  // 第一关键词相同时，由于放入条件是严格大于才行，这里降序就保证了完全筛选出这一部分，妙！
        });

        // 设 f[i] 表示 h 的前 i 个元素可以组成的最长严格递增子序列的长度，并且我们必须选择第 i 个元素 h
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        int ans = 1;
        for (int i = 1; i < n; ++i) {
            for (int j = 0; j < i; ++j) {
                if (envelopes[j][1] < envelopes[i][1]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            ans = Math.max(ans, dp[i]);
        }
        return ans;
    }

    // dp + 贪心
    public static int maxEnvelopes(int[][] envelopes) {
        int n = envelopes.length;
        if (n == 0) return 0;

        Arrays.sort(envelopes, (o1, o2) -> {
            if (o1[0] != o2[0]) return o1[0] - o2[0];   // 第一关键词升序，保证了遍历比较时，第一关键词的可放入性
            else return o2[1] - o1[1];  // 第一关键词相同时，由于放入条件是严格大于才行，这里降序就保证了完全筛选出这一部分，妙！
        });

        // 设 f[j] 表示 h 的前 i 个元素可以组成的长度为 j 的最长严格递增子序列的第二个关键词的最小值
        List<Integer> dp = new ArrayList<>();
        dp.add(envelopes[0][1]);
        for (int i = 1; i < n; ++i) {
            int num = envelopes[i][1];
            if (num > dp.get(dp.size() - 1)) {
                dp.add(num);
            } else {
                int index = binarySearch(dp, num);
                dp.set(index, num);
            }
        }
        return dp.size();
    }

    public static int binarySearch(List<Integer> f, int target) {
        int l = 0, r = f.size() - 1;
        // 可以这样理解，找一个不大于target的值，当条件成立的时候，l向右移，左边往里缩，反之，不成立的时候，r往左缩，直到l=r，找到小于等于target最大的值
        while (l < r) {
            int m = (l + r) >> 1;
            if (f.get(m) < target) l = m + 1;
            else r = m; // 取等号的时候包含进来了，所以能取到=target的值
        }
        return l;
    }

}
