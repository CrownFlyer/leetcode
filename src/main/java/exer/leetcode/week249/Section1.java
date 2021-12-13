package exer.leetcode.week249;

/**
 * @description:
 * @author: ZMC
 * @email: m18996248458@163.com
 * @create: 2021-09-20 15:53
 */
public class Section1 {
    public int[] getConcatenation(int[] nums) {
        int n = nums.length;
        int[] res = new int[2 * n];
        for (int i = 0; i < 2 * n; i++) {
            res[i] = nums[i % n];
        }
        return res;
    }
}
