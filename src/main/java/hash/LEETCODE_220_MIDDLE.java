package hash;

import org.junit.Test;

import java.util.Arrays;
import java.util.TreeSet;

/**
 * @description:
 * @author: ZMC
 * @email: m18996248458@163.com
 * @create: 2021-07-31 16:25
 */
public class LEETCODE_220_MIDDLE {
    @Test
    public void test() {
        int[] nums = {1, 2, 3, 1};
        System.out.println(containsNearbyAlmostDuplicate(nums, 3, 0));
    }

    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        int n = nums.length;
        TreeSet<Long> set = new TreeSet<>();
        for (int i = 0; i < n; i++) {
            Long ceiling = set.ceiling((long) nums[i] - t);
            if (ceiling != null && ceiling <= (long) nums[i] + t) return true;
            set.add((long) nums[i]);
            if (i >= k) set.remove((long) nums[i - k]);
        }
        return false;
    }
}
