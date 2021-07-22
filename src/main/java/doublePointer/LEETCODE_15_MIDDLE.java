package doublePointer;

import org.junit.Test;

import java.util.*;

/**
 * @description:
 * @author: ZMC
 * @email: m18996248458@163.com
 * @create: 2021-07-17 16:20
 */
public class LEETCODE_15_MIDDLE {
    @Test
    public void test() {
        int[] nums = {-2, 0, 1, 1, 2};
        System.out.println(threeSum(nums));
    }

    public List<List<Integer>> threeSum(int[] nums) {
        return helper(nums, 0);
    }

    public List<List<Integer>> helper(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        int n = nums.length;
        if (n < 3) return res;

        Arrays.sort(nums);
        for (int i = 0; i < n - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            int l = i + 1, r = n - 1;
            while (l < r) {
                int temp = nums[i] + nums[l] + nums[r];
                if (temp == target) {
                    res.add(Arrays.asList(nums[i],nums[l],nums[r]));
                    while(l<r&&nums[l]==nums[l+1]) l++;
                    while(l<r&&nums[r]==nums[r-1]) r--;
                    l++;
                    r--;
                } else if (temp < target) l++;
                else r--;
            }
        }

        return res;
    }
}
