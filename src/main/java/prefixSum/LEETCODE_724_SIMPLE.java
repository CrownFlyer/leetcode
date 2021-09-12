package prefixSum;

/**
 * @description:
 * @author: ZMC
 * @email: m18996248458@163.com
 * @create: 2021-09-03 09:18
 */
public class LEETCODE_724_SIMPLE {
    public int pivotIndex(int[] nums) {
        int n = nums.length;
        int[] l = new int[n];
        int[] r = new int[n];
        for (int i = 1; i < n; i++) {
            l[i] = l[i - 1] + nums[i - 1];
        }
        for (int i = n - 2; i >= 0; i--) {
            r[i] = r[i + 1] + nums[i + 1];
        }
        for (int i = 0; i < n; i++) {
            if (l[i] == r[i]) return i;
        }
        return -1;
    }
}
