package backtrack;

import javafx.util.Pair;
import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @description:
 * @author: ZMC
 * @email: m18996248458@163.com
 * @create: 2021-09-25 10:11
 */
public class LEETCODE_473_MIDDLE {
    @Test
    public void test() {
        int[] ms = {1, 2, 2, 3, 4, 4};
        System.out.println(makesquare(ms));
    }

    // dfs:对于ms中的每个元素，都有4种存放可能，时间复杂度为O(4^n)
    public boolean makesquare2(int[] matchsticks) {
        int sum = Arrays.stream(matchsticks).sum();
        if (sum % 4 != 0) return false;
        int line = sum / 4;

        return dfs(0, matchsticks, line, new int[4]);
    }


    public boolean dfs(int idx, int[] ms, int line, int[] sums) {
        if (idx == ms.length)
            return sums[0] == sums[1] && sums[1] == sums[2] && sums[2] == sums[3];
        for (int i = 0; i < 4; i++) {
            if (sums[i] + ms[idx] <= line) {
                sums[i] += ms[idx];
                if (dfs(idx + 1, ms, line, sums)) return true;
                sums[i] -= ms[idx];
            }
        }
        return false;
    }

    // 记忆化搜索+dp+状态压缩
    Map<Pair<Integer, Integer>, Boolean> memo = new HashMap<>();

    public boolean makesquare(int[] nums) {
        int sum = Arrays.stream(nums).sum();
        if (sum % 4 != 0) return false;
        int line = sum / 4;

        return backtrace(nums, (1 << nums.length) - 1, 0, line);
    }

    // mask二进制位为0，表示选中，为1表示未选中
    // 由于每个元素只有两种状态，由记忆化搜索缩短时间复杂度为O(n*2^n)
    // 由于side是放在递归状态中的，backtrace返回以当前状态为mask，且状态为side的满足火柴的可能
    private boolean backtrace(int[] nums, int mask, int side, int line) {
        int sum = 0, n = nums.length;
        Pair<Integer, Integer> memoKey = new Pair<>(mask, side);
        for (int i = n - 1; i >= 0; i--) {
            if ((mask & (1 << i)) == 0) {
                sum += nums[n - 1 - i];
            }
        }
        // 这里就限制了火柴的可行性
        if (sum > 0 && sum % line == 0) side++;
        // 这里等于边数确定3边后，最后剩下的和肯定有效，由一开始的取余保证
        if (side == 3) return true;

        if (memo.containsKey(memoKey))
            return memo.get(memoKey);

        boolean res = false;
        // 距离再凑齐一个side的长度
        int rem = line * (sum / line + 1) - sum;

        // 在限制火柴可行性的同时再继续递归
        for (int i = n - 1; i >= 0; i--) {
            // 递归还未选中的
            if (nums[n - 1 - i] <= rem && (mask & (1 << i)) != 0)
                // 这里取异或是只改变未选中的一位
                if (backtrace(nums, mask ^ (1 << i), side, line)) {
                    res = true;
                    break;
                }
        }
        memo.put(memoKey, res);
        return res;
    }
}
