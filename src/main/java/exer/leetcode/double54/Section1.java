package exer.leetcode.double54;

/**
 * @description:
 * @author: ZMC
 * @email: m18996248458@163.com
 * @create: 2021-06-12 22:20
 */
public class Section1 {
    public static void main(String[] args) {
        Section1 test = new Section1();
        int[][] r = {{1,1}};
        System.out.println(test.isCovered(r, 1, 50));
    }

    public boolean isCovered(int[][] ranges, int left, int right) {
        for (int i = left; i <= right; i++) {
            if (!cover(ranges, i)) return false;
        }
        return true;
    }

    public boolean cover(int[][] nums, int t) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i][0] <= t && nums[i][1] >= t) return true;
        }
        return false;
    }

}
