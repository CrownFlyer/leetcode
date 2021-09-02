package exer.leetcode.week255;

import org.junit.Test;

import java.util.HashSet;

/**
 * @description:
 * @author: ZMC
 * @email: m18996248458@163.com
 * @create: 2021-08-22 10:26
 */
public class Section2 {
    @Test
    public void test() {
        String[] nums = {"111","011","001"};
        System.out.println(findDifferentBinaryString(nums));
    }

    public String findDifferentBinaryString(String[] nums) {
        int n = nums[0].length();
        HashSet<Integer> set = new HashSet<>();

        for (String num : nums) {
            int temp = 0;
            for (int i = 0; i < n; i++) {
                temp = (temp << 1) + (num.charAt(i)-'0');
            }
            set.add(temp);
        }
        int i = 0;
        for (i = 0; i < ((1 << n) - 1); i++) {
            if(!set.contains(i)) break;
        }
        StringBuilder sb = new StringBuilder();
        for (int j = 0; j < n; j++) {
            sb.append(i%2);
            i>>=1;
        }
        return sb.reverse().toString();
    }
}
