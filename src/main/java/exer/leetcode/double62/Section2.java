package exer.leetcode.double62;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @description:
 * @author: ZMC
 * @email: m18996248458@163.com
 * @create: 2021-10-04 21:49
 */
public class Section2 {
    @Test
    public void test() {

    }

    public int numOfPairs(String[] nums, String target) {
        Map<String, Integer> map = new HashMap<>();
        for (String num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            String split = target.substring(nums[i].length());
            if (split.equals(target.substring(0, split.length()))) {
                if ((split + split).equals(target)) res += map.get(split) - 1;
                else res += map.getOrDefault(split, 0);
            }
        }
        return res;
    }
}
