package exer.leetcode.week262;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @description:
 * @author: ZMC
 * @email: m18996248458@163.com
 * @create: 2021-10-10 10:24
 */
public class Section4 {
    @Test
    public void test() {
        int[] nums = {2, -1, 0, 4, -2, -9};
        System.out.println(minimumDifference(nums));

    }

    // O(2^n)：由于n<=15->2^15超时
    public int minimumDifference1(int[] nums) {
        int n = nums.length;
        int min = Integer.MAX_VALUE;
        for (int j = 0; j < (1 << n); j++) {
            int l = 0, r = 0;
            int cnt = 0;
            int i = j;
            if (Integer.bitCount(i) * 2 != n) continue;
            while (cnt < n) {
                if ((i & 1) == 1) l += nums[cnt];
                else r += nums[cnt];
                i >>= 1;
                cnt++;
            }
            min = Math.min(min, Math.abs(l - r));
        }
        return min;
    }


    int min = Integer.MAX_VALUE;

    public int minimumDifference2(int[] nums) {
        int n = nums.length;

        boolean[] mask = new boolean[n];
        int need = n / 2;
        dfs(0, need, need, mask, nums);
        return min;
    }


    public void dfs(int cur, int need, int nextNeed, boolean[] mask, int[] nums) {
        if (nums.length - cur < nextNeed) return;
        if (nextNeed == 0) {
            int l = 0, r = 0;
            for (int i = 0; i < mask.length; i++) {
                if (mask[i]) l += nums[i];
                else r += nums[i];
            }
            min = Math.min(min, Math.abs(l - r));
            return;
        }
        dfs(cur + 1, need, nextNeed, mask, nums);
        mask[cur] = true;
        for (int i = cur + 1; i <= nums.length; i++) {
            dfs(i, need, nextNeed - 1, mask, nums);
        }
        mask[cur] = false;
    }

    // 折半搜索 由于折半之后 n <= 8 -> O(n2^n)
    public int minimumDifference(int[] nums) {
        int n = nums.length / 2, res = Integer.MAX_VALUE;

        // v1[i]：前n个数选中i个数为正，n-i个数为负的和 的所有组合
        List<Integer>[] v1 = new ArrayList[n + 1];
        // v2[i]：后n个数选中i个数为正，n-i个数为负的和 的所有组合
        List<Integer>[] v2 = new ArrayList[n + 1];
        for (int i = 0; i < n + 1; i++) {
            v1[i] = new ArrayList<>();
            v2[i] = new ArrayList<>();
        }
        for (int i = 0; i < (1 << n); i++) {
            int cur = 0, cnt = 0;
            for (int j = 0; j < n; j++) {
                if ((i & (1 << j)) != 0) {
                    cur += nums[j];
                    cnt++;
                } else cur -= nums[j];
            }
            v1[cnt].add(cur);
        }

        for (int i = 0; i < (1 << n); i++) {
            int cur = 0, cnt = 0;
            for (int j = 0; j < n; j++) {
                if ((i & (1 << j)) != 0) {
                    cur += nums[n + j];
                    cnt++;
                } else cur -= nums[n + j];
            }
            v2[cnt].add(cur);
        }

        for (int i = 0; i <= n; i++) {
            // 前面选中i个，后面必须选中n-i个
            Collections.sort(v1[i]);
            Collections.sort(v2[n - i]);
            for (int j = 0, k = v2[n - i].size() - 1; j < v1[i].size(); j++) {
                while (k >= 0 && v1[i].get(j) + v2[n - i].get(k) >= 0) k--;
                // 找到负数里最大的
                if (k >= 0) res = Math.min(res, -v1[i].get(j) - v2[n - i].get(k));
                // 或者正数里最小的
                if (k + 1 < v2[n - i].size()) res = Math.min(res, v1[i].get(j) + v2[n - i].get(k + 1));
            }
        }
        return res;
    }


}
