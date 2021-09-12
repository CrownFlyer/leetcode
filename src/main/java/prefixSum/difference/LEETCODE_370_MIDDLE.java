package prefixSum.difference;

/**
 * @description:
 * @author: ZMC
 * @email: m18996248458@163.com
 * @create: 2021-09-07 10:15
 */
public class LEETCODE_370_MIDDLE {
    public int[] getModifiedArray(int length, int[][] updates) {
        int[] diff = new int[length];
        int n = updates.length;
        for (int i = 0; i < n; i++) {
            diff[updates[i][0]] += updates[i][2];
            if (updates[i][1] + 1 < length) diff[updates[i][1] + 1] -= updates[i][2];
        }
        for (int i = 1; i < length; i++) {
            diff[i] += diff[i - 1];
        }
        return diff;
    }
}
