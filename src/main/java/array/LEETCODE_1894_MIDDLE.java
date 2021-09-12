package array;

/**
 * @description:
 * @author: ZMC
 * @email: m18996248458@163.com
 * @create: 2021-09-10 21:39
 */
public class LEETCODE_1894_MIDDLE {
    public int chalkReplacer(int[] chalk, int k) {
        long sum = 0;
        for (int num : chalk) sum += num;

        k %= sum;

        int idx = 0;
        while (k >= 0) {
            k -= chalk[idx++];
        }

        return idx - 1;
    }
}
