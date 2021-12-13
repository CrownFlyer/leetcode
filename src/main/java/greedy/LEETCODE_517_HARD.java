package greedy;

import java.util.Arrays;

/**
 * @description:
 * @author: ZMC
 * @email: m18996248458@163.com
 * @create: 2021-09-29 12:21
 */
public class LEETCODE_517_HARD {
    public int findMinMoves(int[] machines) {
        int n = machines.length;
        int sum = Arrays.stream(machines).sum();
        if (sum % n != 0) return -1;
        int target = sum / n;

        int res = 0, total = 0;
        for (int machine : machines) {
            machine -= target;
            total += machine;
            res = Math.max(res, Math.max(machine, Math.abs(total)));
        }
        return res;
    }
}
