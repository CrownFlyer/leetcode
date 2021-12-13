package exer.test;


/**
 * @description:
 * @author: ZMC
 * @email: m18996248458@163.com
 * @create: 2021-10-29 10:57
 */
public class LEETCODE_335_HARD {
    public boolean isSelfCrossing(int[] d) {
        int n = d.length;
        for (int i = 3; i < n; i++) {
            if (d[i] >= d[i - 2] && d[i - 1] <= d[i - 3]) return true;
            if (i >= 4 && d[i - 1] == d[i - 3] && d[i - 2] <= d[i] + d[i - 4])
                return true;
            if (i >= 5 && d[i - 1] <= d[i - 3] && d[i - 2] > d[i - 4] && d[i - 2] - d[i] <= d[i - 4] && d[i - 5] + d[i - 1] >= d[i - 3])
                return true;
        }
        return false;
    }
}
