package dp;

import org.junit.Test;

/**
 * @description:
 * @author: ZMC
 * @email: m18996248458@163.com
 * @create: 2021-02-08 18:10
 */
public class LongestAscSubArray_300 {
    public static void main(String[] args) {
        int[] nums = {10, 9, 2, 5, 3, 7, 101, 18};
        int maxlen = lengthOfLIS(nums);
        System.out.println(maxlen);
    }

    // 单串dp:O(n^2)
    public int lengthOfLIS1(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        // dp[i]:以第i个元素为末尾的子序列的最长递增子序列个数
        int[] dp = new int[nums.length];
        dp[0] = 1;
        int maxlen = 1;
        for (int i = 1; i < nums.length; i++) { //i表示新添加的数
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    //dp[j]+1表示延续之前的最长子序列 dp[i]表示避免在遍历不同j时可能产生伪最长子序列
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            maxlen = Math.max(maxlen, dp[i]);
        }
        return maxlen;
    }

    // 贪心+二分查找:O(nlogn)
    public static int lengthOfLIS(int[] nums) {
        int len = 1, n = nums.length;
        if (n == 0) {
            return 0;
        }
        // d[i]:表示长度为 i 的最长上升子序列的末尾元素的最小值
        int[] d = new int[n + 1];
        d[len] = nums[0];
        for (int i = 1; i < n; ++i) {
            if (nums[i] > d[len]) {
                d[++len] = nums[i];
            } else {
                // 如果找不到说明所有的数都比 nums[i] 大，此时要更新 d[1]，所以这里将 pos 设为 0
                int l = 1, r = len, pos = 0;
                while (l <= r) {
                    int mid = (l + r) >> 1;
                    if (d[mid] < nums[i]) { // 如果通过则说明新的元素可以替换
                        pos = mid;
                        l = mid + 1;
                    } else {
                        r = mid - 1;
                    }
                }
                // 这里是降低了其上升的速度，但其后面比其大的元素不满足子序列的条件（下标比当前新插入的元素小）
                // 只有当新的上升缓慢的元素全部替换后才会将新的子序列生成，len才会+
                d[pos + 1] = nums[i];   //将新的元素放入到对应的位置
            }
        }
        return len;
    }

}
