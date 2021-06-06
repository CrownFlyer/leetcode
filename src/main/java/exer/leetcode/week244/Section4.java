package exer.leetcode.week244;

import java.util.Arrays;
import java.util.HashSet;
import java.util.TreeSet;

/**
 * @description:
 * @author: ZMC
 * @email: m18996248458@163.com
 * @create: 2021-05-30 09:49
 */
public class Section4 {
    public static void main(String[] args) {
        Section4 test = new Section4();
        int p[] = {2, 3, 5};
        int b[][] = {{4, 8}, {2, 8}};
        System.out.println(test.minWastedSpace(p, b));

    }

    // 暴力O(n*m)
    public int minWastedSpace1(int[] packages, int[][] boxes) {
        long mod = 1000_000_007;
        int n = boxes.length;
        boolean[] valid = new boolean[n];
        long rest[] = new long[n];

        int maxP = Arrays.stream(packages).max().getAsInt();
        Arrays.sort(packages);

        TreeSet<Integer> set = new TreeSet<>();
        for (int i = 0; i < n; i++) {
            int maxB = Arrays.stream(boxes[i]).max().getAsInt();
            if (maxB < maxP) {
                valid[i] = true;
                continue;
            }
            int m = boxes[i].length;
            for (int j = 0; j < m; j++) {
                set.add(boxes[i][j]);
            }

            int len = packages.length;
            for (int j = 0; j < len; j++) {
                int ceil = set.ceiling(packages[j]);
                rest[i] += ceil - packages[j];
            }

            set.clear();
        }
        for (int i = 0; i < n; i++) {
            if (valid[i]) rest[i] = Integer.MAX_VALUE;
        }
        long min = Arrays.stream(rest).min().getAsLong();
        for (int i = 0; i < n; i++) {
            if (!valid[i] && rest[i] == min) return (int) (rest[i] % mod);
        }
        return -1;
    }

    public int minWastedSpace(int[] packages, int[][] boxes) {
        int n = packages.length;
        Arrays.sort(packages);

        int[] pre = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            pre[i] = pre[i - 1] + packages[i - 1];
        }

        long res = Long.MAX_VALUE;
        for (int[] box : boxes) {
            Arrays.sort(box);

            if (box[box.length - 1] < packages[packages.length - 1]) continue;

            int pt = 0;
            long total = 0L;

            for (int e : box) {
                if (e < packages[pt]) continue;
                // 下面寻找e可以装下的所有packages
                int pt_next = bs(packages, e, pt);

                total += (pt_next - pt) * e - (pre[pt_next] - pre[pt]);
                pt = pt_next;

                if (pt == packages.length) break;
            }
            res = Math.min(res, total);
        }
        return res == Long.MAX_VALUE ? -1 : (int) (res % 1000_000_007);
    }

    public int bs(int[] nums, int target, int start) {
        int n = nums.length;
        int l = start, r = n - 1;
        int res = n;
        if (l == r) return n;
        while (l <= r) {
            int m = (l + r) >> 1;
            if (nums[m] > target) {
                r = m - 1;
                res = m;
            } else l = m + 1;
        }
        return res;
    }
}
