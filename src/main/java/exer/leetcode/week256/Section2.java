package exer.leetcode.week256;

import org.junit.Test;

import java.util.Arrays;

/**
 * @description:
 * @author: ZMC
 * @email: m18996248458@163.com
 * @create: 2021-08-29 16:20
 */
public class Section2 {
    @Test
    public void test() {

    }

    public String kthLargestNumber(String[] nums, int k) {
        Arrays.sort(nums, (x, y) -> {
            if (x.length() != y.length()) return y.length() - x.length();
            else return y.compareTo(x);
        });

        return nums[k - 1];
    }
}
